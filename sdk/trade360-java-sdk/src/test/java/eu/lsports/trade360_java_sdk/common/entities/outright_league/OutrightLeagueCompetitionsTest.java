package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueCompetitionsTest {
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueCompetitions<String> competitions = new OutrightLeagueCompetitions<>();
        assertEquals(0, competitions.id);
        assertNull(competitions.name);
        assertEquals(0, competitions.type);
        assertNull(competitions.events);

        competitions.id = 7;
        competitions.name = "CompetitionName";
        competitions.type = 2;
        competitions.events = Arrays.asList("event1", "event2");

        assertEquals(7, competitions.id);
        assertEquals("CompetitionName", competitions.name);
        assertEquals(2, competitions.type);
        assertNotNull(competitions.events);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueCompetitions competitions = new OutrightLeagueCompetitions();
        assertNotNull(competitions);
    }
} 