package com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions;

public class RabbitMQFeedException extends Exception{
    public RabbitMQFeedException(String message) {
        super(message);
    };

    public RabbitMQFeedException(String message, Exception innerException){
        super(message, innerException);
    };
}
