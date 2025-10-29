package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Trade360ExceptionTests {

    @Test
    public void constructor_withMessageOnly_createsExceptionWithEmptyErrors() {
        String message = "Test error message";
        
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
        assertNotNull(exception.getErrors());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    public void constructor_withMessageAndErrors_createsExceptionWithErrors() {
        String message = "Multiple errors occurred";
        List<String> errors = Arrays.asList("Error 1", "Error 2", "Error 3");
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    public void constructor_withEmptyErrorsList_createsExceptionWithEmptyErrors() {
        String message = "No errors";
        List<String> errors = Collections.emptyList();
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        assertEquals(message, exception.getMessage());
        assertFalse(exception.getErrors().iterator().hasNext());
    }

    @Test
    public void constructor_withNullMessage_createsExceptionWithNullMessage() {
        Trade360Exception exception = new Trade360Exception(null);
        
        assertNull(exception.getMessage());
        assertNotNull(exception.getErrors());
    }

    @Test
    public void getErrors_returnsCorrectErrorsList() {
        List<String> errors = Arrays.asList("Error A", "Error B");
        Trade360Exception exception = new Trade360Exception("Test", errors);
        
        Iterable<String> retrievedErrors = exception.getErrors();
        
        assertEquals(errors, retrievedErrors);
    }

    @Test
    public void exception_isRuntimeException() {
        Trade360Exception exception = new Trade360Exception("Test");
        
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void exception_canBeThrownAndCaught() {
        String message = "Test throw";
        List<String> errors = Arrays.asList("Error 1");
        
        try {
            throw new Trade360Exception(message, errors);
        } catch (Trade360Exception e) {
            assertEquals(message, e.getMessage());
            assertEquals(errors, e.getErrors());
        }
    }

    @Test
    public void exception_withLongErrorsList_storesAllErrors() {
        String message = "Many errors";
        List<String> errors = Arrays.asList(
            "Error 1", "Error 2", "Error 3", "Error 4", "Error 5",
            "Error 6", "Error 7", "Error 8", "Error 9", "Error 10"
        );
        
        Trade360Exception exception = new Trade360Exception(message, errors);
        
        int count = 0;
        for (String error : exception.getErrors()) {
            count++;
        }
        assertEquals(10, count);
    }

    @Test
    public void exception_withSpecialCharactersInMessage_preservesMessage() {
        String message = "Error: 'special' chars & symbols <> ! @ # $";
        
        Trade360Exception exception = new Trade360Exception(message);
        
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void exception_withSpecialCharactersInErrors_preservesErrors() {
        List<String> errors = Arrays.asList(
            "Error with <HTML> tags",
            "Error with 'quotes'",
            "Error with & ampersand"
        );
        
        Trade360Exception exception = new Trade360Exception("Test", errors);
        
        assertEquals(errors, exception.getErrors());
    }
}

