package com.cloudcoin.bank.core;

import com.cloudcoin.bank.utils.CoinUtils;
import com.cloudcoin.bank.utils.FileUtils;
import com.cloudcoin.bank.utils.Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class MultiDetect {

    public CompletableFuture detectMulti(String receiptFilename, String folderPath) {
        return CompletableFuture.supplyAsync(() -> {
            boolean stillHaveSuspect = true;
            int coinNames = 0;

            while (stillHaveSuspect) {
                String[] suspectFileNames = FileUtils.selectFileNamesInFolder(folderPath + FileSystem.SuspectPath);

                for (String suspectFileName : suspectFileNames) {
                    try {
                        if (Files.exists(Paths.get(folderPath + FileSystem.BankPath + suspectFileName)) ||
                                Files.exists(Paths.get(folderPath + FileSystem.DetectedPath + suspectFileName)))
                            FileSystem.moveFile(suspectFileName, folderPath + FileSystem.SuspectPath, folderPath + FileSystem.TrashPath, false);
                    } catch (SecurityException ex) {
                        ex.printStackTrace();
                    }
                }
                suspectFileNames = FileUtils.selectFileNamesInFolder(folderPath + FileSystem.SuspectPath);

                coinNames = Math.min(suspectFileNames.length, 200);
                if (suspectFileNames.length <= 200)
                    stillHaveSuspect = false;

                CloudCoin[] coins = new CloudCoin[coinNames];
                Receipt receipt = createReceipt(coinNames, receiptFilename);

                for (int i = 0; i < coinNames; i++) {
                    System.out.println("md dm: file: " + folderPath + FileSystem.SuspectPath + suspectFileNames[i]);
                    coins[i] = FileUtils.loadCloudCoinsFromStack(folderPath + FileSystem.SuspectPath + suspectFileNames[i]).get(0);
                    System.out.println("  Now scanning coin " + (i + 1) + " of " + suspectFileNames.length + " for counterfeit. SN 0:" + coins[i].getSn() + ", Denomination: " + CoinUtils.getDenomination(coins[i]));
                    ReceiptDetail detail = new ReceiptDetail();
                    detail.sn = coins[i].getSn();
                    detail.nn = coins[i].getNn();
                    detail.status = "suspect";
                    detail.pown = "uuuuuuuuuuuuuuuuuuuuuuuuu";
                    detail.note = "Waiting";
                    receipt.rd[i] = detail;
                }

                RAIDA raida = RAIDA.getInstance();
                int[] nns = new int[coins.length];
                int[] sns = new int[coins.length];
                String[][] ans = new String[Config.nodeCount][];
                String[][] pans = new String[Config.nodeCount][];

                int[] dens = new int[coins.length]; // Denominations

                for (int i = 0; i < coins.length; i++) {
                    CloudCoin coin = coins[i];
                    CoinUtils.generatePAN(coin);
                    nns[i] = coin.getNn();
                    sns[i] = coin.getSn();
                    dens[i] = CoinUtils.getDenomination(coin);
                }
                try {
                    raida.multiRequest = new MultiDetectRequest();
                    raida.multiRequest.timeout = Config.milliSecondsToTimeOut;
                    for (int nodeNumber = 0; nodeNumber < Config.nodeCount; nodeNumber++) {
                        ans[nodeNumber] = new String[coins.length];
                        pans[nodeNumber] = new String[coins.length];

                        for (int i = 0; i < coins.length; i++) {
                            ans[nodeNumber][i] = coins[i].getAn().get(nodeNumber);
                            pans[nodeNumber][i] = coins[i].pan[nodeNumber];
                        }
                        raida.multiRequest.an[nodeNumber] = ans[nodeNumber];
                        raida.multiRequest.pan[nodeNumber] = pans[nodeNumber];
                        raida.multiRequest.nn = nns;
                        raida.multiRequest.sn = sns;
                        raida.multiRequest.d = dens;
                    }
                } catch (Exception e) {
                    System.out.println("/0" + e.getLocalizedMessage());
                    e.printStackTrace();
                }

                ArrayList<CompletableFuture<Node.MultiDetectResponse>> detectTasks = new ArrayList<>();
                for (int nodeNumber = 0; nodeNumber < Config.nodeCount; nodeNumber++) {
                    detectTasks.add(raida.nodes[nodeNumber].MultiDetect());
                }

                try {
                    System.out.println("Waiting for futures...");
                    CompletableFuture.allOf(detectTasks.toArray(new CompletableFuture[0])).get();
                } catch (Exception e) {
                    System.out.println("RAIDA#PNC:" + e.getLocalizedMessage());
                }

                try {
                    String json = Utils.createGson().toJson(receipt);
                    Files.write(Paths.get(folderPath + FileSystem.ReceiptsPath + receiptFilename + ".json"), json.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    try {
                        System.out.println("Waiting for futures...");
                        CompletableFuture.allOf(detectTasks.toArray(new CompletableFuture[0])).get();
                    } catch (Exception e) {
                        System.out.println("RAIDA#PNC:" + e.getLocalizedMessage());
                    }

                    for (int j = 0; j < coins.length; j++) {
                        CloudCoin coin = coins[j];
                        StringBuilder pownString = new StringBuilder();
                        coin.setPown("");
                        for (int k = 0; k < Config.nodeCount; k++)
                            pownString.append(raida.nodes[k].MultiResponse.responses[j].outcome, 0, 1);
                        coin.setPown(pownString.toString());
                    }
                    String filename = CoinUtils.generateFilename(coins[0]);
                    filename = FileUtils.ensureFilepathUnique(filename, ".stack", folderPath + FileSystem.DetectedPath);
                    FileSystem.writeCoinsToSingleStack(coins, filename);
                    FileSystem.removeCoins(coins, folderPath + FileSystem.SuspectPath);
                } catch (Exception e) {
                    System.out.println("RAIDA#PNC: " + e.getLocalizedMessage());
                }
            }
            return "";
        });
    }

    Receipt createReceipt(int length, String id) {
        Receipt receipt = new Receipt();
        receipt.time = new SimpleDateFormat("yyyy-MM-dd h:mm:ss").format(new Date());
        receipt.timezone = "UTC" + ZoneOffset.systemDefault().getRules().getOffset(Instant.now()).toString();
        receipt.bank_server = "localhost";
        receipt.total_authentic = 0;
        receipt.total_fracked = 0;
        receipt.total_counterfeit = 0;
        receipt.total_lost = 0;
        receipt.receipt_id = id;
        receipt.rd = new ReceiptDetail[length];
        return receipt;
    }
}
