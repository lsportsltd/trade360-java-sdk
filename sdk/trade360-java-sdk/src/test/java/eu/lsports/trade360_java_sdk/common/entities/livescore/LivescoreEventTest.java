package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreEventTest {
    @Test
    void testFieldAssignment() {
        LivescoreEvent event = new LivescoreEvent();
        event.fixtureId = 123;
        Fixture fixture = new Fixture();
        Livescore livescore = new Livescore();
        event.fixture = fixture;
        event.livescore = livescore;
        assertEquals(123, event.fixtureId);
        assertNotNull(event.fixture);
        assertNotNull(event.livescore);
    }
} 