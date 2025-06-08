package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SuspendedMarketTest {
    @Test
    void testFields() {
        SuspendedMarket sm = new SuspendedMarket();
        sm.marketId = 1;
        sm.line = "Line";
        assertEquals(1, sm.marketId);
        assertEquals("Line", sm.line);
    }
} 