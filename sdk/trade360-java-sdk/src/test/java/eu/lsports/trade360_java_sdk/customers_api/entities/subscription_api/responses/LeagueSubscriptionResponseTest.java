package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueSubscriptionResponseTest {

    @Test
    void testFieldAssignment() {
        LeagueSubscriptionResponse response = new LeagueSubscriptionResponse();
        
        response.leagueId = 123;
        response.sportId = 456;
        response.locationId = 789;
        response.success = true;
        response.message = "Subscription successful";
        
        assertEquals(123, response.leagueId);
        assertEquals(456, response.sportId);
        assertEquals(789, response.locationId);
        assertTrue(response.success);
        assertEquals("Subscription successful", response.message);
    }

    @Test
    void testNullFieldsAllowed() {
        LeagueSubscriptionResponse response = new LeagueSubscriptionResponse();
        
        response.success = null;
        response.message = null;
        
        assertNull(response.success);
        assertNull(response.message);
    }

    @Test
    void testDefaultValues() {
        LeagueSubscriptionResponse response = new LeagueSubscriptionResponse();
        
        assertEquals(0, response.leagueId);
        assertEquals(0, response.sportId);
        assertEquals(0, response.locationId);
        assertNull(response.success);
        assertNull(response.message);
    }

    @Test
    void testBooleanValues() {
        LeagueSubscriptionResponse response = new LeagueSubscriptionResponse();
        
        response.success = false;
        assertFalse(response.success);
        
        response.success = true;
        assertTrue(response.success);
    }
}
