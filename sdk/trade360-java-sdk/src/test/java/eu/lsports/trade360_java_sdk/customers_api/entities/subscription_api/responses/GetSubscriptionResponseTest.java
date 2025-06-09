package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetSubscriptionResponseTest {

    @Test
    void testFieldAssignment() {
        GetSubscriptionResponse response = new GetSubscriptionResponse();
        List<Integer> fixtures = List.of(123, 456);
        
        response.fixtures = fixtures;
        
        assertEquals(fixtures, response.fixtures);
    }

    @Test
    void testNullFieldsAllowed() {
        GetSubscriptionResponse response = new GetSubscriptionResponse();
        
        response.fixtures = null;
        
        assertNull(response.fixtures);
    }

    @Test
    void testDefaultValues() {
        GetSubscriptionResponse response = new GetSubscriptionResponse();
        
        assertNull(response.fixtures);
    }

    @Test
    void testEmptyList() {
        GetSubscriptionResponse response = new GetSubscriptionResponse();
        List<Integer> emptyList = List.of();
        
        response.fixtures = emptyList;
        
        assertEquals(emptyList, response.fixtures);
        assertTrue(((List<Integer>) response.fixtures).isEmpty());
    }
}
