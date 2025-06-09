package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionExpandedTest {

    @Test
    void testConstructorWithMessage() {
        String message = "Test error message";
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        
        List<String> errorList = new ArrayList<>();
        exception.getErrors().forEach(errorList::add);
        assertTrue(errorList.isEmpty());
    }

    @Test
    void testConstructorWithMessageAndErrors() {
        String message = "Test error with details";
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
        assertNotNull(exception.getErrors());
        
        List<String> errorList = new ArrayList<>();
        exception.getErrors().forEach(errorList::add);
        assertEquals(3, errorList.size());
        assertTrue(errorList.contains("Error 1"));
        assertTrue(errorList.contains("Error 2"));
        assertTrue(errorList.contains("Error 3"));
    }

    @Test
    void testGetErrorsWithEmptyList() {
        String message = "Test with empty errors";
        List<String> emptyErrors = Arrays.asList();
        
        Trade360Exception exception = new Trade360Exception(message, emptyErrors);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        
        List<String> errorList = new ArrayList<>();
        exception.getErrors().forEach(errorList::add);
        assertTrue(errorList.isEmpty());
    }

    @Test
    void testGetErrorsWithNullList() {
        String message = "Test with null errors";
        
        Trade360Exception exception = new Trade360Exception(message, null);
        
        assertEquals(message, exception.getMessage());
        assertNull(exception.getErrors());
    }

    @Test
    void testExceptionInheritance() {
        Trade360Exception exception = new Trade360Exception("Test");
        
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }
}
