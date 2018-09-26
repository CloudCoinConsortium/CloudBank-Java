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

    public CompletableFuture<MultiDetectResult> detectMulti(String receiptFilename, String folderPath) {
        return CompletableFuture.supplyAsync(() -> {
            boolean stillHaveSuspect = true;
            int coinNames = 0;

            MultiDetectResult result = new MultiDetectResult();

            while (stillHaveSuspect) {
                String[] suspectFileNames = FileUtils.selectFileNamesInFolder(folderPath + FileSystem.SuspectPath);

                for (String suspectFileName : suspectFileNames) {
                    try {
                        if (Files.exists(Paths.get(folderPath + FileSystem.BankPath + suspectFileName)) ||
                                Files.exists(Paths.get(folderPath + FileSystem.FrackedPath + suspectFileName)) ||
                                Files.exists(Paths.get(folderPath + FileSystem.DetectedPath + suspectFileName)))
                            FileSystem.moveFile(suspectFileName, folderPath + FileSystem.SuspectPath, folderPath + FileSystem.TrashPath, false);
                    } catch (SecurityException ex) {
                        ex.printStackTrace();
                    }
                }

                suspectFileNames = FileUtils.selectFileNamesInFolder(folderPath + FileSystem.SuspectPath);
                if (suspectFileNames.length == 0)
                    return result;

                if (result.cloudCoins.size() == 0)
                    result.cloudCoins = new ArrayList<>(suspectFileNames.length);

                coinNames = Math.min(suspectFileNames.length, Config.multiDetectLoad);
                if (suspectFileNames.length <= Config.multiDetectLoad)
                    stillHaveSuspect = false;

                ArrayList<CloudCoin> coins = new ArrayList<>(coinNames);
                Receipt receipt = createReceipt(coinNames, receiptFilename);

                for (int i = 0; i < coinNames; i++) {
                    System.out.println("md dm: file: " + folderPath + FileSystem.SuspectPath + suspectFileNames[i]);
                    coins.add(FileUtils.loadCloudCoinsFromStack(folderPath + FileSystem.SuspectPath + suspectFileNames[i]).get(0));
                    System.out.println("  Now scanning coin " + (i + 1) + " of " + suspectFileNames.length + " for counterfeit. SN 0:" + coins.get(i).getSn() + ", Denomination: " + CoinUtils.getDenomination(coins.get(i)));
                    ReceiptDetail detail = new ReceiptDetail();
                    detail.sn = coins.get(i).getSn();
                    detail.nn = coins.get(i).getNn();
                    detail.status = "suspect";
                    detail.pown = "uuuuuuuuuuuuuuuuuuuuuuuuu";
                    detail.note = "Waiting";
                    receipt.rd[i] = detail;
                }

                try {
                    String json = Utils.createGson().toJson(receipt);
                    Files.write(Paths.get(folderPath + FileSystem.ReceiptsPath + receiptFilename + ".json"), json.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                RAIDA raida = RAIDA.getInstance();
                int[] nns = new int[coins.size()];
                int[] sns = new int[coins.size()];
                String[][] ans = new String[Config.nodeCount][];
                String[][] pans = new String[Config.nodeCount][];

                int[] dens = new int[coins.size()]; // Denominations

                for (int i = 0; i < coins.size(); i++) {
                    CloudCoin coin = coins.get(i);
                    CoinUtils.generatePAN(coin);
                    nns[i] = coin.getNn();
                    sns[i] = coin.getSn();
                    dens[i] = CoinUtils.getDenomination(coin);
                }
                try {
                    raida.multiRequest = new MultiDetectRequest();
                    raida.multiRequest.timeout = Config.milliSecondsToTimeOut;
                    for (int nodeNumber = 0; nodeNumber < Config.nodeCount; nodeNumber++) {
                        ans[nodeNumber] = new String[coins.size()];
                        pans[nodeNumber] = new String[coins.size()];

                        for (int i = 0; i < coins.size(); i++) {
                            ans[nodeNumber][i] = coins.get(i).getAn().get(nodeNumber);
                            pans[nodeNumber][i] = coins.get(i).pan[nodeNumber];
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
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("RAIDA#PNC#NODES: " + e.getLocalizedMessage());
                }

                try {
                    for (int j = 0; j < coins.size(); j++) {
                        CloudCoin coin = coins.get(j);
                        coin.setFolder(folderPath + FileSystem.DetectedPath);
                        StringBuilder pownString = new StringBuilder();
                        coin.setPown("");
                        for (int k = 0; k < Config.nodeCount; k++)
                            pownString.append(raida.nodes[k].MultiResponse.responses[j].outcome, 0, 1);
                        coin.setPown(pownString.toString());
                        CoinUtils.setAnsToPans(coin);
                    }
                    FileSystem.writeCoinsToIndividualStacks(coins, folderPath + FileSystem.DetectedPath);
                    FileSystem.removeCoins(coins, folderPath + FileSystem.SuspectPath);

                    for (int i = 0; i < coins.size(); i++) {
                        CloudCoin coin = coins.get(i);
                        ReceiptDetail detail = new ReceiptDetail();
                        detail.sn = coin.getSn();
                        detail.nn = coin.getNn();
                        detail.status = CoinUtils.getDetectionResult(coin);
                        detail.pown = coin.getPown();
                        detail.note = "Deposit complete";
                        receipt.rd[i] = detail;
                    }

                    try {
                        String json = Utils.createGson().toJson(receipt);
                        Files.write(Paths.get(folderPath + FileSystem.ReceiptsPath + receiptFilename + ".json"), json.getBytes(StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    result.receipt = receiptFilename;
                    result.cloudCoins.addAll(coins);
                } catch (Exception e) {
                    System.out.println("RAIDA#PNC: " + e.getLocalizedMessage());
                }
            }
            return result;
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
