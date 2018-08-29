package com.cloudcoin.bank.core;

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


    /* Fields */

    public enum TicketHistory {Untried, Failed, Success}

    //private AsyncHttpClient client;
    private Gson gson;

    public int nodeNumber;
    public String fullUrl;
    public MultiDetectResponse multiResponse = new MultiDetectResponse();

    public boolean failsDetect;
    public boolean failsFix;
    public boolean failsEcho;

    public TicketHistory ticketHistory = TicketHistory.Untried;
    public String ticket = "";
    public boolean hasTicket;


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
