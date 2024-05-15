package com.tcpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TcpClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcpClientApplication.class, args);
    }

}