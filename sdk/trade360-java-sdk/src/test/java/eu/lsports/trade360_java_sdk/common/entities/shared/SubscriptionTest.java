package eu.lsports.trade360_java_sdk.common.entities.shared;

import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Subscription subscription = new Subscription();
        assertEquals(0, subscription.type);
        assertNull(subscription.status);

        subscription.type = 2;
        subscription.status = SubscriptionStatus.SUBSCRIBED;
        assertEquals(2, subscription.type);
        assertEquals(SubscriptionStatus.SUBSCRIBED, subscription.status);
    }
} 