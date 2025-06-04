package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BetStatusTest {
    @Test
    void testEnumValues() {
        for (BetStatus status : BetStatus.values()) {
            assertNotNull(status);
            assertEquals(status, BetStatus.valueOf(status.name()));
        }
    }
} 