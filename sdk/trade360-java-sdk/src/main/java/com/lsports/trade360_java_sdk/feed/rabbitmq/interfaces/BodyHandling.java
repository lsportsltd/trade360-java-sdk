package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public interface BodyHandling {
    void Process(Message message) throws Exception;
}
