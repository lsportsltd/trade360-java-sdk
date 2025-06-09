package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueSubscriptionRequestTest {

    @Test
    void testRecordConstruction() {
        List<LeagueSubscription> subscriptions = List.of(new LeagueSubscription(1, 2, 3));
        LeagueSubscriptionRequest request = new LeagueSubscriptionRequest(subscriptions);
        
        assertEquals(subscriptions, request.subscriptions());
    }

    @Test
    void testNullSubscriptions() {
        LeagueSubscriptionRequest request = new LeagueSubscriptionRequest(null);
        
        assertNull(request.subscriptions());
    }

    @Test
    void testEmptyList() {
        List<LeagueSubscription> emptyList = List.of();
        LeagueSubscriptionRequest request = new LeagueSubscriptionRequest(emptyList);
        
        assertEquals(emptyList, request.subscriptions());
        assertTrue(((List<LeagueSubscription>) request.subscriptions()).isEmpty());
    }

    @Test
    void testRecordEquality() {
        List<LeagueSubscription> subscriptions = List.of(new LeagueSubscription(1, 2, 3));
        LeagueSubscriptionRequest request1 = new LeagueSubscriptionRequest(subscriptions);
        LeagueSubscriptionRequest request2 = new LeagueSubscriptionRequest(subscriptions);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }
}
