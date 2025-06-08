package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureEventTest {
    @Test
    void testInstantiation() {
        OutrightFixtureEvent event = new OutrightFixtureEvent();
        assertNotNull(event);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightFixtureEvent event = new OutrightFixtureEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.outrightFixture);

        event.fixtureId = 42;
        OutrightFixture fixture = new OutrightFixture();
        event.outrightFixture = fixture;
        assertEquals(42, event.fixtureId);
        assertSame(fixture, event.outrightFixture);
    }
} 