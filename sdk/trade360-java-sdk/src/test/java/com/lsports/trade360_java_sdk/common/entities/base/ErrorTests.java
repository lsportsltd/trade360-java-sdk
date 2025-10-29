package com.lsports.trade360_java_sdk.common.entities.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorTests {

    @Test
    public void constructor_createsErrorWithDefaultValues() {
        // Act
        Error error = new Error();

        // Assert
        assertNotNull(error);
        assertNull(error.message);
    }

    @Test
    public void message_canBeSet_andRetrieved() {
        // Arrange
        Error error = new Error();
        String message = "This is an error message";

        // Act
        error.message = message;

        // Assert
        assertEquals(message, error.message);
    }

    @Test
    public void message_canBeNull() {
        // Arrange
        Error error = new Error();
        error.message = "test";

        // Act
        error.message = null;

        // Assert
        assertNull(error.message);
    }

    @Test
    public void message_canBeEmptyString() {
        // Arrange
        Error error = new Error();

        // Act
        error.message = "";

        // Assert
        assertEquals("", error.message);
    }

    @Test
    public void multipleInstances_areIndependent() {
        // Arrange
        Error error1 = new Error();
        Error error2 = new Error();

        // Act
        error1.message = "Error 1";
        error2.message = "Error 2";

        // Assert
        assertEquals("Error 1", error1.message);
        assertEquals("Error 2", error2.message);
    }

    @Test
    public void message_canBeLongString() {
        // Arrange
        Error error = new Error();
        String longMessage = "This is a very long error message that contains a lot of details about what went wrong in the system and provides comprehensive information for debugging purposes.";

        // Act
        error.message = longMessage;

        // Assert
        assertEquals(longMessage, error.message);
    }
}

