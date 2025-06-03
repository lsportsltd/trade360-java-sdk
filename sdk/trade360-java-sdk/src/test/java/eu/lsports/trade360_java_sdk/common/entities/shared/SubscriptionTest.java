package eu.lsports.trade360_java_sdk.common.entities.shared;

import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {
    @Test
    void testFieldAssignment() {
        Subscription sub = new Subscription();
        sub.type = 2;
        sub.status = SubscriptionStatus.SUBSCRIBED;
        assertEquals(2, sub.type);
        assertEquals(SubscriptionStatus.SUBSCRIBED, sub.status);
    }
} 