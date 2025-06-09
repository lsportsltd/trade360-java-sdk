package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionTest {

    @Test
    void testConstructorWithMessage() {
        String message = "Test error message";
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(((List<String>) exception.getErrors()).iterator().hasNext());
    }

    @Test
    void testConstructorWithMessageAndErrors() {
        String message = "Test error message";
        List<String> errors = List.of("Error 1", "Error 2", "Error 3");
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testGetErrors() {
        List<String> errors = List.of("Validation error", "Business logic error");
        Trade360Exception exception = new Trade360Exception("Multiple errors", errors);
        
        Iterable<String> retrievedErrors = exception.getErrors();
        assertEquals(errors, retrievedErrors);
    }

    @Test
    void testEmptyErrorsList() {
        List<String> emptyErrors = List.of();
        Trade360Exception exception = new Trade360Exception("No errors", emptyErrors);
        
        assertNotNull(exception.getErrors());
        assertFalse(((List<String>) exception.getErrors()).iterator().hasNext());
    }

    @Test
    void testNullMessage() {
        Trade360Exception exception = new Trade360Exception(null);
        
        assertNull(exception.getMessage());
        assertNotNull(exception.getErrors());
    }

    @Test
    void testExceptionInheritance() {
        Trade360Exception exception = new Trade360Exception("Test");
        
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }
} 