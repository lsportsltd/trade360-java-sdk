package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetToursResponseTest {

    @Test
    void testConstructorWithTours() {
        TourMetadata tour1 = new TourMetadata(1, "Tour 1", 100, "Sport 1");
        TourMetadata tour2 = new TourMetadata(2, "Tour 2", 200, "Sport 2");
        Iterable<TourMetadata> tours = Arrays.asList(tour1, tour2);
        
        GetToursResponse response = new GetToursResponse();
        response.tours = tours;
        
        assertNotNull(response);
        assertEquals(tours, response.tours);
    }

    @Test
    void testConstructorWithNullTours() {
        GetToursResponse response = new GetToursResponse();
        response.tours = null;
        
        assertNotNull(response);
        assertNull(response.tours);
    }

    @Test
    void testConstructorWithEmptyTours() {
        Iterable<TourMetadata> emptyTours = Collections.emptyList();
        
        GetToursResponse response = new GetToursResponse();
        response.tours = emptyTours;
        
        assertNotNull(response);
        assertEquals(emptyTours, response.tours);
    }

    @Test
    void testConstructorWithSingleTour() {
        TourMetadata tour = new TourMetadata(100, "Single Tour", 50, "Sport");
        Iterable<TourMetadata> tours = Arrays.asList(tour);
        
        GetToursResponse response = new GetToursResponse();
        response.tours = tours;
        
        assertNotNull(response);
        assertEquals(tours, response.tours);
        assertEquals(1, ((java.util.List<TourMetadata>) response.tours).size());
    }

    @Test
    void testToursFieldAssignment() {
        TourMetadata tour1 = new TourMetadata(1, "Tour A", 100, "Sport A");
        TourMetadata tour2 = new TourMetadata(1, "Tour A", 100, "Sport A");
        
        GetToursResponse response1 = new GetToursResponse();
        response1.tours = Arrays.asList(tour1);
        
        GetToursResponse response2 = new GetToursResponse();
        response2.tours = Arrays.asList(tour2);
        
        assertNotNull(response1.tours);
        assertNotNull(response2.tours);
    }

    @Test
    void testToursFieldInequality() {
        TourMetadata tour1 = new TourMetadata(1, "Tour 1", 100, "Sport 1");
        TourMetadata tour2 = new TourMetadata(2, "Tour 2", 200, "Sport 2");
        
        GetToursResponse response1 = new GetToursResponse();
        response1.tours = Arrays.asList(tour1);
        
        GetToursResponse response2 = new GetToursResponse();
        response2.tours = Arrays.asList(tour2);
        
        assertNotEquals(response1.tours, response2.tours);
    }

    @Test
    void testToString() {
        TourMetadata tour = new TourMetadata(1, "Test Tour", 50, "Test Sport");
        GetToursResponse response = new GetToursResponse();
        response.tours = Arrays.asList(tour);
        
        String toString = response.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetToursResponse"));
    }

    @Test
    void testNullToursEquality() {
        GetToursResponse response1 = new GetToursResponse();
        response1.tours = null;
        
        GetToursResponse response2 = new GetToursResponse();
        response2.tours = null;
        
        assertEquals(response1.tours, response2.tours);
    }

    @Test
    void testMixedNullToursInequality() {
        TourMetadata tour = new TourMetadata(1, "Tour", 100, "Sport");
        
        GetToursResponse response1 = new GetToursResponse();
        response1.tours = Arrays.asList(tour);
        
        GetToursResponse response2 = new GetToursResponse();
        response2.tours = null;
        
        assertNotEquals(response1.tours, response2.tours);
    }
}


