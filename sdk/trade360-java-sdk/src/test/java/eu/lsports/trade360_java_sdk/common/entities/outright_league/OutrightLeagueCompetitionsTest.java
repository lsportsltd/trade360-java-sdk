package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueCompetitionsTest {
    @Test
    void testFieldAssignment() {
        OutrightLeagueCompetitions<String> comp = new OutrightLeagueCompetitions<>();
        comp.id = 5;
        comp.name = "Champions";
        comp.type = 1;
        comp.events = List.of("event1", "event2");
        assertEquals(5, comp.id);
        assertEquals("Champions", comp.name);
        assertEquals(1, comp.type);
        assertNotNull(comp.events);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueCompetitions competitions = new OutrightLeagueCompetitions();
        assertNotNull(competitions);
    }
} 