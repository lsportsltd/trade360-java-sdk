package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixtureEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        FixtureEvent event = new FixtureEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.fixture);

        event.fixtureId = 42;
        Fixture fixture = new Fixture();
        event.fixture = fixture;

        assertEquals(42, event.fixtureId);
        assertSame(fixture, event.fixture);
    }
} 