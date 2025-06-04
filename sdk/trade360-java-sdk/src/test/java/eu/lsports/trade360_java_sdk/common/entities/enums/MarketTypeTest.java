package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTypeTest {
    @Test
    void testEnumValues() {
        for (MarketType type : MarketType.values()) {
            assertNotNull(type);
            assertEquals(type, MarketType.valueOf(type.name()));
        }
    }
} 