package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Result result = new Result();
        assertNull(result.position);
        assertNull(result.value);

        result.position = "home";
        result.value = "2-1";
        assertEquals("home", result.position);
        assertEquals("2-1", result.value);
    }
} 