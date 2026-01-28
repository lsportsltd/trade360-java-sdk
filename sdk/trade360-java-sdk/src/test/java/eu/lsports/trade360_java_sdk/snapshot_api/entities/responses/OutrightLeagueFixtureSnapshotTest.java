package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

class OutrightLeagueFixtureSnapshotTest {
    @Test
    void testConstructorAndFields() {
        OutrightLeagueFixtureSnapshot element = new OutrightLeagueFixtureSnapshot();
        element.subscription = null;
        element.sport = null;
        element.location = null;
        element.lastUpdate = Instant.now();
        element.status = null;
        element.extraData = Collections.emptyList();
        element.endDate = Instant.now().plus(1, ChronoUnit.DAYS);
        assertNull(element.subscription);
        assertNull(element.sport);
        assertNull(element.location);
        assertNotNull(element.lastUpdate);
        assertNull(element.status);
        assertNotNull(element.extraData);
        assertNotNull(element.endDate);
    }

    @Test
    void testFixtureNameAndSeasonFields() {
        OutrightLeagueFixtureSnapshot element = new OutrightLeagueFixtureSnapshot();

        assertNull(element.fixtureName);
        assertNull(element.season);

        element.fixtureName = "Test League Fixture Name";
        element.season = new IdNamePair(2024, "Season 2024");

        assertEquals("Test League Fixture Name", element.fixtureName);
        assertNotNull(element.season);
        assertEquals(2024, element.season.id());
        assertEquals("Season 2024", element.season.name());
    }

    @Test
    void testFixtureNameAndSeasonNullability() {
        OutrightLeagueFixtureSnapshot element = new OutrightLeagueFixtureSnapshot();

        element.fixtureName = null;
        element.season = null;

        assertNull(element.fixtureName);
        assertNull(element.season);
    }
} 