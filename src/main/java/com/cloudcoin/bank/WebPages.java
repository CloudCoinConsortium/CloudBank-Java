package com.cloudcoin.bank;

import com.cloudcoin.bank.core.RAIDA;
import com.cloudcoin.bank.core.Response;
import com.cloudcoin.bank.json.ServiceResponse;
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
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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

    @RequestMapping(value="/echo", method = RequestMethod.GET)
    public String echo(@RequestParam("account") Optional<String> account, @RequestParam("pk") Optional<String> key) {
        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";
        response.status = "fail";

        try {
            if (!key.isPresent() || !account.isPresent()) {
                response.message = "Request Error: Private key or Account not specified.";
                return Utils.createGson().toJson(response);
            }
            String PasswordFolder = "Passwords/";
            String text = new String(Files.readAllBytes(Paths.get("C:/CloudBank/accounts/" + PasswordFolder + account.get() + ".txt")), StandardCharsets.UTF_8);

            if (!text.equals(key.get())) {
                response.message = "Private key not correct";
                return Utils.createGson().toJson(response);
            }

            return EchoRaida();
        } catch (IOException e) {
            response.message = "Request Error: Private key or Account not found.";
            e.printStackTrace();
        }
        return Utils.createGson().toJson(response);
    }

    
    /* Methods */

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
}
