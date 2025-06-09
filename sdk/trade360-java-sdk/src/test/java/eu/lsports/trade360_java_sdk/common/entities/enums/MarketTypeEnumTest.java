package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTypeEnumTest {

    @Test
    void testEnumValues() {
        MarketType[] values = MarketType.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (MarketType marketType : MarketType.values()) {
            assertEquals(marketType, MarketType.valueOf(marketType.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(MarketType.values());
    }

    @Test
    void testEnumConsistency() {
        MarketType[] values1 = MarketType.values();
        MarketType[] values2 = MarketType.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
