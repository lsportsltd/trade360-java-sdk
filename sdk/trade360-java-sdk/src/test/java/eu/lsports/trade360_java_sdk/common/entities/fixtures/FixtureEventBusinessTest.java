package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FixtureEventBusinessTest {
    @Test
    void testFullFieldAssignment() {
        FixtureEvent event = new FixtureEvent();
        event.fixtureId = 123;
        Fixture fixture = new Fixture();
        event.fixture = fixture;
        assertEquals(123, event.fixtureId);
        assertNotNull(event.fixture);
    }

    @Test
    void testNullFixture() {
        FixtureEvent event = new FixtureEvent();
        event.fixture = null;
        assertNull(event.fixture);
    }

    @Test
    void testDefaultFixtureId() {
        FixtureEvent event = new FixtureEvent();
        assertEquals(0, event.fixtureId);
    }
} 