package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Collections;

class OutrightLeagueFixtureSnapshotTest {
    @Test
    void testConstructorAndFields() {
        OutrightLeagueFixtureSnapshot element = new OutrightLeagueFixtureSnapshot();
        element.subscription = null;
        element.sport = null;
        element.location = null;
        element.lastUpdate = LocalDateTime.now();
        element.status = null;
        element.extraData = Collections.emptyList();
        element.endDate = LocalDateTime.now().plusDays(1);
        assertNull(element.subscription);
        assertNull(element.sport);
        assertNull(element.location);
        assertNotNull(element.lastUpdate);
        assertNull(element.status);
        assertNotNull(element.extraData);
        assertNotNull(element.endDate);
    }
} 