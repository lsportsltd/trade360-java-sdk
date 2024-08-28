package com.lsports.trade360feedexample;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandler;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQFeed {

    private final MessageHandler inPlayMessageHandler;
    private final MessageHandler preMatchMessageHandler;
    private final RabbitConnectionConfiguration inPlayrabbitConnectionConfiguration;
    private final RabbitConnectionConfiguration preMatchrabbitConnectionConfiguration;

    public RabbitMQFeed(@Qualifier("inPlayMessageHandler") MessageHandler inPlayMessageHandler,
                        @Qualifier("preMatchMessageHandler") MessageHandler preMatchMessageHandler,
                        @Qualifier("inPlayRabbitConnectionConfiguration") RabbitConnectionConfiguration inPlayrabbitConnectionConfiguration,
                        @Qualifier("preMatchRabbitConnectionConfiguration") RabbitConnectionConfiguration preMatchrabbitConnectionConfiguration) {
        this.inPlayMessageHandler = inPlayMessageHandler;
        this.preMatchMessageHandler = preMatchMessageHandler;
        this.inPlayrabbitConnectionConfiguration = inPlayrabbitConnectionConfiguration;
        this.preMatchrabbitConnectionConfiguration = preMatchrabbitConnectionConfiguration;
    }

    @RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.inplay.package_id}_")
    public void inPlayProcessMessage(final Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        inPlayMessageHandler.process(message);

        if (inPlayrabbitConnectionConfiguration.auto_ack == false)
            channel.basicAck(tag, false);
    }

    @RabbitListener(containerFactory = "${rabbitmq.prematch.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.prematch.package_id}_")
    public void preMatchProcessMessage(final Message message, Channel channel,
                                       @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        preMatchMessageHandler.process(message);

        if (preMatchrabbitConnectionConfiguration.auto_ack == false)
            channel.basicAck(tag, false);

    }
}


