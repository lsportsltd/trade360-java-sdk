package eu.lsports.trade360_java_sdk.common.entities.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorTests {

    @Test
    public void newInstance_hasNullMessage() {
        Error error = new Error();
        
        assertNull(error.message);
    }

    @Test
    public void setMessage_storesValue() {
        Error error = new Error();
        
        error.message = "Error message";
        
        assertEquals("Error message", error.message);
    }

    @Test
    public void setMessage_canOverwrite() {
        Error error = new Error();
        error.message = "Original message";
        
        error.message = "New message";
        
        assertEquals("New message", error.message);
    }

    @Test
    public void setMessage_canSetToNull() {
        Error error = new Error();
        error.message = "Some message";
        
        error.message = null;
        
        assertNull(error.message);
    }

    @Test
    public void setMessage_canBeEmptyString() {
        Error error = new Error();
        
        error.message = "";
        
        assertEquals("", error.message);
    }

    @Test
    public void setMessage_canContainSpecialCharacters() {
        Error error = new Error();
        
        error.message = "Error: !@#$%^&*()";
        
        assertEquals("Error: !@#$%^&*()", error.message);
    }

    @Test
    public void setMessage_canContainWhitespace() {
        Error error = new Error();
        
        error.message = "   Error with spaces   ";
        
        assertEquals("   Error with spaces   ", error.message);
    }

    @Test
    public void setMessage_canContainNewlines() {
        Error error = new Error();
        
        error.message = "Line 1\nLine 2\nLine 3";
        
        assertEquals("Line 1\nLine 2\nLine 3", error.message);
    }

    @Test
    public void setMessage_canContainLongString() {
        Error error = new Error();
        String longMessage = "A".repeat(1000);
        
        error.message = longMessage;
        
        assertEquals(longMessage, error.message);
    }

    @Test
    public void setMessage_canContainUnicode() {
        Error error = new Error();
        
        error.message = "Error: 你好 🎉";
        
        assertEquals("Error: 你好 🎉", error.message);
    }

    @Test
    public void setMessage_canContainHtml() {
        Error error = new Error();
        
        error.message = "<html><body>Error</body></html>";
        
        assertEquals("<html><body>Error</body></html>", error.message);
    }

    @Test
    public void setMessage_canContainJson() {
        Error error = new Error();
        
        error.message = "{\"error\":\"Something went wrong\"}";
        
        assertEquals("{\"error\":\"Something went wrong\"}", error.message);
    }
}

