package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionStateTest {
    @Test
    void testEnumValues() {
        for (SubscriptionState state : SubscriptionState.values()) {
            assertNotNull(state);
            assertEquals(state, SubscriptionState.valueOf(state.name()));
        }
    }
} 