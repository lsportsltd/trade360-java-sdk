package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import static org.junit.jupiter.api.Assertions.*;

class MessageHandlerTest {
    static class DummyMessageHandler implements MessageHandler {
        boolean called = false;
        @Override public void process(Message amqpMessage) throws Exception { called = true; }
    }
    @Test
    void testProcess() throws Exception {
        DummyMessageHandler handler = new DummyMessageHandler();
        handler.process(new Message(new byte[0]));
        assertTrue(handler.called);
    }
} 