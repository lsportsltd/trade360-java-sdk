package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetVenuesResponseTest {

    @Test
    void testConstructorWithVenues() {
        VenueMetadata venue1 = new VenueMetadata(1, "Stadium 1", null, null, null);
        VenueMetadata venue2 = new VenueMetadata(2, "Stadium 2", null, null, null);
        Iterable<VenueMetadata> venues = Arrays.asList(venue1, venue2);
        
        GetVenuesResponse response = new GetVenuesResponse();
        response.data = venues;
        
        assertNotNull(response);
        assertEquals(venues, response.data);
    }

    @Test
    void testConstructorWithNullVenues() {
        GetVenuesResponse response = new GetVenuesResponse();
        response.data = null;
        
        assertNotNull(response);
        assertNull(response.data);
    }

    @Test
    void testConstructorWithEmptyVenues() {
        Iterable<VenueMetadata> emptyVenues = Collections.emptyList();
        
        GetVenuesResponse response = new GetVenuesResponse();
        response.data = emptyVenues;
        
        assertNotNull(response);
        assertEquals(emptyVenues, response.data);
    }

    @Test
    void testConstructorWithSingleVenue() {
        VenueMetadata venue = new VenueMetadata(100, "Single Stadium", null, null, null);
        Iterable<VenueMetadata> venues = Arrays.asList(venue);
        
        GetVenuesResponse response = new GetVenuesResponse();
        response.data = venues;
        
        assertNotNull(response);
        assertEquals(venues, response.data);
        assertEquals(1, ((java.util.List<VenueMetadata>) response.data).size());
    }

    @Test
    void testDataFieldAssignment() {
        VenueMetadata venue1 = new VenueMetadata(1, "Stadium", null, null, null);
        VenueMetadata venue2 = new VenueMetadata(1, "Stadium", null, null, null);
        
        GetVenuesResponse response1 = new GetVenuesResponse();
        response1.data = Arrays.asList(venue1);
        
        GetVenuesResponse response2 = new GetVenuesResponse();
        response2.data = Arrays.asList(venue2);
        
        assertNotNull(response1.data);
        assertNotNull(response2.data);
    }

    @Test
    void testDataFieldInequality() {
        VenueMetadata venue1 = new VenueMetadata(1, "Stadium 1", null, null, null);
        VenueMetadata venue2 = new VenueMetadata(2, "Stadium 2", null, null, null);
        
        GetVenuesResponse response1 = new GetVenuesResponse();
        response1.data = Arrays.asList(venue1);
        
        GetVenuesResponse response2 = new GetVenuesResponse();
        response2.data = Arrays.asList(venue2);
        
        assertNotEquals(response1.data, response2.data);
    }

    @Test
    void testToString() {
        VenueMetadata venue = new VenueMetadata(1, "Test Stadium", null, null, null);
        GetVenuesResponse response = new GetVenuesResponse();
        response.data = Arrays.asList(venue);
        
        String toString = response.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetVenuesResponse"));
    }

    @Test
    void testNullDataEquality() {
        GetVenuesResponse response1 = new GetVenuesResponse();
        response1.data = null;
        
        GetVenuesResponse response2 = new GetVenuesResponse();
        response2.data = null;
        
        assertEquals(response1.data, response2.data);
    }

    @Test
    void testMixedNullDataInequality() {
        VenueMetadata venue = new VenueMetadata(1, "Stadium", null, null, null);
        
        GetVenuesResponse response1 = new GetVenuesResponse();
        response1.data = Arrays.asList(venue);
        
        GetVenuesResponse response2 = new GetVenuesResponse();
        response2.data = null;
        
        assertNotEquals(response1.data, response2.data);
    }
}