package com.lsports.trade360_java_sdk.feed.rabbitmq;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.*;

@Component
public class RabbitMQFeedOld {

    @RabbitListener(queues = "_430_")
    public void processOrder(Order order) {
    }
}