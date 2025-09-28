package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.CourtSurface;
import eu.lsports.trade360_java_sdk.common.entities.enums.VenueAssignment;
import eu.lsports.trade360_java_sdk.common.entities.enums.VenueEnvironment;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixtureVenueTest {

    @Test
    void testDefaultConstructor() {
        FixtureVenue venue = new FixtureVenue();
        
        assertNotNull(venue);
        assertEquals(0, venue.id);
        assertNull(venue.name);
        assertNull(venue.city);
        assertNull(venue.state);
        assertNull(venue.country);
        assertNull(venue.capacity);
        assertNull(venue.courtSurfaceType);
        assertNull(venue.environment);
        assertNull(venue.assignment);
    }

    @Test
    void testBasicFieldAssignment() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.id = 123;
        venue.name = "Test Stadium";
        
        assertEquals(123, venue.id);
        assertEquals("Test Stadium", venue.name);
        assertNull(venue.city);
        assertNull(venue.state);
        assertNull(venue.country);
    }

    @Test
    void testLocationFieldAssignment() {
        FixtureVenue venue = new FixtureVenue();
        
        IdNamePair city = new IdNamePair(1, "New York");
        IdNamePair state = new IdNamePair(2, "New York State");
        IdNamePair country = new IdNamePair(3, "USA");

        venue.city = city;
        venue.state = state;
        venue.country = country;

        assertEquals(city, venue.city);
        assertEquals(state, venue.state);
        assertEquals(country, venue.country);
        assertEquals(1, venue.city.id());
        assertEquals("New York", venue.city.name());
        assertEquals(2, venue.state.id());
        assertEquals("New York State", venue.state.name());
        assertEquals(3, venue.country.id());
        assertEquals("USA", venue.country.name());
    }

    @Test
    void testCapacityAssignment() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.capacity = 50000;
        
        assertEquals(50000, venue.capacity);
        assertNull(venue.courtSurfaceType);
        assertNull(venue.environment);
        assertNull(venue.assignment);
    }

    @Test
    void testEnumFieldAssignment() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.courtSurfaceType = CourtSurface.GRASS;
        venue.environment = VenueEnvironment.OUTDOORS;
        venue.assignment = VenueAssignment.HOME;
        
        assertEquals(CourtSurface.GRASS, venue.courtSurfaceType);
        assertEquals(VenueEnvironment.OUTDOORS, venue.environment);
        assertEquals(VenueAssignment.HOME, venue.assignment);
    }

    @Test
    void testAllEnumValues() {
        FixtureVenue venue1 = new FixtureVenue();
        venue1.courtSurfaceType = CourtSurface.HARD;
        venue1.environment = VenueEnvironment.INDOORS;
        venue1.assignment = VenueAssignment.AWAY;
        
        FixtureVenue venue2 = new FixtureVenue();
        venue2.courtSurfaceType = CourtSurface.CLAY;
        venue2.assignment = VenueAssignment.NEUTRAL;
        
        FixtureVenue venue3 = new FixtureVenue();
        venue3.courtSurfaceType = CourtSurface.ARTIFICIAL_GRASS;
        
        assertEquals(CourtSurface.HARD, venue1.courtSurfaceType);
        assertEquals(VenueEnvironment.INDOORS, venue1.environment);
        assertEquals(VenueAssignment.AWAY, venue1.assignment);
        
        assertEquals(CourtSurface.CLAY, venue2.courtSurfaceType);
        assertEquals(VenueAssignment.NEUTRAL, venue2.assignment);
        assertNull(venue2.environment);
        
        assertEquals(CourtSurface.ARTIFICIAL_GRASS, venue3.courtSurfaceType);
        assertNull(venue3.environment);
        assertNull(venue3.assignment);
    }

    @Test
    void testCompleteVenueAssignment() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.id = 456;
        venue.name = "Wimbledon Centre Court";
        
        venue.city = new IdNamePair(10, "London");
        venue.state = new IdNamePair(20, "England");
        venue.country = new IdNamePair(30, "United Kingdom");
        
        venue.capacity = 15000;
        venue.courtSurfaceType = CourtSurface.GRASS;
        venue.environment = VenueEnvironment.OUTDOORS;
        venue.assignment = VenueAssignment.NEUTRAL;
        
        assertEquals(456, venue.id);
        assertEquals("Wimbledon Centre Court", venue.name);
        assertEquals(10, venue.city.id());
        assertEquals("London", venue.city.name());
        assertEquals(20, venue.state.id());
        assertEquals("England", venue.state.name());
        assertEquals(30, venue.country.id());
        assertEquals("United Kingdom", venue.country.name());
        assertEquals(15000, venue.capacity);
        assertEquals(CourtSurface.GRASS, venue.courtSurfaceType);
        assertEquals(VenueEnvironment.OUTDOORS, venue.environment);
        assertEquals(VenueAssignment.NEUTRAL, venue.assignment);
    }

    @Test
    void testNullFieldsHandling() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.id = 789;
        venue.name = "Test Venue";
        venue.city = null;
        venue.state = null;
        venue.country = null;
        venue.capacity = null;
        venue.courtSurfaceType = null;
        venue.environment = null;
        venue.assignment = null;
        
        assertEquals(789, venue.id);
        assertEquals("Test Venue", venue.name);
        assertNull(venue.city);
        assertNull(venue.state);
        assertNull(venue.country);
        assertNull(venue.capacity);
        assertNull(venue.courtSurfaceType);
        assertNull(venue.environment);
        assertNull(venue.assignment);
    }

    @Test
    void testZeroCapacityHandling() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.capacity = 0;
        
        assertEquals(0, venue.capacity);
    }

    @Test
    void testNegativeCapacityHandling() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.capacity = -1;
        
        assertEquals(-1, venue.capacity);
    }

    @Test
    void testFieldModification() {
        FixtureVenue venue = new FixtureVenue();
        
        venue.id = 100;
        venue.name = "Initial Name";
        venue.courtSurfaceType = CourtSurface.HARD;
        
        assertEquals(100, venue.id);
        assertEquals("Initial Name", venue.name);
        assertEquals(CourtSurface.HARD, venue.courtSurfaceType);
        
        venue.id = 200;
        venue.name = "Updated Name";
        venue.courtSurfaceType = CourtSurface.CLAY;
        
        assertEquals(200, venue.id);
        assertEquals("Updated Name", venue.name);
        assertEquals(CourtSurface.CLAY, venue.courtSurfaceType);
        
        venue.name = null;
        venue.courtSurfaceType = null;
        
        assertEquals(200, venue.id);
        assertNull(venue.name);
        assertNull(venue.courtSurfaceType);
    }
}


