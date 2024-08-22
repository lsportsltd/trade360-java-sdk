package com.lsports.trade360feedexample;

import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandling;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQFeed {

    private final MessageHandling inPlayMessageHandling;
    private final MessageHandling preMatchMessageHandler;

    public RabbitMQFeed( @Qualifier("inPlayMessageHandler")MessageHandling inPlayMessageHandler,
                         @Qualifier("preMatchMessageHandler")MessageHandling preMatchMessageHandler) {
        this.inPlayMessageHandling = inPlayMessageHandler;
        this.preMatchMessageHandler = preMatchMessageHandler;
    }

    @RabbitListener( containerFactory="InPlayRabbitListenerContainerFactory", queues = "_${rabbitmq.inplay.package_id}_")
    public void inPlayProcessMessage(final Message message) throws Exception {
        inPlayMessageHandling.process(message);
    }

    @RabbitListener( containerFactory="preMatchRabbitListenerContainerFactory", queues = "_${rabbitmq.prematch.package_id}_")
    public void preMatchProcessMessage(final Message message) throws Exception {
        preMatchMessageHandler.process(message);
    }
}

