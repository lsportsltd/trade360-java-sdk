package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeasonMetadataTest {

    @Test
    void testConstructorWithAllFields() {
        SeasonMetadata season = new SeasonMetadata(100, "2024/2025");
        
        assertEquals(100, season.seasonId());
        assertEquals("2024/2025", season.seasonName());
    }

    @Test
    void testConstructorWithNullName() {
        SeasonMetadata season = new SeasonMetadata(200, null);
        
        assertEquals(200, season.seasonId());
        assertNull(season.seasonName());
    }

    @Test
    void testRecordEquality() {
        SeasonMetadata season1 = new SeasonMetadata(1, "2023/2024");
        SeasonMetadata season2 = new SeasonMetadata(1, "2023/2024");
        
        assertEquals(season1, season2);
        assertEquals(season1.hashCode(), season2.hashCode());
    }

    @Test
    void testRecordInequality() {
        SeasonMetadata season1 = new SeasonMetadata(1, "2023/2024");
        SeasonMetadata season2 = new SeasonMetadata(2, "2024/2025");
        
        assertNotEquals(season1, season2);
    }

    @Test
    void testToString() {
        SeasonMetadata season = new SeasonMetadata(1, "Summer 2024");
        
        String toString = season.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("SeasonMetadata"));
        assertTrue(toString.contains("Summer 2024"));
    }

    @Test
    void testZeroSeasonId() {
        SeasonMetadata season = new SeasonMetadata(0, "Zero ID Season");
        
        assertEquals(0, season.seasonId());
        assertEquals("Zero ID Season", season.seasonName());
    }

    @Test
    void testNegativeSeasonId() {
        SeasonMetadata season = new SeasonMetadata(-1, "Negative ID Season");
        
        assertEquals(-1, season.seasonId());
        assertEquals("Negative ID Season", season.seasonName());
    }

    @Test
    void testEmptyStringName() {
        SeasonMetadata season = new SeasonMetadata(1, "");
        
        assertEquals(1, season.seasonId());
        assertEquals("", season.seasonName());
    }

    @Test
    void testLargeSeasonId() {
        SeasonMetadata season = new SeasonMetadata(Integer.MAX_VALUE, "Max Season");
        
        assertEquals(Integer.MAX_VALUE, season.seasonId());
        assertEquals("Max Season", season.seasonName());
    }
}


