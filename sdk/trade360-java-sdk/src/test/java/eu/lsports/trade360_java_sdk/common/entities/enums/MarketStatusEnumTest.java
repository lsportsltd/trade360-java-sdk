package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MarketStatusEnumTest {

    @Test
    void testEnumValues() {
        MarketStatus[] values = MarketStatus.values();
        assertNotNull(values);
        assertEquals(4, values.length);
    }

    @Test
    void testValueOf() {
        for (MarketStatus status : MarketStatus.values()) {
            assertEquals(status, MarketStatus.valueOf(status.name()));
        }
    }

    @Test
    void testNumericValues() {
        assertEquals(0, MarketStatus.NOT_SET.getValue());
        assertEquals(1, MarketStatus.OPEN.getValue());
        assertEquals(2, MarketStatus.SUSPENDED.getValue());
        assertEquals(3, MarketStatus.SETTLED.getValue());
    }

    @Test
    void testEnumConsistency() {
        MarketStatus[] values1 = MarketStatus.values();
        MarketStatus[] values2 = MarketStatus.values();
        assertEquals(values1.length, values2.length);
        assertTrue(values1.length > 0);
    }
}
