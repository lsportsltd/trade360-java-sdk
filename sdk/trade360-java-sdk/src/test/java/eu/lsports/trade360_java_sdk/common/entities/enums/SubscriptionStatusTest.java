package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionStatusTest {
    @Test
    void testEnumValues() {
        for (SubscriptionStatus status : SubscriptionStatus.values()) {
            assertNotNull(status);
            assertEquals(status, SubscriptionStatus.valueOf(status.name()));
        }
    }
} 