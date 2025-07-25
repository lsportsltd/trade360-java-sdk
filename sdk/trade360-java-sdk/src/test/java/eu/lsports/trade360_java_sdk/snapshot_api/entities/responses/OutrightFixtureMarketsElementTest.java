package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightFixtureMarketsElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightFixtureMarketsElement element = new OutrightFixtureMarketsElement();
        element.fixtureId = 1;
        element.markets = Collections.emptyList();
        assertEquals(1, element.fixtureId);
        assertNotNull(element.markets);
    }
} 