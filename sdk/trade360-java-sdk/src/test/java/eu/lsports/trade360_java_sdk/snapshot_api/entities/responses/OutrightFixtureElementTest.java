package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;
import java.util.Collections;

class OutrightFixtureElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightFixtureElement element = new OutrightFixtureElement();
        element.sport = null;
        element.location = null;
        element.startDate = Instant.now();
        element.lastUpdate = Instant.now();
        element.status = null;
        element.participants = Collections.emptyList();
        element.subscription = null;
        element.venue = null;
        assertNull(element.sport);
        assertNull(element.location);
        assertNotNull(element.startDate);
        assertNotNull(element.lastUpdate);
        assertNull(element.status);
        assertNotNull(element.participants);
        assertNull(element.subscription);
        assertNull(element.venue);
    }

    @Test
    void testFixtureNameAndSeasonFields() {
        OutrightFixtureElement element = new OutrightFixtureElement();

        assertNull(element.fixtureName);
        assertNull(element.season);

        element.fixtureName = "Test Fixture Name";
        element.season = new IdNamePair(2024, "Season 2024");

        assertEquals("Test Fixture Name", element.fixtureName);
        assertNotNull(element.season);
        assertEquals(2024, element.season.id());
        assertEquals("Season 2024", element.season.name());
    }

    @Test
    void testFixtureNameAndSeasonNullability() {
        OutrightFixtureElement element = new OutrightFixtureElement();

        element.fixtureName = null;
        element.season = null;

        assertNull(element.fixtureName);
        assertNull(element.season);
    }
} 