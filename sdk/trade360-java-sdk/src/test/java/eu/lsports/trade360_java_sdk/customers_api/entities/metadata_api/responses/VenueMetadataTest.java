package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VenueMetadataTest {

    @Test
    void testConstructorWithAllFields() {
        IdNamePair country = new IdNamePair(1, "USA");
        IdNamePair state = new IdNamePair(2, "California");
        IdNamePair city = new IdNamePair(3, "Los Angeles");
        
        VenueMetadata venue = new VenueMetadata(100, "Stadium", country, state, city);
        
        assertEquals(100, venue.venueId());
        assertEquals("Stadium", venue.name());
        assertEquals(country, venue.country());
        assertEquals(state, venue.state());
        assertEquals(city, venue.city());
    }

    @Test
    void testConstructorWithNullFields() {
        VenueMetadata venue = new VenueMetadata(200, "Venue Name", null, null, null);
        
        assertEquals(200, venue.venueId());
        assertEquals("Venue Name", venue.name());
        assertNull(venue.country());
        assertNull(venue.state());
        assertNull(venue.city());
    }

    @Test
    void testConstructorWithMixedNullFields() {
        IdNamePair country = new IdNamePair(1, "Canada");
        IdNamePair city = new IdNamePair(3, "Toronto");
        
        VenueMetadata venue = new VenueMetadata(300, "Mixed Venue", country, null, city);
        
        assertEquals(300, venue.venueId());
        assertEquals("Mixed Venue", venue.name());
        assertEquals(country, venue.country());
        assertNull(venue.state());
        assertEquals(city, venue.city());
    }

    @Test
    void testRecordEquality() {
        IdNamePair country1 = new IdNamePair(1, "UK");
        IdNamePair country2 = new IdNamePair(1, "UK");
        
        VenueMetadata venue1 = new VenueMetadata(1, "Wembley", country1, null, null);
        VenueMetadata venue2 = new VenueMetadata(1, "Wembley", country2, null, null);
        
        assertEquals(venue1, venue2);
        assertEquals(venue1.hashCode(), venue2.hashCode());
    }

    @Test
    void testRecordInequality() {
        IdNamePair country = new IdNamePair(1, "France");
        
        VenueMetadata venue1 = new VenueMetadata(1, "Stadium 1", country, null, null);
        VenueMetadata venue2 = new VenueMetadata(2, "Stadium 2", country, null, null);
        
        assertNotEquals(venue1, venue2);
    }

    @Test
    void testToString() {
        IdNamePair country = new IdNamePair(1, "Germany");
        
        VenueMetadata venue = new VenueMetadata(1, "Allianz Arena", country, null, null);
        
        String toString = venue.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("VenueMetadata"));
        assertTrue(toString.contains("Allianz Arena"));
    }

    @Test
    void testNullNameHandling() {
        VenueMetadata venue = new VenueMetadata(1, null, null, null, null);
        
        assertEquals(1, venue.venueId());
        assertNull(venue.name());
        assertNull(venue.country());
        assertNull(venue.state());
        assertNull(venue.city());
    }

    @Test
    void testZeroVenueId() {
        VenueMetadata venue = new VenueMetadata(0, "Zero ID Venue", null, null, null);
        
        assertEquals(0, venue.venueId());
        assertEquals("Zero ID Venue", venue.name());
    }

    @Test
    void testNegativeVenueId() {
        VenueMetadata venue = new VenueMetadata(-1, "Negative ID Venue", null, null, null);
        
        assertEquals(-1, venue.venueId());
        assertEquals("Negative ID Venue", venue.name());
    }

    @Test
    void testComplexLocationHierarchy() {
        IdNamePair country = new IdNamePair(100, "Spain");
        IdNamePair state = new IdNamePair(200, "Catalonia");
        IdNamePair city = new IdNamePair(300, "Barcelona");
        
        VenueMetadata venue = new VenueMetadata(1000, "Camp Nou", country, state, city);
        
        assertEquals(1000, venue.venueId());
        assertEquals("Camp Nou", venue.name());
        assertEquals(100, venue.country().id());
        assertEquals("Spain", venue.country().name());
        assertEquals(200, venue.state().id());
        assertEquals("Catalonia", venue.state().name());
        assertEquals(300, venue.city().id());
        assertEquals("Barcelona", venue.city().name());
    }

    @Test
    void testEmptyStringName() {
        VenueMetadata venue = new VenueMetadata(1, "", null, null, null);
        
        assertEquals(1, venue.venueId());
        assertEquals("", venue.name());
    }
}


