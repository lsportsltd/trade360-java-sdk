package com.lsports.trade360feedexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@SpringBootApplication
public class Trade360FeedExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(Trade360FeedExampleApplication.class, args);
    }

}
