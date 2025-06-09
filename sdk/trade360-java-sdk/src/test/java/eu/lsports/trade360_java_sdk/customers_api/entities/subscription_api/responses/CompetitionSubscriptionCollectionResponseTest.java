package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionSubscriptionCollectionResponseTest {

    @Test
    void testFieldAssignment() {
        CompetitionSubscriptionCollectionResponse response = new CompetitionSubscriptionCollectionResponse();
        List<CompetitionSubscriptionResponse> subscription = List.of(new CompetitionSubscriptionResponse());
        
        response.subscription = subscription;
        
        assertEquals(subscription, response.subscription);
    }

    @Test
    void testNullFieldsAllowed() {
        CompetitionSubscriptionCollectionResponse response = new CompetitionSubscriptionCollectionResponse();
        
        response.subscription = null;
        
        assertNull(response.subscription);
    }

    @Test
    void testDefaultValues() {
        CompetitionSubscriptionCollectionResponse response = new CompetitionSubscriptionCollectionResponse();
        
        assertNull(response.subscription);
    }

    @Test
    void testEmptyList() {
        CompetitionSubscriptionCollectionResponse response = new CompetitionSubscriptionCollectionResponse();
        List<CompetitionSubscriptionResponse> emptyList = List.of();
        
        response.subscription = emptyList;
        
        assertEquals(emptyList, response.subscription);
        assertTrue(((List<CompetitionSubscriptionResponse>) response.subscription).isEmpty());
    }
}
