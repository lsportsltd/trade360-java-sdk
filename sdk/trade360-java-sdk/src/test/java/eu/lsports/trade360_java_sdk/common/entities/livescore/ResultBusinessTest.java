package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultBusinessTest {
    @Test
    void testPositionAndValueAssignment() {
        Result result = new Result();
        result.position = "1st";
        result.value = "2-1";
        assertEquals("1st", result.position);
        assertEquals("2-1", result.value);
    }

    @Test
    void testNullPositionAndValue() {
        Result result = new Result();
        result.position = null;
        result.value = null;
        assertNull(result.position);
        assertNull(result.value);
    }

    @Test
    void testEmptyPositionAndValue() {
        Result result = new Result();
        result.position = "";
        result.value = "";
        assertEquals("", result.position);
        assertEquals("", result.value);
    }
} 