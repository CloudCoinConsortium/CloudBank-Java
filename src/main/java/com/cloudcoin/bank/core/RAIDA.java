package com.cloudcoin.bank.core;

import com.cloudcoin.bank.utils.CoinUtils;
import com.cloudcoin.bank.utils.SimpleLogger;
import com.cloudcoin.bank.utils.Utils;
import com.google.gson.Gson;
import org.asynchttpclient.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class RAIDA {


    /* Fields */

    public static RAIDA mainNetwork;
    public static RAIDA activeRAIDA;

    public static FileSystem fileSystem;
    public static SimpleLogger logger;
    private AsyncHttpClient client;

    public static ArrayList<RAIDA> networks = new ArrayList<>();
    public Node[] nodes = new Node[Config.nodeCount];
    public Response[] responseArray = new Response[Config.nodeCount];
    public MultiDetectRequest multiRequest;

    public int networkNumber = 1;

    public int RAIDANumber;
    public String fullUrl;

    public long msServer; // milliseconds for server
    public String ms = ""; //total milliseconds

    public String lastJsonRaFromServer = null;
    public String lastHtml = "empty";//ticket, fail, error
    public String status = "unknown"; //Unknown, slow or ready
    public String msg = "";//message from server

    public static ExecutorService executor = Executors.newFixedThreadPool(25);

    public static RAIDA[] raidaArray = new RAIDA[25];

    public ArrayList<CloudCoin> coins;

    public Response[][] responseArrayMulti;

    public int nodeNumber;
    public Node.MultiDetectResponse MultiResponse = new Node.MultiDetectResponse();


    /* Constructors */

    private RAIDA() {
        for (int i = 0; i < Config.nodeCount; i++) {
            nodes[i] = new Node(i + 1);
        }
    }

    private RAIDA(Network network) {
        nodes = new Node[network.raida.length];
        this.networkNumber = network.nn;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, network.raida[i]);
        }
    }


    /* Methods */

    // Return Main RAIDA Network populated with default Nodes Addresses(Network 1)
    public static RAIDA getInstance() {
        return (mainNetwork != null) ? mainNetwork : new RAIDA();
    }

    public static RAIDA getInstance(Network network) {
        return new RAIDA(network);
    }

    public static void updateLog(String message) {
        System.out.println(message);
        logger.Info(message);
    }

    public ArrayList<CompletableFuture<Response>> getEchoTasks() {
        ArrayList<CompletableFuture<Response>> echoTasks = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            echoTasks.add(nodes[i].Echo());
        }
        return echoTasks;
    }

    /* For Multi-Detect*/
    public CompletableFuture detectOneMulti(int raida_id, int[] nn, int[] sn, String[] an, String[] pan, int[] d, int milliSecondsToTimeOut) {
        return CompletableFuture.supplyAsync(() -> {
            DetectionAgent da = new DetectionAgent(raida_id);

            try {
                Response[] tempArray = nodes[raida_id].MultiDetect(nn, sn, an, pan, d, milliSecondsToTimeOut).get().responses;
                for (int i = 0; i < tempArray.length; i++)
                    responseArrayMulti[raida_id][i] = tempArray[i];
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public CompletableFuture<CloudCoin[]> detectMultiCoin(CloudCoin[] coins, int milliSecondsToTimeOut) {
        responseArrayMulti = new Response[25][coins.length];

        int[] nns = new int[coins.length];
        int[] sns = new int[coins.length];
        String[] ans_0 = new String[coins.length];
        String[] ans_1 = new String[coins.length];
        String[] ans_2 = new String[coins.length];
        String[] ans_3 = new String[coins.length];
        String[] ans_4 = new String[coins.length];
        String[] ans_5 = new String[coins.length];
        String[] ans_6 = new String[coins.length];
        String[] ans_7 = new String[coins.length];
        String[] ans_8 = new String[coins.length];
        String[] ans_9 = new String[coins.length];
        String[] ans_10 = new String[coins.length];
        String[] ans_11 = new String[coins.length];
        String[] ans_12 = new String[coins.length];
        String[] ans_13 = new String[coins.length];
        String[] ans_14 = new String[coins.length];
        String[] ans_15 = new String[coins.length];
        String[] ans_16 = new String[coins.length];
        String[] ans_17 = new String[coins.length];
        String[] ans_18 = new String[coins.length];
        String[] ans_19 = new String[coins.length];
        String[] ans_20 = new String[coins.length];
        String[] ans_21 = new String[coins.length];
        String[] ans_22 = new String[coins.length];
        String[] ans_23 = new String[coins.length];
        String[] ans_24 = new String[coins.length];
        String[] pans_0 = new String[coins.length];
        String[] pans_1 = new String[coins.length];
        String[] pans_2 = new String[coins.length];
        String[] pans_3 = new String[coins.length];
        String[] pans_4 = new String[coins.length];
        String[] pans_5 = new String[coins.length];
        String[] pans_6 = new String[coins.length];
        String[] pans_7 = new String[coins.length];
        String[] pans_8 = new String[coins.length];
        String[] pans_9 = new String[coins.length];
        String[] pans_10 = new String[coins.length];
        String[] pans_11 = new String[coins.length];
        String[] pans_12 = new String[coins.length];
        String[] pans_13 = new String[coins.length];
        String[] pans_14 = new String[coins.length];
        String[] pans_15 = new String[coins.length];
        String[] pans_16 = new String[coins.length];
        String[] pans_17 = new String[coins.length];
        String[] pans_18 = new String[coins.length];
        String[] pans_19 = new String[coins.length];
        String[] pans_20 = new String[coins.length];
        String[] pans_21 = new String[coins.length];
        String[] pans_22 = new String[coins.length];
        String[] pans_23 = new String[coins.length];
        String[] pans_24 = new String[coins.length];

        int[] dens = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            CoinUtils.generatePAN(coins[i]);
            nns[i] = coins[i].getNn();
            sns[i] = coins[i].getSn();
            ans_0[i] = coins[i].getAn().get(0);
            ans_1[i] = coins[i].getAn().get(1);
            ans_2[i] = coins[i].getAn().get(2);
            ans_3[i] = coins[i].getAn().get(3);
            ans_4[i] = coins[i].getAn().get(4);
            ans_5[i] = coins[i].getAn().get(5);
            ans_6[i] = coins[i].getAn().get(6);
            ans_7[i] = coins[i].getAn().get(7);
            ans_8[i] = coins[i].getAn().get(8);
            ans_9[i] = coins[i].getAn().get(9);
            ans_10[i] = coins[i].getAn().get(10);
            ans_11[i] = coins[i].getAn().get(11);
            ans_12[i] = coins[i].getAn().get(12);
            ans_13[i] = coins[i].getAn().get(13);
            ans_14[i] = coins[i].getAn().get(14);
            ans_15[i] = coins[i].getAn().get(15);
            ans_16[i] = coins[i].getAn().get(16);
            ans_17[i] = coins[i].getAn().get(17);
            ans_18[i] = coins[i].getAn().get(18);
            ans_19[i] = coins[i].getAn().get(19);
            ans_20[i] = coins[i].getAn().get(20);
            ans_21[i] = coins[i].getAn().get(21);
            ans_22[i] = coins[i].getAn().get(22);
            ans_23[i] = coins[i].getAn().get(23);
            ans_24[i] = coins[i].getAn().get(24);

            pans_0[i] = coins[i].pan[0];
            pans_1[i] = coins[i].pan[1];
            pans_2[i] = coins[i].pan[2];
            pans_3[i] = coins[i].pan[3];
            pans_4[i] = coins[i].pan[4];
            pans_5[i] = coins[i].pan[5];
            pans_6[i] = coins[i].pan[6];
            pans_7[i] = coins[i].pan[7];
            pans_8[i] = coins[i].pan[8];
            pans_9[i] = coins[i].pan[9];
            pans_10[i] = coins[i].pan[10];
            pans_11[i] = coins[i].pan[11];
            pans_12[i] = coins[i].pan[12];
            pans_13[i] = coins[i].pan[13];
            pans_14[i] = coins[i].pan[14];
            pans_15[i] = coins[i].pan[15];
            pans_16[i] = coins[i].pan[16];
            pans_17[i] = coins[i].pan[17];
            pans_18[i] = coins[i].pan[18];
            pans_19[i] = coins[i].pan[19];
            pans_20[i] = coins[i].pan[20];
            pans_21[i] = coins[i].pan[21];
            pans_22[i] = coins[i].pan[22];
            pans_23[i] = coins[i].pan[23];
            pans_24[i] = coins[i].pan[24];

            dens[i] = CoinUtils.getDenomination(coins[i]);
        }

        CompletableFuture t00 = detectOneMulti(0, nns, sns, ans_0, pans_0, dens, milliSecondsToTimeOut);
        CompletableFuture t01 = detectOneMulti(1, nns, sns, ans_1, pans_1, dens, milliSecondsToTimeOut);
        CompletableFuture t02 = detectOneMulti(2, nns, sns, ans_2, pans_2, dens, milliSecondsToTimeOut);
        CompletableFuture t03 = detectOneMulti(3, nns, sns, ans_3, pans_3, dens, milliSecondsToTimeOut);
        CompletableFuture t04 = detectOneMulti(4, nns, sns, ans_4, pans_4, dens, milliSecondsToTimeOut);
        CompletableFuture t05 = detectOneMulti(5, nns, sns, ans_5, pans_5, dens, milliSecondsToTimeOut);
        CompletableFuture t06 = detectOneMulti(6, nns, sns, ans_6, pans_6, dens, milliSecondsToTimeOut);
        CompletableFuture t07 = detectOneMulti(7, nns, sns, ans_7, pans_7, dens, milliSecondsToTimeOut);
        CompletableFuture t08 = detectOneMulti(8, nns, sns, ans_8, pans_8, dens, milliSecondsToTimeOut);
        CompletableFuture t09 = detectOneMulti(9, nns, sns, ans_9, pans_9, dens, milliSecondsToTimeOut);
        CompletableFuture t10 = detectOneMulti(10, nns, sns, ans_10, pans_10, dens, milliSecondsToTimeOut);
        CompletableFuture t11 = detectOneMulti(11, nns, sns, ans_11, pans_11, dens, milliSecondsToTimeOut);
        CompletableFuture t12 = detectOneMulti(12, nns, sns, ans_12, pans_12, dens, milliSecondsToTimeOut);
        CompletableFuture t13 = detectOneMulti(13, nns, sns, ans_13, pans_13, dens, milliSecondsToTimeOut);
        CompletableFuture t14 = detectOneMulti(14, nns, sns, ans_14, pans_14, dens, milliSecondsToTimeOut);
        CompletableFuture t15 = detectOneMulti(15, nns, sns, ans_15, pans_15, dens, milliSecondsToTimeOut);
        CompletableFuture t16 = detectOneMulti(16, nns, sns, ans_16, pans_16, dens, milliSecondsToTimeOut);
        CompletableFuture t17 = detectOneMulti(17, nns, sns, ans_17, pans_17, dens, milliSecondsToTimeOut);
        CompletableFuture t18 = detectOneMulti(18, nns, sns, ans_18, pans_18, dens, milliSecondsToTimeOut);
        CompletableFuture t19 = detectOneMulti(19, nns, sns, ans_19, pans_19, dens, milliSecondsToTimeOut);
        CompletableFuture t20 = detectOneMulti(20, nns, sns, ans_20, pans_20, dens, milliSecondsToTimeOut);
        CompletableFuture t21 = detectOneMulti(21, nns, sns, ans_21, pans_21, dens, milliSecondsToTimeOut);
        CompletableFuture t22 = detectOneMulti(22, nns, sns, ans_22, pans_22, dens, milliSecondsToTimeOut);
        CompletableFuture t23 = detectOneMulti(23, nns, sns, ans_23, pans_23, dens, milliSecondsToTimeOut);
        CompletableFuture t24 = detectOneMulti(24, nns, sns, ans_24, pans_24, dens, milliSecondsToTimeOut);

        ArrayList<CompletableFuture> taskList = new ArrayList<>(Arrays.asList(t00, t01, t02, t03, t04, t05, t06, t07, t08, t09, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24));

        try {
            System.out.println("Waiting for futures...");
            CompletableFuture.allOf(taskList.toArray(new CompletableFuture[0])).get();
        } catch (Exception e) {
            System.out.println("RAIDA#PNC:" + e.getLocalizedMessage());
        }

        //Get data from the detection agents
        /*for (int i = 0; i < nns.length; i++)
        {
            for (int j = 0; j<25; j++) {//For each coin
                if (responseArrayMulti[j][i] != null)
                {
                    coins[i].setPastStatus(responseArrayMulti[j][i].outcome, j);
                    System.out.println(coins[i].getSn() + " detect:" + j + " " + responseArrayMulti[j][i].fullResponse);
                }
                    else
                {
                    coins[i].setPastStatus("undetected", j);
                };// should be pass, fail, error or undetected, or No response.
            }//end for each coin checked

            coins[i].setAnsToPansIfPassed();
            coins[i].calculateHP();
            coins[i].calcExpirationDate();
            coins[i].grade();
        }//end for each detection agent*/

        return null;//Return the array of coins detected
    }//end detect coin

    public int getReadyCount() {
        int counter = 0;
        for (Node node : nodes) {
            if (Node.NodeStatus.Ready == node.RAIDANodeStatus)
                counter++;
        }
        return counter;
    }
    public int getNotReadyCount() {
        int counter = 0;
        for (Node node : nodes) {
            if (Node.NodeStatus.NotReady == node.RAIDANodeStatus)
                counter++;
        }
        return counter;
    }
}
