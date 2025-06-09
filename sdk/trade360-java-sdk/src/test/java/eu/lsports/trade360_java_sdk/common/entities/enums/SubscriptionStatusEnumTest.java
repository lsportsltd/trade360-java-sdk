package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionStatusEnumTest {

    @Test
    void testEnumValues() {
        SubscriptionStatus[] values = SubscriptionStatus.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (SubscriptionStatus status : SubscriptionStatus.values()) {
            assertEquals(status, SubscriptionStatus.valueOf(status.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(SubscriptionStatus.values());
    }

    @Test
    void testEnumConsistency() {
        SubscriptionStatus[] values1 = SubscriptionStatus.values();
        SubscriptionStatus[] values2 = SubscriptionStatus.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
