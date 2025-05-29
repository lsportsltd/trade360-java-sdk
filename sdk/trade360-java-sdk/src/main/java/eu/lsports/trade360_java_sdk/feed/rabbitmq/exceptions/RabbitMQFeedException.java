package eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions;

import java.text.MessageFormat;

/**
 * Represents an exception specific to RabbitMQ feed operations.
 */
public class RabbitMQFeedException extends Exception {

    /**
     * Constructs a new RabbitMQFeedException with the specified detail message.
     *
     * @param message The detail message
     */
    public RabbitMQFeedException(String message) {
        super(message);
    }

    /**
     * Constructs a new RabbitMQFeedException with the specified detail message and inner exception.
     *
     * @param message The detail message
     * @param innerException The inner exception
     */
    public RabbitMQFeedException(String message, Exception innerException) {
        super(MessageFormat.format("{0} Detail Message Error: {1}", message, innerException.getMessage()), innerException);
    }
}