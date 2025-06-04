package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DangerIndicatorTypeTest {
    @Test
    void testEnumValues() {
        for (DangerIndicatorType type : DangerIndicatorType.values()) {
            assertNotNull(type);
            assertEquals(type, DangerIndicatorType.valueOf(type.name()));
        }
    }
} 