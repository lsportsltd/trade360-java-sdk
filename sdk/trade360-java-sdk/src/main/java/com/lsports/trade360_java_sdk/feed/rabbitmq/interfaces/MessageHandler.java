package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * Interface for handling AMQP messages.
 */
@Component
public interface MessageHandler {

    /**
     * Processes the given AMQP message.
     *
     * @param amqpMessage The AMQP message to process
     * @throws Exception if an error occurs during processing
     */
    void process(Message amqpMessage) throws Exception;
}