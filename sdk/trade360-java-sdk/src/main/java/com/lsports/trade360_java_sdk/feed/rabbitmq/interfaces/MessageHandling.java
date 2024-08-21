package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public interface MessageHandling {
    void Process(Message message) throws Exception;
}
