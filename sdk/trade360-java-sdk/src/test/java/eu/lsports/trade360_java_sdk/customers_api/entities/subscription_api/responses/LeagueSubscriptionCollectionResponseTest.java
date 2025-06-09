package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueSubscriptionCollectionResponseTest {

    @Test
    void testFieldAssignment() {
        LeagueSubscriptionCollectionResponse response = new LeagueSubscriptionCollectionResponse();
        List<LeagueSubscriptionResponse> subscription = List.of(new LeagueSubscriptionResponse());
        
        response.subscription = subscription;
        
        assertEquals(subscription, response.subscription);
    }

    @Test
    void testNullFieldsAllowed() {
        LeagueSubscriptionCollectionResponse response = new LeagueSubscriptionCollectionResponse();
        
        response.subscription = null;
        
        assertNull(response.subscription);
    }

    @Test
    void testDefaultValues() {
        LeagueSubscriptionCollectionResponse response = new LeagueSubscriptionCollectionResponse();
        
        assertNull(response.subscription);
    }

    @Test
    void testEmptyList() {
        LeagueSubscriptionCollectionResponse response = new LeagueSubscriptionCollectionResponse();
        List<LeagueSubscriptionResponse> emptyList = List.of();
        
        response.subscription = emptyList;
        
        assertEquals(emptyList, response.subscription);
        assertTrue(((List<LeagueSubscriptionResponse>) response.subscription).isEmpty());
    }
}
