package eu.lsports.trade360_java_sdk.common.entities.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCorrectTest {

    @Test
    void testErrorDefaultConstructor() {
        Error error = new Error();
        
        assertNotNull(error);
        assertNull(error.message);
    }

    @Test
    void testErrorMessageAssignment() {
        Error error = new Error();
        String testMessage = "Test error message";
        
        error.message = testMessage;
        
        assertEquals(testMessage, error.message);
    }

    @Test
    void testErrorNullMessageAssignment() {
        Error error = new Error();
        
        error.message = null;
        
        assertNull(error.message);
    }

    @Test
    void testErrorEmptyMessageAssignment() {
        Error error = new Error();
        
        error.message = "";
        
        assertEquals("", error.message);
    }

    @Test
    void testErrorMessageReassignment() {
        Error error = new Error();
        
        error.message = "First message";
        assertEquals("First message", error.message);
        
        error.message = "Second message";
        assertEquals("Second message", error.message);
    }

    @Test
    void testMultipleErrorInstances() {
        Error error1 = new Error();
        Error error2 = new Error();
        
        error1.message = "Error 1";
        error2.message = "Error 2";
        
        assertEquals("Error 1", error1.message);
        assertEquals("Error 2", error2.message);
        assertNotEquals(error1.message, error2.message);
    }

    @Test
    void testErrorStringImmutability() {
        Error error = new Error();
        String originalMessage = "Original message";
        
        error.message = originalMessage;
        
        String retrievedMessage = error.message;
        assertEquals(originalMessage, retrievedMessage);
        assertSame(originalMessage, retrievedMessage);
    }

    @Test
    void testErrorWithSpecialCharacters() {
        Error error = new Error();
        
        error.message = "Error with special chars: !@#$%^&*()";
        assertEquals("Error with special chars: !@#$%^&*()", error.message);
        
        error.message = "Unicode: ñáéíóú 中文";
        assertEquals("Unicode: ñáéíóú 中文", error.message);
    }

    @Test
    void testErrorWithWhitespace() {
        Error error = new Error();
        
        error.message = "  Error message  ";
        assertEquals("  Error message  ", error.message);
        
        error.message = "\tTabbed\tError\t";
        assertEquals("\tTabbed\tError\t", error.message);
    }

    @Test
    void testErrorConsistency() {
        Error error1 = new Error();
        Error error2 = new Error();
        
        String testMessage = "Same message";
        
        error1.message = testMessage;
        error2.message = testMessage;
        
        assertEquals(error1.message, error2.message);
    }
}
