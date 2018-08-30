package com.cloudcoin.bank.core;

import com.cloudcoin.bank.json.ServiceResponse;
import com.cloudcoin.bank.utils.Utils;
import com.google.gson.Gson;
//import org.asynchttpclient.*;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

//import static org.asynchttpclient.Dsl.asyncHttpClient;

/**
 * This Class Contains the properties of a RAIDA node.
 */
public class Node {

    public enum NodeStatus {
        Ready,
        NotReady,
    }


    /* Fields */

    public enum TicketHistory {Untried, Failed, Success}

    //private AsyncHttpClient client;
    private Gson gson;

    public int nodeNumber;
    public String fullUrl;
    public MultiDetectResponse multiResponse = new MultiDetectResponse();

    public boolean failsDetect;
    public boolean failsEcho;

    public TicketHistory ticketHistory = TicketHistory.Untried;
    public String ticket = "";
    public boolean hasTicket;

    public NodeStatus RAIDANodeStatus = NodeStatus.NotReady;
    public ServiceResponse echoresult;
    public ServiceResponse echoresponse;
    public int echoTime = 0;


    /* Constructors */

    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        fullUrl = getFullURL();
        System.out.println(fullUrl);

        //client = asyncHttpClient();
        gson = Utils.createGson();
    }

    public Node(int nodeNumber, RAIDANode node) {
        this.nodeNumber = nodeNumber;
        fullUrl = "https://" + node.urls[0].url + "/service/";

        //client = asyncHttpClient();
        gson = Utils.createGson();
    }


    /* Methods */

    public CompletableFuture<Response> Echo() {
        return CompletableFuture.supplyAsync(() -> {
            Response echoResponse = new Response();
            echoResponse.fullRequest = this.fullUrl + "echo";
            long before = System.currentTimeMillis();
            failsEcho = true;
            try {
                echoResponse.fullResponse = Utils.getHtmlFromURL(echoResponse.fullRequest);
                System.out.println("Echo From Node - " + nodeNumber + ". " + echoResponse.fullResponse);
                try {
                    echoresult = Utils.createGson().fromJson(echoResponse.fullResponse, ServiceResponse.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println("Echo URL - "+ FullUrl);
                if (echoResponse.fullResponse.contains("ready")) {
                    echoResponse.success = true;
                    echoResponse.outcome = "ready";
                    this.RAIDANodeStatus = NodeStatus.Ready;
                    failsEcho = false;
                } else {
                    this.RAIDANodeStatus = NodeStatus.NotReady;
                    echoResponse.success = false;
                    echoResponse.outcome = "error";
                    failsEcho = true;
                }
            } catch (Exception ex) {
                echoResponse.outcome = "error";
                echoResponse.success = false;
                this.RAIDANodeStatus = NodeStatus.NotReady;
                failsEcho = true;
                if (ex.getMessage() != null)
                    echoResponse.fullResponse = ex.getMessage();
                System.out.println("Error---" + ex.getMessage());
            }
            long after = System.currentTimeMillis();
            long ts = after - before;
            echoResponse.milliseconds = (int) ts;
            echoTime = (int) ts;
            //System.out.println("Echo Complete-Node No.-" + NodeNumber + ".Status-" + RAIDANodeStatus);
            return echoResponse;
        });
    }

    public String getFullURL() {
        return "https://raida" + (nodeNumber - 1) + ".cloudcoin.global/service/";
    }

    public void resetTicket() {
        hasTicket = false;
        ticketHistory = TicketHistory.Untried;
        ticket = "";
    }

    public void newCoin() {
        hasTicket = false;
        ticketHistory = TicketHistory.Untried;
        ticket = "";
        failsDetect = false;
    }

    public class MultiDetectResponse {
        public Response[] responses;
    }

    public boolean isFailed() {
        return failsEcho || failsDetect;
    }
}
