package eu.lsports.trade360_java_sdk.common.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Trade360ExceptionTest {
    @Test
    void testMessageAndErrors() {
        Trade360Exception ex = new Trade360Exception("msg", java.util.List.of("err1", "err2"));
        assertEquals("msg", ex.getMessage());
        assertTrue(ex.getErrors().iterator().hasNext());
    }
} 