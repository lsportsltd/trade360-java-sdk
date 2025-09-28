package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetCitiesRequestTest {

    @Test
    void testConstructorWithFilter() {
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(
            Arrays.asList(1, 2, 3),
            Arrays.asList(100, 200)
        );
        GetCitiesRequest request = new GetCitiesRequest(filter);
        
        assertNotNull(request);
        assertNotNull(request.filter());
        assertEquals(filter, request.filter());
    }

    @Test
    void testConstructorWithNullFilter() {
        GetCitiesRequest request = new GetCitiesRequest(null);
        
        assertNotNull(request);
        assertNull(request.filter());
    }

    @Test
    void testCitiesFilterWithAllFields() {
        Iterable<Integer> states = Arrays.asList(1, 2, 3);
        Iterable<Integer> countries = Arrays.asList(100, 200);
        
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(states, countries);
        
        assertNotNull(filter);
        assertEquals(states, filter.states());
        assertEquals(countries, filter.countries());
    }

    @Test
    void testCitiesFilterWithNullFields() {
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(null, null);
        
        assertNotNull(filter);
        assertNull(filter.states());
        assertNull(filter.countries());
    }

    @Test
    void testCitiesFilterWithEmptyCollections() {
        Iterable<Integer> empty = Collections.emptyList();
        
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(empty, empty);
        
        assertNotNull(filter);
        assertEquals(empty, filter.states());
        assertEquals(empty, filter.countries());
    }

    @Test
    void testCitiesFilterWithMixedNullAndNonNull() {
        Iterable<Integer> states = Arrays.asList(1, 2, 3);
        
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(states, null);
        
        assertNotNull(filter);
        assertEquals(states, filter.states());
        assertNull(filter.countries());
    }

    @Test
    void testCitiesFilterWithSingleValueCollections() {
        Iterable<Integer> singleState = Arrays.asList(1);
        Iterable<Integer> singleCountry = Arrays.asList(100);
        
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(singleState, singleCountry);
        
        assertNotNull(filter);
        assertEquals(singleState, filter.states());
        assertEquals(singleCountry, filter.countries());
    }

    @Test
    void testRecordEquality() {
        GetCitiesRequest.CitiesFilter filter1 = new GetCitiesRequest.CitiesFilter(
            Arrays.asList(1, 2), Arrays.asList(100)
        );
        GetCitiesRequest.CitiesFilter filter2 = new GetCitiesRequest.CitiesFilter(
            Arrays.asList(1, 2), Arrays.asList(100)
        );
        
        GetCitiesRequest request1 = new GetCitiesRequest(filter1);
        GetCitiesRequest request2 = new GetCitiesRequest(filter2);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(
            Arrays.asList(1, 2), Arrays.asList(100)
        );
        GetCitiesRequest request = new GetCitiesRequest(filter);
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetCitiesRequest"));
    }

    @Test
    void testFilterFieldsIndependence() {
        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(
            Arrays.asList(1, 2, 3), null
        );
        
        assertNotNull(filter.states());
        assertNull(filter.countries());
        
        // Verify states field is not affected by null countries
        assertEquals(3, ((java.util.List<Integer>) filter.states()).size());
    }
}


