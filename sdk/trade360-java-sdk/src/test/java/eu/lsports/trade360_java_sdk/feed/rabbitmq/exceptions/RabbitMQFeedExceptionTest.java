package eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RabbitMQFeedExceptionTest {
    @Test
    void testConstructorWithMessage() {
        String msg = "Test error";
        RabbitMQFeedException ex = new RabbitMQFeedException(msg);
        assertEquals(msg, ex.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String msg = "Test error";
        Exception cause = new Exception("cause");
        RabbitMQFeedException ex = new RabbitMQFeedException(msg, cause);
        assertEquals(msg, ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
} 