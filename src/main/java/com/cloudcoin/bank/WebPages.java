package com.cloudcoin.bank;

import com.cloudcoin.bank.core.*;
import com.cloudcoin.bank.json.ServiceResponse;
import com.cloudcoin.bank.utils.CoinUtils;
import com.cloudcoin.bank.utils.FileUtils;
import com.cloudcoin.bank.utils.Utils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class WebPages {


    /* Web Pages */

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/print_welcome")
    public String print_welcome() {
        ServiceResponse response = new ServiceResponse();

        response.bankServer = "localhost";
        response.status = "welcome";
        response.message = "CloudCoin Bank. Used to Authenticate, Store and Payout CloudCoins." +
                "This Software is provided as is with all faults, defects and errors, and without warranty of any kind." +
                "Free from the CloudCoin Consortium.";
        return Utils.createGson().toJson(response);
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo(@RequestParam(required = false, value = "account") String account,
                       @RequestParam(required = false, value = "pk") String key) {
        String badLogin = isAccountValid(account, key);
        if (badLogin != null)
            return badLogin;

        return EchoRaida();
    }

    @RequestMapping(value = "/show_coins", method = RequestMethod.GET)
    public String show_coins(@RequestParam(required = false, value = "account") String account,
                             @RequestParam(required = false, value = "pk") String key) {
        String badLogin = isAccountValid(account, key);
        if (badLogin != null)
            return badLogin;

        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";

        String accountFolder = FileSystem.AccountFolder + key;
        int[] bankTotals = Banker.countCoins(accountFolder + FileSystem.BankPath);
        int[] frackedTotals = Banker.countCoins(accountFolder + FileSystem.FrackedPath);

        response.ones = bankTotals[1] + frackedTotals[1];
        response.fives = bankTotals[2] + frackedTotals[2];
        response.twentyfives = bankTotals[3] + frackedTotals[3];
        response.hundreds = bankTotals[4] + frackedTotals[4];
        response.twohundredfifties = bankTotals[5] + frackedTotals[5];
        response.status = "coins_shown";
        response.message = "Coin totals returned.";

        return Utils.createGson().toJson(response);
    }

    @RequestMapping(value = "/deposit_one_stack", method = { RequestMethod.POST, RequestMethod.GET })
    public String depositStack(@RequestParam(required = false, value = "account") String account,
                               @RequestParam(required = false, value = "pk") String key,
                               @RequestParam(required = false, value = "stack") String stack) {
        String badLogin = isAccountValid(account, key);
        if (badLogin != null)
            return badLogin;

        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";

        if (stack == null || stack.length() == 0) {
            response.message = "The CloudCoin stack was empty or not included in the post.";
            response.status = "error";
            response.receipt = "";
            return Utils.createGson().toJson(response);
        }

        ArrayList<CloudCoin> coins = FileUtils.loadCloudCoinsFromStackJson(stack);
        byte[] stackBytes = stack.getBytes(StandardCharsets.UTF_8);
        String accountFolder = FileSystem.AccountFolder + key;

        try {
            if (coins == null || coins.size() == 0)
                Files.write(Paths.get(accountFolder + FileSystem.TrashPath + new Date().toString()), stackBytes);
            else
                FileSystem.writeCoinsToSingleStack(coins, accountFolder + FileSystem.SuspectPath + CoinUtils.generateFilename(coins.get(0)));
        } catch (IOException e) {
            e.printStackTrace();
            coins = null;
        }

        if (coins == null || coins.size() == 0) {
            response.status = "error";
            response.message = "Error: coins were valid.";
            response.receipt = "";
            return Utils.createGson().toJson(response);
        }

        String detectResponse = detect(accountFolder);
        if (detectResponse != null)
            return detectResponse;

        response.message = "There was a server error, try again later.";
        response.status = "error";
        return Utils.createGson().toJson(response);
    }


    /* Methods */

    String isAccountValid(String account, String key) {
        ServiceResponse response = new ServiceResponse();
        try {
            response.bankServer = "localhost";

            if (key == null || account == null) {
                response.message = "Request Error: Private key or Account not specified.";
                return Utils.createGson().toJson(response);
            }

            String text;
            text = new String(Files.readAllBytes(Paths.get(FileSystem.PasswordFolder + account + ".txt")), StandardCharsets.UTF_8);

            if (!text.equals(key)) {
                response.message = "Private key not correct.";
                response.account = account;
                return Utils.createGson().toJson(response);
            }
        } catch (IOException e) {
            response.message = "Request Error: Private key or Account not found.";
            e.printStackTrace();
            return Utils.createGson().toJson(response);
        }

        return null;
    }

    public String EchoRaida() {
        RAIDA raida = RAIDA.getInstance();
        ArrayList<CompletableFuture<Response>> tasks = raida.getEchoTasks();
        try {
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).get();
        } catch (Exception e) {
            System.out.println("RAIDA#PNC:" + e.getLocalizedMessage());
        }

        int readyCount = raida.getReadyCount();

        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";
        response.time = Utils.getDate();
        response.readyCount = Integer.toString(readyCount);
        response.notReadyCount = Integer.toString(raida.getNotReadyCount());
        if (readyCount > 20) {
            response.status = "ready";
            response.message = "The RAIDA is ready for counterfeit detection.";
        } else {
            response.status = "fail";
            response.message = "Not enough RAIDA servers can be contacted to import new coins.";
        }

        return Utils.createGson().toJson(response);
    }

    private String detect(String accountFolder) {
        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";

        response.receipt = multi_detect(accountFolder);
        Grader.gradeSuspectFolder(accountFolder);
        response.status = "importing";
        response.message = "The stack file has been imported and detection will begin automatically so long as they are not already in bank. Please check your receipt.";

        response.time = Utils.getDate();
        return Utils.createGson().toJson(response);
    }

    public static String multi_detect(String accountPath) {
        MultiDetect multiDetector = new MultiDetect();
        String receiptFileName = FileUtils.randomString(16);

        try {
            multiDetector.detectMulti(20000, receiptFileName, accountPath).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return receiptFileName;
    }
}
