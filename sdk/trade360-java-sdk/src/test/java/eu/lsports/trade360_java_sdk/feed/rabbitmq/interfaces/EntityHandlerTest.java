package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class EntityHandlerTest {
    static class DummyEntityHandler implements EntityHandler<String> {
        boolean processed = false;
        @Override public void process(String entity, java.util.Map<String, String> messageHeaders, java.util.Map<String, String> transportMessageHeaders) { processed = true; }
        @Override public int getEntityKey() { return 42; }
    }
    @Test
    void testProcessAndGetEntityKey() {
        DummyEntityHandler handler = new DummyEntityHandler();
        handler.process("entity", new HashMap<>(), new HashMap<>());
        assertTrue(handler.processed);
        assertEquals(42, handler.getEntityKey());
    }
} 