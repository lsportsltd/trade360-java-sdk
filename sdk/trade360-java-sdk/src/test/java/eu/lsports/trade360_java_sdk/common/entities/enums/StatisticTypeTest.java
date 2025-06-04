package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatisticTypeTest {
    @Test
    void testEnumValues() {
        for (StatisticType type : StatisticType.values()) {
            assertNotNull(type);
            assertEquals(type, StatisticType.valueOf(type.name()));
        }
    }
} 