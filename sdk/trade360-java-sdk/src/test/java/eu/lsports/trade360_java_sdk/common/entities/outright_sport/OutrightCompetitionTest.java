package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightCompetitionTest {
    @Test
    void testInstantiation() {
        OutrightCompetition competition = new OutrightCompetition();
        assertNotNull(competition);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightCompetition<String> competition = new OutrightCompetition<>();
        assertEquals(0, competition.id);
        assertNull(competition.name);
        assertEquals(0, competition.type);
        assertNull(competition.events);

        competition.id = 7;
        competition.name = "CompetitionName";
        competition.type = 2;
        competition.events = Arrays.asList("event1", "event2");

        assertEquals(7, competition.id);
        assertEquals("CompetitionName", competition.name);
        assertEquals(2, competition.type);
        assertNotNull(competition.events);
    }
} 