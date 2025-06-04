package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SettlementTypeTest {
    @Test
    void testEnumValues() {
        for (SettlementType type : SettlementType.values()) {
            assertNotNull(type);
            assertEquals(type, SettlementType.valueOf(type.name()));
        }
    }
} 