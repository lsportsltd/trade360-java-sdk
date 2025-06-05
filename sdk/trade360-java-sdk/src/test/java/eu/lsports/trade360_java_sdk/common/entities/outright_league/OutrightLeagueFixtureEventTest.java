package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueFixtureEventTest {
    @Test
    void testFieldAssignment() {
        OutrightLeagueFixtureEvent event = new OutrightLeagueFixtureEvent();
        event.fixtureId = 42;
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        event.outrightLeague = fixture;
        assertEquals(42, event.fixtureId);
        assertEquals(fixture, event.outrightLeague);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueFixtureEvent event = new OutrightLeagueFixtureEvent();
        assertNotNull(event);
    }
} 