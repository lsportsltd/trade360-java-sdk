package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetSeasonsResponseTest {

    @Test
    void testConstructorWithSeasons() {
        SeasonMetadata season1 = new SeasonMetadata(1, "2023/2024");
        SeasonMetadata season2 = new SeasonMetadata(2, "2024/2025");
        Iterable<SeasonMetadata> seasons = Arrays.asList(season1, season2);
        
        GetSeasonsResponse response = new GetSeasonsResponse();
        response.seasons = seasons;
        
        assertNotNull(response);
        assertEquals(seasons, response.seasons);
    }

    @Test
    void testConstructorWithNullSeasons() {
        GetSeasonsResponse response = new GetSeasonsResponse();
        response.seasons = null;
        
        assertNotNull(response);
        assertNull(response.seasons);
    }

    @Test
    void testConstructorWithEmptySeasons() {
        Iterable<SeasonMetadata> emptySeasons = Collections.emptyList();
        
        GetSeasonsResponse response = new GetSeasonsResponse();
        response.seasons = emptySeasons;
        
        assertNotNull(response);
        assertEquals(emptySeasons, response.seasons);
    }

    @Test
    void testConstructorWithSingleSeason() {
        SeasonMetadata season = new SeasonMetadata(100, "Single Season");
        Iterable<SeasonMetadata> seasons = Arrays.asList(season);
        
        GetSeasonsResponse response = new GetSeasonsResponse();
        response.seasons = seasons;
        
        assertNotNull(response);
        assertEquals(seasons, response.seasons);
        assertEquals(1, ((java.util.List<SeasonMetadata>) response.seasons).size());
    }

    @Test
    void testSeasonsFieldAssignment() {
        SeasonMetadata season1 = new SeasonMetadata(1, "Season A");
        SeasonMetadata season2 = new SeasonMetadata(1, "Season A");
        
        GetSeasonsResponse response1 = new GetSeasonsResponse();
        response1.seasons = Arrays.asList(season1);
        
        GetSeasonsResponse response2 = new GetSeasonsResponse();
        response2.seasons = Arrays.asList(season2);
        
        assertNotNull(response1.seasons);
        assertNotNull(response2.seasons);
    }

    @Test
    void testSeasonsFieldInequality() {
        SeasonMetadata season1 = new SeasonMetadata(1, "Season 1");
        SeasonMetadata season2 = new SeasonMetadata(2, "Season 2");
        
        GetSeasonsResponse response1 = new GetSeasonsResponse();
        response1.seasons = Arrays.asList(season1);
        
        GetSeasonsResponse response2 = new GetSeasonsResponse();
        response2.seasons = Arrays.asList(season2);
        
        assertNotEquals(response1.seasons, response2.seasons);
    }

    @Test
    void testToString() {
        SeasonMetadata season = new SeasonMetadata(1, "Test Season");
        GetSeasonsResponse response = new GetSeasonsResponse();
        response.seasons = Arrays.asList(season);
        
        String toString = response.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetSeasonsResponse"));
    }

    @Test
    void testNullSeasonsEquality() {
        GetSeasonsResponse response1 = new GetSeasonsResponse();
        response1.seasons = null;
        
        GetSeasonsResponse response2 = new GetSeasonsResponse();
        response2.seasons = null;
        
        assertEquals(response1.seasons, response2.seasons);
    }

    @Test
    void testMixedNullSeasonsInequality() {
        SeasonMetadata season = new SeasonMetadata(1, "Season");
        
        GetSeasonsResponse response1 = new GetSeasonsResponse();
        response1.seasons = Arrays.asList(season);
        
        GetSeasonsResponse response2 = new GetSeasonsResponse();
        response2.seasons = null;
        
        assertNotEquals(response1.seasons, response2.seasons);
    }
}


