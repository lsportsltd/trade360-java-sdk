package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetVenuesRequestTest {

    @Test
    void testConstructorWithFilter() {
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            Arrays.asList(1, 2, 3),
            Arrays.asList(10, 20),
            Arrays.asList(100, 200, 300),
            Arrays.asList(1000, 2000),
            Arrays.asList(10000, 20000, 30000)
        );
        GetVenuesRequest request = new GetVenuesRequest(filter);
        
        assertNotNull(request);
        assertNotNull(request.filter());
        assertEquals(filter, request.filter());
    }

    @Test
    void testConstructorWithNullFilter() {
        GetVenuesRequest request = new GetVenuesRequest(null);
        
        assertNotNull(request);
        assertNull(request.filter());
    }

    @Test
    void testVenuesFilterWithAllFields() {
        Iterable<Integer> sports = Arrays.asList(1, 2, 3);
        Iterable<Integer> locations = Arrays.asList(10, 20);
        Iterable<Integer> cities = Arrays.asList(100, 200);
        Iterable<Integer> states = Arrays.asList(1000, 2000);
        Iterable<Integer> countries = Arrays.asList(10000, 20000);
        
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            sports, locations, cities, states, countries
        );
        
        assertNotNull(filter);
        assertEquals(sports, filter.sports());
        assertEquals(locations, filter.locations());
        assertEquals(cities, filter.cities());
        assertEquals(states, filter.states());
        assertEquals(countries, filter.countries());
    }

    @Test
    void testVenuesFilterWithNullFields() {
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            null, null, null, null, null
        );
        
        assertNotNull(filter);
        assertNull(filter.sports());
        assertNull(filter.locations());
        assertNull(filter.cities());
        assertNull(filter.states());
        assertNull(filter.countries());
    }

    @Test
    void testVenuesFilterWithEmptyCollections() {
        Iterable<Integer> empty = Collections.emptyList();
        
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            empty, empty, empty, empty, empty
        );
        
        assertNotNull(filter);
        assertEquals(empty, filter.sports());
        assertEquals(empty, filter.locations());
        assertEquals(empty, filter.cities());
        assertEquals(empty, filter.states());
        assertEquals(empty, filter.countries());
    }

    @Test
    void testVenuesFilterWithMixedNullAndNonNull() {
        Iterable<Integer> sports = Arrays.asList(1, 2, 3);
        Iterable<Integer> cities = Arrays.asList(100, 200);
        
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            sports, null, cities, null, null
        );
        
        assertNotNull(filter);
        assertEquals(sports, filter.sports());
        assertNull(filter.locations());
        assertEquals(cities, filter.cities());
        assertNull(filter.states());
        assertNull(filter.countries());
    }

    @Test
    void testVenuesFilterWithSingleValueCollections() {
        Iterable<Integer> singleSport = Arrays.asList(1);
        Iterable<Integer> singleLocation = Arrays.asList(10);
        Iterable<Integer> singleCity = Arrays.asList(100);
        Iterable<Integer> singleState = Arrays.asList(1000);
        Iterable<Integer> singleCountry = Arrays.asList(10000);
        
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            singleSport, singleLocation, singleCity, singleState, singleCountry
        );
        
        assertNotNull(filter);
        assertEquals(singleSport, filter.sports());
        assertEquals(singleLocation, filter.locations());
        assertEquals(singleCity, filter.cities());
        assertEquals(singleState, filter.states());
        assertEquals(singleCountry, filter.countries());
    }

    @Test
    void testRecordEquality() {
        GetVenuesRequest.VenuesFilter filter1 = new GetVenuesRequest.VenuesFilter(
            Arrays.asList(1, 2), Arrays.asList(10), null, null, Arrays.asList(100)
        );
        GetVenuesRequest.VenuesFilter filter2 = new GetVenuesRequest.VenuesFilter(
            Arrays.asList(1, 2), Arrays.asList(10), null, null, Arrays.asList(100)
        );
        
        GetVenuesRequest request1 = new GetVenuesRequest(filter1);
        GetVenuesRequest request2 = new GetVenuesRequest(filter2);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            Arrays.asList(1, 2), null, Arrays.asList(100), null, null
        );
        GetVenuesRequest request = new GetVenuesRequest(filter);
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetVenuesRequest"));
    }
}


