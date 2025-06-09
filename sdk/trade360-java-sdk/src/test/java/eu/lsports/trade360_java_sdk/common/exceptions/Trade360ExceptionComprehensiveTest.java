package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionComprehensiveTest {

    @Test
    void testConstructorWithMessage() {
        String message = "Test error message";
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    void testConstructorWithMessageAndErrors() {
        String message = "Test error with details";
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
        
        List<String> errorList = new ArrayList<>();
        exception.getErrors().forEach(errorList::add);
        assertEquals(3, errorList.size());
        assertTrue(errorList.contains("Error 1"));
        assertTrue(errorList.contains("Error 2"));
        assertTrue(errorList.contains("Error 3"));
    }

    @Test
    void testConstructorWithEmptyErrors() {
        String message = "Test with empty errors";
        List<String> emptyErrors = Collections.emptyList();
        
        Trade360Exception exception = new Trade360Exception(message, emptyErrors);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    void testConstructorWithNullErrors() {
        String message = "Test with null errors";
        
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
    void testExceptionInheritance() {
        Trade360Exception exception = new Trade360Exception("Test");
        
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }

    @Test
    void testErrorsImmutability() {
        List<String> originalErrors = Arrays.asList("Error 1", "Error 2");
        Trade360Exception exception = new Trade360Exception("Test", originalErrors);
        
        Iterable<String> retrievedErrors = exception.getErrors();
        assertEquals(originalErrors, retrievedErrors);
        
        if (retrievedErrors instanceof List) {
            List<String> errorList = (List<String>) retrievedErrors;
            assertThrows(UnsupportedOperationException.class, () -> {
                errorList.add("New Error");
            });
        }
    }

    @Test
    void testLargeErrorsList() {
        String message = "Test with many errors";
        List<String> manyErrors = Arrays.asList(
            "Error 1", "Error 2", "Error 3", "Error 4", "Error 5",
            "Error 6", "Error 7", "Error 8", "Error 9", "Error 10"
        );
        
        Trade360Exception exception = new Trade360Exception(message, manyErrors);
        
        assertEquals(message, exception.getMessage());
        
        List<String> errorList = new ArrayList<>();
        exception.getErrors().forEach(errorList::add);
        assertEquals(10, errorList.size());
        assertEquals(manyErrors, exception.getErrors());
    }

    @Test
    void testSpecialCharactersInMessage() {
        String specialMessage = "Error with special chars: ñáéíóú @#$%^&*()";
        Trade360Exception exception = new Trade360Exception(specialMessage);
        
        assertEquals(specialMessage, exception.getMessage());
    }

    @Test
    void testSpecialCharactersInErrors() {
        List<String> specialErrors = Arrays.asList(
            "Error with unicode: ñáéíóú",
            "Error with symbols: @#$%^&*()",
            "Error with newlines:\nLine 2\nLine 3"
        );
        
        Trade360Exception exception = new Trade360Exception("Test", specialErrors);
        
        assertEquals(specialErrors, exception.getErrors());
    }
}
