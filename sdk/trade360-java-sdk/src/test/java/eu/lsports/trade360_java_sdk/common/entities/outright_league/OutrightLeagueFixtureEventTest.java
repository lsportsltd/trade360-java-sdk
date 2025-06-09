package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueFixtureEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueFixtureEvent event = new OutrightLeagueFixtureEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.outrightLeague);

        event.fixtureId = 42;
        OutrightLeagueFixture league = new OutrightLeagueFixture();
        event.outrightLeague = league;
        assertEquals(42, event.fixtureId);
        assertSame(league, event.outrightLeague);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueFixtureEvent event = new OutrightLeagueFixtureEvent();
        assertNotNull(event);
    }
} 