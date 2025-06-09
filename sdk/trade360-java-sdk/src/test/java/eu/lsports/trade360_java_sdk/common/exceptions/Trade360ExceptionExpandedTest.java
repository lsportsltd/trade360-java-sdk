package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionExpandedTest {

    @Test
    void testConstructorWithMessage() {
        String message = "Test error message";
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
    }

    @Test
    void testConstructorWithMessageAndErrors() {
        String message = "Validation failed";
        List<String> errors = Arrays.asList("Field 'name' is required", "Field 'email' is invalid");
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
        assertNotNull(exception.getErrors());
    }

    @Test
    void testConstructorWithEmptyErrors() {
        String message = "Empty errors test";
        List<String> errors = Arrays.asList();
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
        assertNotNull(exception.getErrors());
    }

    @Test
    void testConstructorWithNullErrors() {
        String message = "Null errors test";
        
        Trade360Exception exception = new Trade360Exception(message, null);
        
        assertEquals(message, exception.getMessage());
        assertNull(exception.getErrors());
    }

    @Test
    void testConstructorWithNullMessage() {
        List<String> errors = Arrays.asList("Error 1", "Error 2");
        
        Trade360Exception exception = new Trade360Exception(null, errors);
        
        assertNull(exception.getMessage());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testGetErrorsImmutability() {
        String message = "Immutability test";
        List<String> originalErrors = Arrays.asList("Error 1", "Error 2");
        
        Trade360Exception exception = new Trade360Exception(message, originalErrors);
        Iterable<String> retrievedErrors = exception.getErrors();
        
        assertEquals(originalErrors, retrievedErrors);
        assertNotNull(retrievedErrors);
    }

    @Test
    void testExceptionInheritance() {
        Trade360Exception exception = new Trade360Exception("Test message");
        
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }
}
