package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeagueMetadataTest {
    @Test
    void testConstructorAndFields() {
        int id = 1;
        String name = "League";
        String season = "2023";
        int sportId = 2;
        int locationId = 3;
        LeagueMetadata lm = new LeagueMetadata(id, name, season, sportId, locationId);
        assertEquals(id, lm.id());
        assertEquals(name, lm.name());
        assertEquals(season, lm.season());
        assertEquals(sportId, lm.sportId());
        assertEquals(locationId, lm.locationId());
    }
} 