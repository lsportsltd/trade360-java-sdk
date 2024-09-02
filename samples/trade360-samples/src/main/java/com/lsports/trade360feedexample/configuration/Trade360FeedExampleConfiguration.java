package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegistry;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.AmqpMessageHandler;
import com.lsports.trade360feedexample.handlers.inplay.messages.*;
import com.lsports.trade360feedexample.handlers.prematch.messages.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {


    // Register properties configuration for InPlay
    @Bean
    @ConfigurationProperties("rabbitmq.inplay")
    public RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }

    // Register properties configuration for Prematch
    @Bean
    @ConfigurationProperties("rabbitmq.prematch")
    public RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }
}


