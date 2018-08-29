package com.cloudcoin.bank;

import com.cloudcoin.bank.json.ServiceResponse;
import com.cloudcoin.bank.utils.Utils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class WebPages {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hi")
    public String print_welcome() {
        ServiceResponse response = new ServiceResponse();

        response.bankServer = "localhost";
        response.status = "welcome";
        response.version = "2.0";
        response.time = Utils.getDate();
        response.message = "CloudCoin Bank. Used to Authenticate, Store and Payout CloudCoins." +
                "This Software is provided as is with all faults, defects and errors, and without warranty of any kind." +
                "Free from the CloudCoin Consortium.";
        return Utils.createGson().toJson(response);
    }

    @RequestMapping("/echo")
    public String echo() {
        return "";
    }

    public String Page_Load() {
        ServiceResponse response = new ServiceResponse();
        response.bankServer = "localhost";
        response.status = "fail";
        response.time = Utils.getDate();
        response.version = "2.0";

        try {
            String path = "pk";
            String account = "account";
            if (path == null || account == null) {
                response.message = "Request Error: Private key or Account not specified";
                return Utils.createGson().toJson(response);
            }
            String PasswordFolder = "Passwords/";
            String text = new String(Files.readAllBytes(Paths.get("C:/CloudBank/accounts/" + PasswordFolder + "accountNumber.txt")), StandardCharsets.UTF_8);

            if (!text.equals(path)) {
                response.message = "Private key not correct";
                return Utils.createGson().toJson(response);
            }

            RegisterAsyncTask(new PageAsyncTask(EchoRaida));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End Page Load

    public async Task EchoRaida( )
    {
        RAIDA raida = new RAIDA();
        raida = RAIDA.GetInstance();
        var echos = raida.GetEchoTasks();
        await Task.WhenAll(echos.AsParallel().Select(async task => await task()));

        ServiceResponse response = new ServiceResponse();
        response.bankServer = WebConfigurationManager.AppSettings["thisServerName"];
        response.status = "ready";
        response.time = DateTime.UtcNow.ToString("o");
        response.readyCount = raida.ReadyCount;
        response.notReadyCount = raida.NotReadyCount;
        response.version = "2.0";
        if (raida.ReadyCount > 20){
            //send yay
            response.status = "ready";
            response.message = "The RAIDA is ready for counterfeit detection.";
        }else{
            //send nay
            response.status = "fail";
            response.message = "Not enough RAIDA servers can be contacted to import new coins.";
        }

        var json = new JavaScriptSerializer().Serialize(response);
        Response.Write(json);
        Response.End();
    }
}
