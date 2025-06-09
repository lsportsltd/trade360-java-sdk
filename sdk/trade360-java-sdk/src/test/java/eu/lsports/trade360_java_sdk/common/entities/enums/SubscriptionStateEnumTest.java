package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionStateEnumTest {

    @Test
    void testEnumValues() {
        SubscriptionState[] values = SubscriptionState.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (SubscriptionState state : SubscriptionState.values()) {
            assertEquals(state, SubscriptionState.valueOf(state.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(SubscriptionState.values());
    }

    @Test
    void testEnumConsistency() {
        SubscriptionState[] values1 = SubscriptionState.values();
        SubscriptionState[] values2 = SubscriptionState.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
