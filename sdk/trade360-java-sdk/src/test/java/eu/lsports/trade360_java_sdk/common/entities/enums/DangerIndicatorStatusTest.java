package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DangerIndicatorStatusTest {
    @Test
    void testEnumValues() {
        for (DangerIndicatorStatus status : DangerIndicatorStatus.values()) {
            assertNotNull(status);
            assertEquals(status, DangerIndicatorStatus.valueOf(status.name()));
        }
    }
} 