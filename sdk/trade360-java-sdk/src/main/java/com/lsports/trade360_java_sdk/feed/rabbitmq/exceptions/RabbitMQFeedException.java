package com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions;

import java.text.MessageFormat;

public class RabbitMQFeedException extends Exception{
    public RabbitMQFeedException(String message) {
        super(message);
    };

    public RabbitMQFeedException(String message, Exception innerException){
        super(MessageFormat.format("{0} Detail Message Error: {1}", message, innerException.getMessage(), innerException.getCause()));
    };
}
