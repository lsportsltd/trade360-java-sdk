package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityRegisterTest {
    static class DummyEntityHandler implements EntityHandler<Object> {
        @Override public void process(Object entity, java.util.Map<String, String> messageProperties) {}
        @Override public int getEntityKey() { return 1; }
    }
    static class DummyEntityRegister implements EntityRegister {
        private boolean set = false;
        @Override
        public void setEntityHandler(EntityHandler entityHandler) throws RabbitMQFeedException {
            if (set) throw new RabbitMQFeedException("Already set");
            set = true;
        }
    }
    @Test
    void testSetEntityHandler() throws Exception {
        DummyEntityRegister reg = new DummyEntityRegister();
        reg.setEntityHandler(new DummyEntityHandler());
        RabbitMQFeedException ex = assertThrows(RabbitMQFeedException.class, () -> reg.setEntityHandler(new DummyEntityHandler()));
        assertEquals("Already set", ex.getMessage());
    }
} 