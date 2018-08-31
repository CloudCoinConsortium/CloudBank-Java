package com.cloudcoin.bank.core;

import com.cloudcoin.bank.json.ServiceResponse;
import com.cloudcoin.bank.utils.Utils;
import com.google.gson.Gson;
import org.asynchttpclient.*;
//import org.asynchttpclient.*;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

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

    private AsyncHttpClient client;
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


    public MultiDetectResponse MultiResponse = new MultiDetectResponse();


    /* Constructors */

    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        fullUrl = getFullURL();
        System.out.println(fullUrl);

        client = asyncHttpClient();
        gson = Utils.createGson();
    }

    public Node(int nodeNumber, RAIDANode node) {
        this.nodeNumber = nodeNumber;
        fullUrl = "https://" + node.urls[0].url + "/service/";

        client = asyncHttpClient();
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
                //System.out.println("Echo URL - "+ fullUrl);
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

    //int[] nn, int[] sn, String[] an, String[] pan, int[] d, int timeout
    public CompletableFuture<MultiDetectResponse> MultiDetect() {
        /*PREPARE REQUEST*/
        RAIDA raida = RAIDA.getInstance();
        int[] nn = raida.multiRequest.nn;
        int[] sn = raida.multiRequest.sn;
        String[] an = raida.multiRequest.an[nodeNumber - 1];
        String[] pan = raida.multiRequest.pan[nodeNumber - 1];
        int[] d = raida.multiRequest.d;
        int timeout = raida.multiRequest.timeout;

        return MultiDetect(nn, sn, an, pan, d, timeout);
    }

    public CompletableFuture<MultiDetectResponse> MultiDetect(int[] nn, int[] sn, String[] an, String[] pan, int[] d, int timeout) {
        Response[] response = new Response[nn.length];
        for (int i = 0; i < nn.length; i++) {
            response[i] = new Response();
        }

        ArrayList<Param> formParams = new ArrayList<>();
        for (int i = 0; i < nn.length; i++) {
            formParams.add(new Param("nns[]", Integer.toString(nn[i])));
            formParams.add(new Param("sns[]", Integer.toString(sn[i])));
            formParams.add(new Param("ans[]", an[i]));
            formParams.add(new Param("pans[]", an[i]));
            formParams.add(new Param("denomination[]", Integer.toString(d[i])));
            // System.out.println("url is " + this.fullUrl + "detect?nns[]=" + nn[i] + "&sns[]=" + sn[i] + "&ans[]=" + an[i] + "&pans[]=" + pan[i] + "&denomination[]=" + d[i]);
            response[i].fullRequest = this.fullUrl + "detect?nns[]=" + nn[i] + "&sns[]=" + sn[i] + "&ans[]=" + an[i] + "&pans[]=" + pan[i] + "&denomination[]=" + d[i]; // Record what was sent
        }

        /* MAKE REQUEST */
        final long before = System.currentTimeMillis();

        return client.preparePost(fullUrl + "multi_detect")
                .setFormParams(formParams)
                .setRequestTimeout(timeout)
                .execute(new AsyncHandler() {
                    private final org.asynchttpclient.Response.ResponseBuilder builder = new org.asynchttpclient.Response.ResponseBuilder();

                    @Override
                    public State onStatusReceived(HttpResponseStatus responseStatus) {
                        builder.accumulate(responseStatus);
                        return State.CONTINUE;
                    }

                    @Override
                    public State onHeadersReceived(HttpResponseHeaders headers) {
                        builder.accumulate(headers);
                        return State.CONTINUE;
                    }

                    @Override
                    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) {
                        builder.accumulate(bodyPart);
                        return State.CONTINUE;
                    }

                    @Override
                    public MultiDetectResponse onCompleted() {
                        /* MAKE REQUEST */
                        long after, ts;

                        org.asynchttpclient.Response httpResponse = builder.build();
                        String totalResponse = httpResponse.getResponseBody();
                        try {
                            if (200 == builder.build().getStatusCode()) {
                                /* PROCESS REQUEST*/
                                after = System.currentTimeMillis();
                                ts = after - before;

                                try {
                                    System.out.println("Response: " + totalResponse);
                                    DetectResponse[] responses = gson.fromJson(totalResponse, DetectResponse[].class);

                                    for (int i = 0; i < nn.length; i++) {
                                        response[i].fullResponse = totalResponse;
                                        response[i].success = "pass".equals(responses[i].status);
                                        response[i].outcome = responses[i].status;
                                    }
                                } catch (Exception e) {
                                    System.out.println("/4: " + e.getLocalizedMessage() + httpResponse.getUri().toUrl());
                                    for (int i = 0; i < nn.length; i++) {
                                        response[i].fullResponse = totalResponse;
                                        response[i].outcome = "e";
                                    }
                                }

                                MultiResponse.responses = response;
                                return MultiResponse;
                            } else { // 404 not found or 500 error.
                                System.out.println("RAIDA " + nodeNumber + " had an error: " + httpResponse.getStatusCode());
                                after = System.currentTimeMillis();
                                ts = after - before;

                                for (int i = 0; i < nn.length; i++) {
                                    response[i].outcome = "error";
                                    response[i].fullResponse = Integer.toString(httpResponse.getStatusCode());
                                }
                                MultiResponse.responses = response;
                                return MultiResponse;
                            }
                        } catch (Exception e) {
                            System.out.println("Exception: " + e.getLocalizedMessage());
                            e.printStackTrace();
                        }
                        return MultiResponse;
                    }

                    @Override
                    public void onThrowable(Throwable e) {
                        long after = System.currentTimeMillis();
                        long ts = after - before;

                        switch (e.getClass().getCanonicalName()) {
                            case "TimeoutException":
                                for (int i = 0; i < nn.length; i++) {
                                    response[i].outcome = "noresponse";
                                    response[i].fullResponse = e.getLocalizedMessage();
                                }
                                MultiResponse.responses = response;
                                return;
                            default:
                                System.out.println("Node#MD" + e.getLocalizedMessage());
                                for (int i = 0; i < nn.length; i++) {
                                    response[i].outcome = "error";
                                    response[i].fullResponse = e.getLocalizedMessage();
                                }
                                MultiResponse.responses = response;
                                return;
                        }
                    }
                }).toCompletableFuture();
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

    public static class MultiDetectResponse {
        public Response[] responses;
    }

    public boolean isFailed() {
        return failsEcho || failsDetect;
    }
}
