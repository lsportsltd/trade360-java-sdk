package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    void testFieldAssignment() {
        Result result = new Result();
        result.position = "1st";
        result.value = "2-1";
        assertEquals("1st", result.position);
        assertEquals("2-1", result.value);
    }
} 