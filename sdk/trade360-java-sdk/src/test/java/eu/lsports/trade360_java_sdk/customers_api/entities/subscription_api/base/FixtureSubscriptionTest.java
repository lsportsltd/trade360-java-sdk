package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixtureSubscriptionTest {
    @Test
    void testFields() {
        FixtureSubscription fs = new FixtureSubscription();
        fs.fixtureId = 1;
        fs.success = true;
        assertEquals(1, fs.fixtureId);
        assertTrue(fs.success);
    }
} 