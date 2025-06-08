package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionSubscriptionRequestTest {
    @Test
    void testConstructorAndFields() {
        List<CompetitionSubscription> subscriptions = List.of();
        CompetitionSubscriptionRequest req = new CompetitionSubscriptionRequest(subscriptions);
        assertEquals(subscriptions, req.subscriptions());
    }
} 