package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetStatesRequestTest {

    @Test
    void testConstructorWithFilter() {
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2, 3));
        GetStatesRequest request = new GetStatesRequest(filter);
        
        assertNotNull(request);
        assertNotNull(request.filter());
        assertEquals(filter, request.filter());
    }

    @Test
    void testConstructorWithNullFilter() {
        GetStatesRequest request = new GetStatesRequest(null);
        
        assertNotNull(request);
        assertNull(request.filter());
    }

    @Test
    void testStatesFilterWithCountries() {
        Iterable<Integer> countries = Arrays.asList(1, 2, 3);
        
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(countries);
        
        assertNotNull(filter);
        assertEquals(countries, filter.countries());
    }

    @Test
    void testStatesFilterWithNullCountries() {
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(null);
        
        assertNotNull(filter);
        assertNull(filter.countries());
    }

    @Test
    void testStatesFilterWithEmptyCollection() {
        Iterable<Integer> empty = Collections.emptyList();
        
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(empty);
        
        assertNotNull(filter);
        assertEquals(empty, filter.countries());
    }

    @Test
    void testStatesFilterWithSingleValueCollection() {
        Iterable<Integer> singleCountry = Arrays.asList(100);
        
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(singleCountry);
        
        assertNotNull(filter);
        assertEquals(singleCountry, filter.countries());
    }

    @Test
    void testStatesFilterWithMultipleValues() {
        Iterable<Integer> countries = Arrays.asList(1, 5, 10, 15, 20);
        
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(countries);
        
        assertNotNull(filter);
        assertEquals(countries, filter.countries());
        assertEquals(5, ((java.util.List<Integer>) filter.countries()).size());
    }

    @Test
    void testRecordEquality() {
        GetStatesRequest.CountriesFilter filter1 = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2, 3));
        GetStatesRequest.CountriesFilter filter2 = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2, 3));
        
        GetStatesRequest request1 = new GetStatesRequest(filter1);
        GetStatesRequest request2 = new GetStatesRequest(filter2);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testRecordInequality() {
        GetStatesRequest.CountriesFilter filter1 = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2, 3));
        GetStatesRequest.CountriesFilter filter2 = new GetStatesRequest.CountriesFilter(Arrays.asList(4, 5, 6));
        
        GetStatesRequest request1 = new GetStatesRequest(filter1);
        GetStatesRequest request2 = new GetStatesRequest(filter2);
        
        assertNotEquals(request1, request2);
    }

    @Test
    void testToString() {
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2, 3));
        GetStatesRequest request = new GetStatesRequest(filter);
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetStatesRequest"));
    }

    @Test
    void testFilterToString() {
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(Arrays.asList(100, 200));
        
        String toString = filter.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("CountriesFilter"));
    }

    @Test
    void testNullFilterEquality() {
        GetStatesRequest request1 = new GetStatesRequest(null);
        GetStatesRequest request2 = new GetStatesRequest(null);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testMixedNullFilterEquality() {
        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(Arrays.asList(1, 2));
        GetStatesRequest request1 = new GetStatesRequest(filter);
        GetStatesRequest request2 = new GetStatesRequest(null);
        
        assertNotEquals(request1, request2);
    }
}
