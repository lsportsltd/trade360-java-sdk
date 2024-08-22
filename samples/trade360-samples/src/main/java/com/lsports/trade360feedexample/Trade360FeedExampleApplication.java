package com.lsports.trade360feedexample;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages = "com.lsports.trade360_java_sdk.feed.rabbitmq.configurations")
@EnableConfigurationProperties( RabbitConnectionConfiguration.class)
public class Trade360FeedExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(Trade360FeedExampleApplication.class, args);
    }
}