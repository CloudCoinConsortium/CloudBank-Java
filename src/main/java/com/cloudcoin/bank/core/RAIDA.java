package com.cloudcoin.bank.core;

import com.cloudcoin.bank.utils.SimpleLogger;
import com.cloudcoin.bank.utils.Utils;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RAIDA {


    /* Fields */

    public static RAIDA mainNetwork;
    public static RAIDA activeRAIDA;

    public static FileSystem fileSystem;
    public static SimpleLogger logger;

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

    /** Prepares 25 ping tests to RAIDA severs*/
    public static void initializeRaidaEcho() {
        List<Callable<Void>> taskList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            final int index = i;

            Callable<Void> callable = () -> {
                raidaArray[index].echo();
                System.out.print("." + index);
                return null;
            };
            taskList.add(callable);
        }

        try {
            List<Future<Void>> futureList = executor.invokeAll(taskList);

            for (Future<Void> voidFuture : futureList) {
                try {
                    voidFuture.get(100, TimeUnit.MILLISECONDS);
                } catch (ExecutionException e) {
                    System.out.println("Error executing task " + e.getMessage());
                } catch (TimeoutException e) {
                    System.out.println("Timed out executing task" + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Sends an echo to each RAIDA server and logs the results. */
    public static void testRaidaEcho() {
        System.out.println("\nEchoing RAIDA.\n");

        initializeRaidaEcho();

        StringBuilder masterFile = new StringBuilder();
        //Logger.emptyFolder("Echo");

        for (int i = 0; i < 25; i++) {
            masterFile.append(raidaArray[i].lastJsonRaFromServer);
            masterFile.append("<br>");
            //Logger.logFile("Echo", i + "." + raidaArray[i].status + "." + raidaArray[i].msServer + "." +
            //        raidaArray[i].ms + ".log", raidaArray[i].lastJsonRaFromServer.getBytes());
            System.out.println("RAIDA" + i + ": " + raidaArray[i].status + ", ms:" + raidaArray[i].ms);
        }

        //Logger.logFile("Echo", "echo_log.html", masterFile.toString().getBytes());
    }

    public String echo() {
        String html = "";
        String url = this.fullUrl + "echo";
        long start;

        try {
            html = Utils.getHtmlFromURL(url);//getHtml(url);
            this.lastJsonRaFromServer = html;

            start = System.nanoTime();

            JSONObject json = new JSONObject(html);
            this.msg = json.getString("message");
            this.msServer = (long) (1000f * Float.valueOf(msg.substring(msg.lastIndexOf('=') + 2)));
        } catch (JSONException | NumberFormatException e) {
            this.status = "error";
            start = System.nanoTime();
            System.out.println("Error: html response for " + fullUrl + " does not contain a valid message response: " + html);
            e.printStackTrace();
        }

        boolean isReady = html.contains("ready");
        this.status = (isReady) ? "ready" : "error";

        long end = System.nanoTime();
        this.ms = "" + new DecimalFormat("####.###").format((end - start) * 0.000001f);

        return this.status;
    }

    public int ReadyCount() {
        int counter = 0;
        for (Node node : nodes) {
            if node.
        }
    }
    public int NotReadyCount() { return nodes.Where(x => x.RAIDANodeStatus == NodeStatus.NotReady).Count(); } }
}
