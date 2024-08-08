package com.lsports.trade360_java_sdk.feed.rabbitmq;

import lombok.val;
import org.springframework.amqp.core.Message;

public final class EventUtility {

    public static final String RETRY_NUMBER_HEADER_NAME = "x-retry-number";

    public static String messageId(final Message message) {
        return message.getMessageProperties().getMessageId();
    }

    public static int retryNumber(final Message message) {
        val messageProperties = message.getMessageProperties();
        val retryNumber = messageProperties.getHeaders().getOrDefault(RETRY_NUMBER_HEADER_NAME, 0);
        return Integer.valueOf(retryNumber.toString());
    }

    public static void increaseRetryNumber(final Message message) {
        val messageHeaders = message.getMessageProperties().getHeaders();
        messageHeaders.put(RETRY_NUMBER_HEADER_NAME, retryNumber(message) + 1);
    }


}