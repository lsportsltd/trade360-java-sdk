package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    static class DummyEntity implements Entity {
        @Override public int getEntityKey() { return 99; }
    }
    @Test
    void testGetEntityKey() {
        DummyEntity entity = new DummyEntity();
        assertEquals(99, entity.getEntityKey());
    }
} 