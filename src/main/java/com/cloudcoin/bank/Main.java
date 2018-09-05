package com.cloudcoin.bank;

import com.cloudcoin.bank.core.FileSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        FileSystem.createDirectories();

        SpringApplication.run(Main.class, args);
    }
}
