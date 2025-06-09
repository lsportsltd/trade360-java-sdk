package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionComprehensiveTest {

    @Test
    void testTrade360ExceptionMessageConstructor() {
        String testMessage = "Test error message";
        Trade360Exception exception = new Trade360Exception(testMessage);
        
        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertNotNull(exception.getErrors());
        assertEquals(Collections.emptyList(), exception.getErrors());
    }

    @Test
    void testTrade360ExceptionMessageAndErrorsConstructor() {
        String testMessage = "Test error with errors";
        List<String> testErrors = Arrays.asList("Error 1", "Error 2");
        
        Trade360Exception exception = new Trade360Exception(testMessage, testErrors);
        
        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertEquals(testErrors, exception.getErrors());
    }

    @Test
    void testTrade360ExceptionMessageWithNullErrorsList() {
        String testMessage = "Test message with null errors";
        Trade360Exception exception = new Trade360Exception(testMessage, null);
        
        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertNull(exception.getErrors());
    }

    @Test
    void testTrade360ExceptionInheritance() {
        Trade360Exception exception = new Trade360Exception("Test");
        
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }

    @Test
    void testTrade360ExceptionEmptyErrorsList() {
        List<String> emptyErrors = Collections.emptyList();
        Trade360Exception exception = new Trade360Exception("Test message", emptyErrors);
        
        assertEquals("Test message", exception.getMessage());
        assertEquals(emptyErrors, exception.getErrors());
        assertTrue(((List<?>) exception.getErrors()).isEmpty());
    }

    @Test
    void testTrade360ExceptionMultipleErrors() {
        String testMessage = "Multiple errors";
        List<String> testErrors = Arrays.asList("Error 1", "Error 2", "Error 3");
        
        Trade360Exception exception = new Trade360Exception(testMessage, testErrors);
        
        assertEquals(testMessage, exception.getMessage());
        assertEquals(testErrors, exception.getErrors());
        assertEquals(3, ((List<?>) exception.getErrors()).size());
    }

    @Test
    void testTrade360ExceptionSingleError() {
        String testMessage = "Single error";
        List<String> testErrors = Collections.singletonList("Single error message");
        
        Trade360Exception exception = new Trade360Exception(testMessage, testErrors);
        
        assertEquals(testMessage, exception.getMessage());
        assertEquals(testErrors, exception.getErrors());
        assertEquals(1, ((List<?>) exception.getErrors()).size());
    }

    @Test
    void testTrade360ExceptionErrorsConsistency() {
        String testMessage = "Consistency test";
        List<String> testErrors = Arrays.asList("Error A", "Error B");
        
        Trade360Exception exception1 = new Trade360Exception(testMessage, testErrors);
        Trade360Exception exception2 = new Trade360Exception(testMessage, testErrors);
        
        assertEquals(exception1.getMessage(), exception2.getMessage());
        assertEquals(exception1.getErrors(), exception2.getErrors());
    }

    @Test
    void testTrade360ExceptionDifferentMessages() {
        Trade360Exception exception1 = new Trade360Exception("Message 1");
        Trade360Exception exception2 = new Trade360Exception("Message 2");
        
        assertNotEquals(exception1.getMessage(), exception2.getMessage());
        assertEquals(exception1.getErrors(), exception2.getErrors());
    }

    @Test
    void testTrade360ExceptionWithSpecialCharacters() {
        String specialMessage = "Error with special chars: !@#$%^&*()";
        List<String> specialErrors = Arrays.asList("Error with unicode: ñáéíóú", "Error with symbols: <>?");
        
        Trade360Exception exception = new Trade360Exception(specialMessage, specialErrors);
        
        assertEquals(specialMessage, exception.getMessage());
        assertEquals(specialErrors, exception.getErrors());
    }
}
