package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureEventElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightFixtureEventElement element = new OutrightFixtureEventElement();
        element.fixtureId = 1;
        element.outrightFixture = null;
        assertEquals(1, element.fixtureId);
        assertNull(element.outrightFixture);
    }
} 