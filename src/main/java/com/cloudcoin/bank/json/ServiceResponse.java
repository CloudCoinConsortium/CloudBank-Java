package com.cloudcoin.bank.json;

import com.cloudcoin.bank.utils.Utils;

public class ServiceResponse {


    /* Standard JSON Fields */

    public String bankServer;
    public String status = "fail";
    public String version = "2.0";
    public String time = Utils.getDate();
    public String message = "NO ERROR MESSAGE";


    /* Account Fields */

    public String account;
    public Integer ones;
    public Integer fives;
    public Integer twentyfives;
    public Integer hundreds;
    public Integer twohundredfifties;


    /* Transaction Fields */

    public String receipt;


    /* Node Fields */

    public String readyCount;
    public String notReadyCount;
}
