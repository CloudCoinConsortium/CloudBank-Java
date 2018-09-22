package com.cloudcoin.bank;

import com.cloudcoin.bank.core.FileSystem;
import com.cloudcoin.bank.utils.SimpleLogger;
import com.cloudcoin.bank.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        String error = "--default error message--";

        FileSystem.createDirectories();

        while (true) {
            try {
                ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
                CompletableFuture<Throwable> throwableFuture = new CompletableFuture<>();
                Thread.setDefaultUncaughtExceptionHandler(
                        (thread, throwable) -> throwableFuture.completeExceptionally(throwable));
                throwableFuture.get();
            } catch (Exception | VirtualMachineError e) {
                e.printStackTrace();
                error = e.getMessage();
            }

            try {
                new SimpleLogger().LogFatal(Utils.createGson().toJson(error));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
