package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityMetadataTest {

    @Test
    void testConstructorWithValidData() {
        CityMetadata city = new CityMetadata(1, "New York", null, null);
        
        assertEquals(1, city.cityId());
        assertEquals("New York", city.name());
    }

    @Test
    void testConstructorWithNullName() {
        CityMetadata city = new CityMetadata(2, null, null, null);
        
        assertEquals(2, city.cityId());
        assertNull(city.name());
    }

    @Test
    void testConstructorWithEmptyName() {
        CityMetadata city = new CityMetadata(3, "", null, null);
        
        assertEquals(3, city.cityId());
        assertEquals("", city.name());
    }

    @Test
    void testRecordEquality() {
        CityMetadata city1 = new CityMetadata(1, "Chicago", null, null);
        CityMetadata city2 = new CityMetadata(1, "Chicago", null, null);
        
        assertEquals(city1, city2);
        assertEquals(city1.hashCode(), city2.hashCode());
    }

    @Test
    void testRecordInequalityById() {
        CityMetadata city1 = new CityMetadata(1, "Boston", null, null);
        CityMetadata city2 = new CityMetadata(2, "Boston", null, null);
        
        assertNotEquals(city1, city2);
    }

    @Test
    void testRecordInequalityByName() {
        CityMetadata city1 = new CityMetadata(1, "Miami", null, null);
        CityMetadata city2 = new CityMetadata(1, "Orlando", null, null);
        
        assertNotEquals(city1, city2);
    }

    @Test
    void testToString() {
        CityMetadata city = new CityMetadata(100, "Los Angeles", null, null);
        
        String toString = city.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("CityMetadata"));
        assertTrue(toString.contains("Los Angeles"));
        assertTrue(toString.contains("100"));
    }

    @Test
    void testZeroCityId() {
        CityMetadata city = new CityMetadata(0, "Zero City", null, null);
        
        assertEquals(0, city.cityId());
        assertEquals("Zero City", city.name());
    }

    @Test
    void testNegativeCityId() {
        CityMetadata city = new CityMetadata(-1, "Negative City", null, null);
        
        assertEquals(-1, city.cityId());
        assertEquals("Negative City", city.name());
    }

    @Test
    void testLargeCityId() {
        CityMetadata city = new CityMetadata(Integer.MAX_VALUE, "Max City", null, null);
        
        assertEquals(Integer.MAX_VALUE, city.cityId());
        assertEquals("Max City", city.name());
    }

    @Test
    void testSpecialCharactersInName() {
        CityMetadata city = new CityMetadata(1, "São Paulo", null, null);
        
        assertEquals(1, city.cityId());
        assertEquals("São Paulo", city.name());
    }

    @Test
    void testLongCityName() {
        String longName = "A".repeat(100);
        CityMetadata city = new CityMetadata(1, longName, null, null);
        
        assertEquals(1, city.cityId());
        assertEquals(longName, city.name());
    }

    @Test
    void testNullNameEquality() {
        CityMetadata city1 = new CityMetadata(1, null, null, null);
        CityMetadata city2 = new CityMetadata(1, null, null, null);
        
        assertEquals(city1, city2);
        assertEquals(city1.hashCode(), city2.hashCode());
    }

    @Test
    void testMixedNullNameInequality() {
        CityMetadata city1 = new CityMetadata(1, "Seattle", null, null);
        CityMetadata city2 = new CityMetadata(1, null, null, null);
        
        assertNotEquals(city1, city2);
    }

    @Test
    void testWhitespaceInName() {
        CityMetadata city = new CityMetadata(1, "  City with spaces  ", null, null);
        
        assertEquals(1, city.cityId());
        assertEquals("  City with spaces  ", city.name());
    }
}
