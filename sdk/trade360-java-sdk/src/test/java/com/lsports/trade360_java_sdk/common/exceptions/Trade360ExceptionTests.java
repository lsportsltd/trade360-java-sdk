package com.lsports.trade360_java_sdk.common.exceptions;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class Trade360ExceptionTests {

    @Test
    public void constructor_withMessage_createsExceptionWithMessage() {
        // Arrange
        String message = "Test error message";

        // Act
        Trade360Exception exception = new Trade360Exception(message);

        // Assert
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    public void constructor_withMessageAndErrors_createsExceptionWithMessageAndErrors() {
        // Arrange
        String message = "Test error message";
        List<String> errors = List.of("Error 1", "Error 2", "Error 3");

        // Act
        Trade360Exception exception = new Trade360Exception(message, errors);

        // Assert
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    public void constructor_withEmptyErrors_createsExceptionWithEmptyErrorsList() {
        // Arrange
        String message = "Test error message";
        List<String> errors = List.of();

        // Act
        Trade360Exception exception = new Trade360Exception(message, errors);

        // Assert
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    public void getErrors_whenCalled_returnsErrorsList() {
        // Arrange
        String message = "Test error message";
        List<String> errors = List.of("Error 1", "Error 2");
        Trade360Exception exception = new Trade360Exception(message, errors);

        // Act
        Iterable<String> result = exception.getErrors();

        // Assert
        assertNotNull(result);
        assertEquals(errors, result);
    }

    @Test
    public void exception_extendsRuntimeException_canBeThrownWithoutChecking() {
        // Assert
        assertTrue(RuntimeException.class.isAssignableFrom(Trade360Exception.class));
    }
}

