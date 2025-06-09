package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Collections;

class OutrightFixtureElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightFixtureElement element = new OutrightFixtureElement();
        element.sport = null;
        element.location = null;
        element.startDate = LocalDateTime.now();
        element.lastUpdate = LocalDateTime.now();
        element.status = null;
        element.participants = Collections.emptyList();
        element.subscription = null;
        assertNull(element.sport);
        assertNull(element.location);
        assertNotNull(element.startDate);
        assertNotNull(element.lastUpdate);
        assertNull(element.status);
        assertNotNull(element.participants);
        assertNull(element.subscription);
    }
} 