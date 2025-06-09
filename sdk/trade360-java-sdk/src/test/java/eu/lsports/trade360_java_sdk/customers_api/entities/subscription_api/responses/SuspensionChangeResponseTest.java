package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.SuspendedMarket;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuspensionChangeResponseTest {

    @Test
    void testFieldAssignment() {
        SuspensionChangeResponse response = new SuspensionChangeResponse();
        List<SuspendedMarket> markets = List.of(new SuspendedMarket());
        LocalDateTime creationDate = LocalDateTime.now();
        
        response.succeeded = true;
        response.reason = "Suspension changed successfully";
        response.fixtureId = 123;
        response.sportId = 456;
        response.locationId = 789;
        response.competitionId = 101;
        response.markets = markets;
        response.creationDate = creationDate;
        
        assertTrue(response.succeeded);
        assertEquals("Suspension changed successfully", response.reason);
        assertEquals(123, response.fixtureId);
        assertEquals(456, response.sportId);
        assertEquals(789, response.locationId);
        assertEquals(101, response.competitionId);
        assertEquals(markets, response.markets);
        assertEquals(creationDate, response.creationDate);
    }

    @Test
    void testNullFieldsAllowed() {
        SuspensionChangeResponse response = new SuspensionChangeResponse();
        
        response.succeeded = null;
        response.reason = null;
        response.fixtureId = null;
        response.sportId = null;
        response.locationId = null;
        response.competitionId = null;
        response.markets = null;
        response.creationDate = null;
        
        assertNull(response.succeeded);
        assertNull(response.reason);
        assertNull(response.fixtureId);
        assertNull(response.sportId);
        assertNull(response.locationId);
        assertNull(response.competitionId);
        assertNull(response.markets);
        assertNull(response.creationDate);
    }

    @Test
    void testDefaultValues() {
        SuspensionChangeResponse response = new SuspensionChangeResponse();
        
        assertNull(response.succeeded);
        assertNull(response.reason);
        assertNull(response.fixtureId);
        assertNull(response.sportId);
        assertNull(response.locationId);
        assertNull(response.competitionId);
        assertNull(response.markets);
        assertNull(response.creationDate);
    }

    @Test
    void testBooleanValues() {
        SuspensionChangeResponse response = new SuspensionChangeResponse();
        
        response.succeeded = false;
        assertFalse(response.succeeded);
        
        response.succeeded = true;
        assertTrue(response.succeeded);
    }
}
