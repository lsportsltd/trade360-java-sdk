package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProviderOddsTypeTest {
    @Test
    void testEnumValues() {
        for (ProviderOddsType type : ProviderOddsType.values()) {
            assertNotNull(type);
            assertEquals(type, ProviderOddsType.valueOf(type.name()));
        }
    }
} 