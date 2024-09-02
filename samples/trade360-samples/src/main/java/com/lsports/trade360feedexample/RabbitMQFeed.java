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
    private final RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration;
    private final RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration;

    public RabbitMQFeed(@Qualifier("inPlayMessageHandler") MessageHandler inPlayMessageHandler,
                        @Qualifier("preMatchMessageHandler") MessageHandler preMatchMessageHandler,
                        @Qualifier("inPlayRabbitConnectionConfiguration") RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration,
                        @Qualifier("preMatchRabbitConnectionConfiguration") RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration) {
        this.inPlayMessageHandler = inPlayMessageHandler;
        this.preMatchMessageHandler = preMatchMessageHandler;
        this.inPlayRabbitConnectionConfiguration = inPlayRabbitConnectionConfiguration;
        this.preMatchRabbitConnectionConfiguration = preMatchRabbitConnectionConfiguration;
    }

    // General notes:
    // Application can work with one, two or more connection to RabbitMQ (Inplay, Prematch).
    // In order to remove one of connection nit is need to
    // - remove appropriate RabbitListener handler
    // - remove connection prefix definition from DynamicBeanDefinitionRegistrarConfiguration

    // Inplay message handler method.
    // Important notes:
    // - The association between Inplay Rabbit connection factory and this method is made by bean name written in containerFactory annotation properties. Name defined in application properties
   // - Name of queue is taken fom application properties
    // - Error handler is set by errorHandler annotation properties
    @RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.inplay.package_id}_", errorHandler="${rabbitmq.inplay.name}.ErrorMessageHandler")
    public void inPlayProcessMessage(final Message amqpMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        inPlayMessageHandler.process(amqpMessage);

        if (!inPlayRabbitConnectionConfiguration.auto_ack)
            channel.basicAck(tag, false);
    }

    // Prematch message handler method.
    // Important notes:
    // - The association between Prematch Rabbit connection factory and this method is made by bean name written in containerFactory annotation properties. Name defined in application properties
    // - Name of queue is taken fom application properties
    // - Error handler is set by errorHandler annotation properties
    @RabbitListener(containerFactory = "${rabbitmq.prematch.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.prematch.package_id}_", errorHandler="${rabbitmq.inplay.name}.ErrorMessageHandler")
    public void preMatchProcessMessage(final Message message, Channel channel,
                                       @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        preMatchMessageHandler.process(message);

        if (!preMatchRabbitConnectionConfiguration.auto_ack)
            channel.basicAck(tag, false);

    }
}


