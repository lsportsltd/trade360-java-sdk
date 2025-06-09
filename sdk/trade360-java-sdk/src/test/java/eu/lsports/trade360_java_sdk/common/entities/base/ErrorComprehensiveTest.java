package eu.lsports.trade360_java_sdk.common.entities.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorComprehensiveTest {

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
    void testErrorMessageNullAssignment() {
        Error error = new Error();
        
        error.message = null;
        
        assertNull(error.message);
    }

    @Test
    void testErrorMessageEmptyStringAssignment() {
        Error error = new Error();
        String emptyMessage = "";
        
        error.message = emptyMessage;
        
        assertEquals(emptyMessage, error.message);
    }

    @Test
    void testErrorMessageLongStringAssignment() {
        Error error = new Error();
        String longMessage = "This is a very long error message that contains a lot of text to test how the Error class handles lengthy error descriptions that might be returned from various validation processes and API calls";
        
        error.message = longMessage;
        
        assertEquals(longMessage, error.message);
    }

    @Test
    void testErrorMessageSpecialCharactersAssignment() {
        Error error = new Error();
        String specialMessage = "Error with special chars: @#$%^&*()[]{}|\\:;\"'<>,.?/~`";
        
        error.message = specialMessage;
        
        assertEquals(specialMessage, error.message);
    }

    @Test
    void testErrorMessageUnicodeAssignment() {
        Error error = new Error();
        String unicodeMessage = "Unicode error: ñáéíóú 中文 العربية русский";
        
        error.message = unicodeMessage;
        
        assertEquals(unicodeMessage, error.message);
    }

    @Test
    void testErrorMessageNewlineAssignment() {
        Error error = new Error();
        String newlineMessage = "Error message\nwith newlines\nand multiple\nlines";
        
        error.message = newlineMessage;
        
        assertEquals(newlineMessage, error.message);
    }

    @Test
    void testErrorMessageTabAssignment() {
        Error error = new Error();
        String tabMessage = "Error message\twith\ttabs\tand\tspacing";
        
        error.message = tabMessage;
        
        assertEquals(tabMessage, error.message);
    }

    @Test
    void testErrorMessageReassignment() {
        Error error = new Error();
        String firstMessage = "First error message";
        String secondMessage = "Second error message";
        
        error.message = firstMessage;
        assertEquals(firstMessage, error.message);
        
        error.message = secondMessage;
        assertEquals(secondMessage, error.message);
    }

    @Test
    void testErrorMessageNullToStringAssignment() {
        Error error = new Error();
        error.message = null;
        
        error.message = "New message after null";
        
        assertEquals("New message after null", error.message);
    }

    @Test
    void testErrorMessageStringToNullAssignment() {
        Error error = new Error();
        error.message = "Initial message";
        
        error.message = null;
        
        assertNull(error.message);
    }

    @Test
    void testMultipleErrorInstances() {
        Error error1 = new Error();
        Error error2 = new Error();
        String message1 = "Error 1";
        String message2 = "Error 2";
        
        error1.message = message1;
        error2.message = message2;
        
        assertEquals(message1, error1.message);
        assertEquals(message2, error2.message);
        assertNotEquals(error1.message, error2.message);
    }

    @Test
    void testErrorMessageImmutabilityOfString() {
        Error error = new Error();
        String originalMessage = "Original message";
        error.message = originalMessage;
        
        String retrievedMessage = error.message;
        
        assertEquals(originalMessage, retrievedMessage);
        assertSame(originalMessage, retrievedMessage);
    }

    @Test
    void testErrorMessageWithJsonSpecialCharacters() {
        Error error = new Error();
        String jsonMessage = "{\"error\": \"Invalid JSON format\", \"code\": 400}";
        
        error.message = jsonMessage;
        
        assertEquals(jsonMessage, error.message);
    }
}
