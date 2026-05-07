package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourMetadataTest {

    @Test
    void testConstructorWithAllFields() {
        TourMetadata tour = new TourMetadata(100, "Grand Slam Tour", 6046, "Football");
        
        assertEquals(100, tour.tourId());
        assertEquals("Grand Slam Tour", tour.tourName());
        assertEquals(6046, tour.sportId());
        assertEquals("Football", tour.sportName());
    }

    @Test
    void testConstructorWithNullFields() {
        TourMetadata tour = new TourMetadata(200, null, null, null);
        
        assertEquals(200, tour.tourId());
        assertNull(tour.tourName());
        assertNull(tour.sportId());
        assertNull(tour.sportName());
    }

    @Test
    void testConstructorWithMixedNullFields() {
        TourMetadata tour = new TourMetadata(300, "Mixed Tour", null, "Basketball");
        
        assertEquals(300, tour.tourId());
        assertEquals("Mixed Tour", tour.tourName());
        assertNull(tour.sportId());
        assertEquals("Basketball", tour.sportName());
    }

    @Test
    void testRecordEquality() {
        TourMetadata tour1 = new TourMetadata(1, "Tour A", 100, "Sport A");
        TourMetadata tour2 = new TourMetadata(1, "Tour A", 100, "Sport A");
        
        assertEquals(tour1, tour2);
        assertEquals(tour1.hashCode(), tour2.hashCode());
    }

    @Test
    void testRecordInequality() {
        TourMetadata tour1 = new TourMetadata(1, "Tour A", 100, "Sport A");
        TourMetadata tour2 = new TourMetadata(2, "Tour B", 200, "Sport B");
        
        assertNotEquals(tour1, tour2);
    }

    @Test
    void testToString() {
        TourMetadata tour = new TourMetadata(1, "World Tour", 50, "Tennis");
        
        String toString = tour.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("TourMetadata"));
        assertTrue(toString.contains("World Tour"));
        assertTrue(toString.contains("Tennis"));
    }

    @Test
    void testZeroTourId() {
        TourMetadata tour = new TourMetadata(0, "Zero ID Tour", 0, "Sport");
        
        assertEquals(0, tour.tourId());
        assertEquals("Zero ID Tour", tour.tourName());
        assertEquals(0, tour.sportId());
    }

    @Test
    void testNegativeTourId() {
        TourMetadata tour = new TourMetadata(-1, "Negative ID Tour", -100, "Sport");
        
        assertEquals(-1, tour.tourId());
        assertEquals("Negative ID Tour", tour.tourName());
        assertEquals(-100, tour.sportId());
    }

    @Test
    void testEmptyStringNames() {
        TourMetadata tour = new TourMetadata(1, "", 100, "");
        
        assertEquals(1, tour.tourId());
        assertEquals("", tour.tourName());
        assertEquals(100, tour.sportId());
        assertEquals("", tour.sportName());
    }

    @Test
    void testLargeTourId() {
        TourMetadata tour = new TourMetadata(Integer.MAX_VALUE, "Max Tour", Integer.MAX_VALUE, "Max Sport");
        
        assertEquals(Integer.MAX_VALUE, tour.tourId());
        assertEquals("Max Tour", tour.tourName());
        assertEquals(Integer.MAX_VALUE, tour.sportId());
        assertEquals("Max Sport", tour.sportName());
    }
}


