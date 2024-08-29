package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

import java.text.MessageFormat;

public class RecoveryMessageResolver implements MessageRecoverer {
    @Override
    public void recover(Message message, Throwable cause) {

        // Printout error message after policy retry fulfilment
        System.out.print(MessageFormat.format("Unable to process message due to {0} message: {1}", cause.getMessage(), message));

        // Further message handling can be added here, e.g. send to DLQ
    }
}
