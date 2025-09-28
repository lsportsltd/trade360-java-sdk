package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetCitiesResponseTest {

    @Test
    void testConstructorWithCities() {
        CityMetadata city1 = new CityMetadata(1, "New York", null, null);
        CityMetadata city2 = new CityMetadata(2, "Los Angeles", null, null);
        Iterable<CityMetadata> cities = Arrays.asList(city1, city2);
        
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = cities;
        
        assertNotNull(response);
        assertEquals(cities, response.data);
    }

    @Test
    void testConstructorWithNullCities() {
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = null;
        
        assertNotNull(response);
        assertNull(response.data);
    }

    @Test
    void testConstructorWithEmptyCities() {
        Iterable<CityMetadata> emptyCities = Collections.emptyList();
        
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = emptyCities;
        
        assertNotNull(response);
        assertEquals(emptyCities, response.data);
    }

    @Test
    void testConstructorWithSingleCity() {
        CityMetadata city = new CityMetadata(100, "Single City", null, null);
        Iterable<CityMetadata> cities = Arrays.asList(city);
        
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = cities;
        
        assertNotNull(response);
        assertEquals(cities, response.data);
        assertEquals(1, ((java.util.List<CityMetadata>) response.data).size());
    }

    @Test
    void testDataFieldAssignment() {
        CityMetadata city1 = new CityMetadata(1, "Chicago", null, null);
        CityMetadata city2 = new CityMetadata(1, "Chicago", null, null);
        
        GetCitiesResponse response1 = new GetCitiesResponse();
        response1.data = Arrays.asList(city1);
        
        GetCitiesResponse response2 = new GetCitiesResponse();
        response2.data = Arrays.asList(city2);
        
        assertNotNull(response1.data);
        assertNotNull(response2.data);
    }

    @Test
    void testDataFieldInequality() {
        CityMetadata city1 = new CityMetadata(1, "Chicago", null, null);
        CityMetadata city2 = new CityMetadata(2, "Boston", null, null);
        
        GetCitiesResponse response1 = new GetCitiesResponse();
        response1.data = Arrays.asList(city1);
        
        GetCitiesResponse response2 = new GetCitiesResponse();
        response2.data = Arrays.asList(city2);
        
        assertNotEquals(response1.data, response2.data);
    }

    @Test
    void testToString() {
        CityMetadata city = new CityMetadata(1, "Test City", null, null);
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = Arrays.asList(city);
        
        String toString = response.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetCitiesResponse"));
    }

    @Test
    void testNullDataEquality() {
        GetCitiesResponse response1 = new GetCitiesResponse();
        response1.data = null;
        
        GetCitiesResponse response2 = new GetCitiesResponse();
        response2.data = null;
        
        assertEquals(response1.data, response2.data);
    }

    @Test
    void testMixedNullDataInequality() {
        CityMetadata city = new CityMetadata(1, "City", null, null);
        
        GetCitiesResponse response1 = new GetCitiesResponse();
        response1.data = Arrays.asList(city);
        
        GetCitiesResponse response2 = new GetCitiesResponse();
        response2.data = null;
        
        assertNotEquals(response1.data, response2.data);
    }

    @Test
    void testMultipleCities() {
        CityMetadata city1 = new CityMetadata(1, "Miami", null, null);
        CityMetadata city2 = new CityMetadata(2, "Seattle", null, null);
        CityMetadata city3 = new CityMetadata(3, "Denver", null, null);
        Iterable<CityMetadata> cities = Arrays.asList(city1, city2, city3);
        
        GetCitiesResponse response = new GetCitiesResponse();
        response.data = cities;
        
        assertNotNull(response);
        assertEquals(cities, response.data);
        assertEquals(3, ((java.util.List<CityMetadata>) response.data).size());
    }
}