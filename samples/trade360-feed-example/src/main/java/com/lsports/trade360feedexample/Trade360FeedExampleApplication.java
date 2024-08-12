package com.lsports.trade360feedexample;

import com.lsports.trade360feedexample.configuration.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.lsports.trade360_java_sdk.feed.rabbitmq.configurations")
@ComponentScan(basePackages="com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces")
@ComponentScan(basePackages="com.lsports.trade360_java_sdk.feed.rabbitmq.handlers")
@EnableConfigurationProperties(RabbitConfiguration.class)
public class Trade360FeedExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(Trade360FeedExampleApplication.class, args);
    }
}