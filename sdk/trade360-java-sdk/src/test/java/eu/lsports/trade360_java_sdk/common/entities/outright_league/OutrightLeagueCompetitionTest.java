package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueCompetitionTest {
    @Test
    void testInstantiation() {
        OutrightLeagueCompetition competition = new OutrightLeagueCompetition();
        assertNotNull(competition);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueCompetition<String> competition = new OutrightLeagueCompetition<>();
        assertEquals(0, competition.id);
        assertNull(competition.name);
        assertEquals(0, competition.type);
        assertNull(competition.nextFixtureStartTime);
        assertNull(competition.competitions);

        competition.id = 7;
        competition.name = "CompetitionName";
        competition.type = 2;
        competition.nextFixtureStartTime = java.time.Instant.parse("2026-05-29T14:44:55Z");
        competition.competitions = Arrays.asList(new OutrightLeagueCompetitions<>());

        assertEquals(7, competition.id);
        assertEquals("CompetitionName", competition.name);
        assertEquals(2, competition.type);
        assertEquals(java.time.Instant.parse("2026-05-29T14:44:55Z"), competition.nextFixtureStartTime);
        assertNotNull(competition.competitions);
    }
} 