package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketEventTest {
    @Test
    void testFieldAssignment() {
        MarketEvent event = new MarketEvent();
        assertNotNull(event);
    }
} 