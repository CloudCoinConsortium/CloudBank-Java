package com.cloudcoin.bank.core;

public class DetectionAgent {


    public int RAIDANumber;
    public String fullUrl;


    public DetectionAgent(int RAIDANumber) {
        this.RAIDANumber = RAIDANumber;
        fullUrl = "https://RAIDA" + RAIDANumber + ".cloudcoin.global/service/";
    }
}
