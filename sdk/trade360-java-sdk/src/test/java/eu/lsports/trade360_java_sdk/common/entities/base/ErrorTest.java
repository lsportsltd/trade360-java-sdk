package eu.lsports.trade360_java_sdk.common.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {
    @Test
    void testInstantiation() {
        Error error = new Error();
        assertNotNull(error);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Error error = new Error();
        assertNull(error.message);
        error.message = "Something went wrong";
        assertEquals("Something went wrong", error.message);
    }
} 