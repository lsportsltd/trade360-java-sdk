package com.lsports.trade360feedexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages = "com.lsports.trade360_java_sdk.feed.rabbitmq.configurations")
public class Trade360FeedExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(Trade360FeedExampleApplication.class, args);
    }
}