package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.StatusDescription;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    @Test
    void testFieldAssignment() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.status = FixtureStatus.FINISHED;
        scoreboard.description = StatusDescription.NONE;
        scoreboard.currentPeriod = 2;
        scoreboard.time = "90:00";
        Clock clock = new Clock();
        scoreboard.clock = clock;
        Result result = new Result();
        scoreboard.results = List.of(result);
        assertEquals(FixtureStatus.FINISHED, scoreboard.status);
        assertEquals(StatusDescription.NONE, scoreboard.description);
        assertEquals(2, scoreboard.currentPeriod);
        assertEquals("90:00", scoreboard.time);
        assertNotNull(scoreboard.clock);
        assertEquals(clock, scoreboard.clock);
        assertNotNull(scoreboard.results);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Scoreboard scoreboard = new Scoreboard();
        assertNull(scoreboard.status);
        assertNull(scoreboard.description);
        assertEquals(0, scoreboard.currentPeriod);
        assertNull(scoreboard.time);
        assertNull(scoreboard.results);
        assertNull(scoreboard.clock);
    }
} 