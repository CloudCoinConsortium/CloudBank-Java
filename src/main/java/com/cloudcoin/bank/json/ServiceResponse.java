package com.cloudcoin.bank.json;

import com.cloudcoin.bank.utils.Utils;

public class ServiceResponse {

    public String bankServer;
    public String status;
    public String version = "2.0";
    public String time = Utils.getDate();
    public String message;

    public String readyCount;
    public String notReadyCount;
}
