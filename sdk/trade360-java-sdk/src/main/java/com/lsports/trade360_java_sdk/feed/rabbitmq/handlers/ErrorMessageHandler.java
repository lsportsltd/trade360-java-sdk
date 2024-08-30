package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import java.text.MessageFormat;

@SuppressWarnings("removal")
public class ErrorMessageHandler implements RabbitListenerErrorHandler {

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        return null;
    }

    @Override
    public Object handleError(Message amqpMessage, Channel channel, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {

        String connectionName = channel.getConnection().getAddress().toString();

        // Printout error message after error
        System.out.println(MessageFormat.format("{0}: Unable to process message amqpMessage header: {1}", connectionName, amqpMessage.getMessageProperties().toString()));
        System.out.println(MessageFormat.format("{0}: Unable to process due to exception cause: {1} ", connectionName, exception.getCause()));
        System.out.println(MessageFormat.format("{0}: message: {1} ", connectionName, message.getPayload()));

        // Further message handling can be added here, e.g. send to DLQ

        return RabbitListenerErrorHandler.super.handleError(amqpMessage, channel, message, exception);
    }
}
