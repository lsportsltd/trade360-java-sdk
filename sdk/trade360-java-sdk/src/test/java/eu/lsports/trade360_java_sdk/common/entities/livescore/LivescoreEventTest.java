package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        LivescoreEvent event = new LivescoreEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.fixture);
        assertNull(event.livescore);

        event.fixtureId = 77;
        Fixture fixture = new Fixture();
        Livescore livescore = new Livescore();
        event.fixture = fixture;
        event.livescore = livescore;

        assertEquals(77, event.fixtureId);
        assertSame(fixture, event.fixture);
        assertSame(livescore, event.livescore);
    }
} 