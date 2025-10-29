package com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RabbitMQFeedExceptionTests {

    @Test
    public void constructor_withMessage_createsExceptionWithMessage() {
        // Arrange
        String message = "RabbitMQ feed error";

        // Act
        RabbitMQFeedException exception = new RabbitMQFeedException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void constructor_withMessageAndInnerException_createsExceptionWithFormattedMessage() {
        // Arrange
        String message = "RabbitMQ connection failed";
        Exception innerException = new IllegalArgumentException("Invalid configuration");

        // Act
        RabbitMQFeedException exception = new RabbitMQFeedException(message, innerException);

        // Assert
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains(message));
        assertTrue(exception.getMessage().contains("Invalid configuration"));
    }

    @Test
    public void constructor_withMessageAndInnerException_includesDetailMessage() {
        // Arrange
        String message = "Failed to process message";
        Exception innerException = new RuntimeException("Connection timeout");

        // Act
        RabbitMQFeedException exception = new RabbitMQFeedException(message, innerException);

        // Assert
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Detail Message Error"));
    }

    @Test
    public void exception_extendsException_canBeCaughtAsCheckedException() {
        // Assert
        assertTrue(Exception.class.isAssignableFrom(RabbitMQFeedException.class));
    }

    @Test
    public void constructor_withEmptyMessage_createsException() {
        // Arrange
        String message = "";

        // Act
        RabbitMQFeedException exception = new RabbitMQFeedException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void constructor_withInnerExceptionWithNullMessage_handlesGracefully() {
        // Arrange
        String message = "Outer message";
        Exception innerException = new RuntimeException();

        // Act
        RabbitMQFeedException exception = new RabbitMQFeedException(message, innerException);

        // Assert
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains(message));
    }
}

