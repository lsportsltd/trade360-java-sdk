package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionSubscriptionResponseTest {

    @Test
    void testFieldAssignment() {
        CompetitionSubscriptionResponse response = new CompetitionSubscriptionResponse();
        
        response.competitionId = 123;
        response.sportId = 456;
        response.locationId = 789;
        response.success = true;
        
        assertEquals(123, response.competitionId);
        assertEquals(456, response.sportId);
        assertEquals(789, response.locationId);
        assertTrue(response.success);
    }

    @Test
    void testNullFieldsAllowed() {
        CompetitionSubscriptionResponse response = new CompetitionSubscriptionResponse();
        
        response.success = null;
        
        assertNull(response.success);
    }

    @Test
    void testDefaultValues() {
        CompetitionSubscriptionResponse response = new CompetitionSubscriptionResponse();
        
        assertEquals(0, response.competitionId);
        assertEquals(0, response.sportId);
        assertEquals(0, response.locationId);
        assertNull(response.success);
    }

    @Test
    void testBooleanValues() {
        CompetitionSubscriptionResponse response = new CompetitionSubscriptionResponse();
        
        response.success = false;
        assertFalse(response.success);
        
        response.success = true;
        assertTrue(response.success);
    }
}
