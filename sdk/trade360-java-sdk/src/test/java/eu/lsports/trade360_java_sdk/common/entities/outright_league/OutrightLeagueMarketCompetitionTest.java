package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueMarketCompetitionTest {
    @Test
    void testNextFixtureStartTimeAssignment() {
        OutrightLeagueMarketCompetition competition = new OutrightLeagueMarketCompetition();
        assertNull(competition.nextFixtureStartTime);

        competition.id = 67;
        competition.name = "League_67";
        competition.type = 3;
        competition.nextFixtureStartTime = Instant.parse("2026-05-29T14:44:55Z");

        assertEquals(67, competition.id);
        assertEquals("League_67", competition.name);
        assertEquals(3, competition.type);
        assertEquals(Instant.parse("2026-05-29T14:44:55Z"), competition.nextFixtureStartTime);
    }
}
