package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightEventElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightEventElement element = new OutrightEventElement();
        element.fixtureId = 1;
        element.outrightFixture = null;
        element.outrightScore = null;
        element.markets = Collections.emptyList();
        assertEquals(1, element.fixtureId);
        assertNull(element.outrightFixture);
        assertNull(element.outrightScore);
        assertNotNull(element.markets);
    }
} 