package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightScoreEventElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightScoreEventElement element = new OutrightScoreEventElement();
        element.fixtureId = 1;
        element.outrightScore = null;
        assertEquals(1, element.fixtureId);
        assertNull(element.outrightScore);
    }
} 