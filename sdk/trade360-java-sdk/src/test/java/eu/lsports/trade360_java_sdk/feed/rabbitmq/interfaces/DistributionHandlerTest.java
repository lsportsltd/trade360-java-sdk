package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistributionHandlerTest {
    static class DummyDistributionHandler implements DistributionHandler {
        boolean called = false;
        @Override public void process() throws Exception { called = true; }
    }
    @Test
    void testProcess() throws Exception {
        DummyDistributionHandler handler = new DummyDistributionHandler();
        handler.process();
        assertTrue(handler.called);
    }
} 