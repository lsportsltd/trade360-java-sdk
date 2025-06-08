package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FixtureSubscriptionRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> fixtures = List.of(1, 2, 3);
        FixtureSubscriptionRequest req = new FixtureSubscriptionRequest(fixtures);
        assertEquals(fixtures, req.fixtures());
    }
} 