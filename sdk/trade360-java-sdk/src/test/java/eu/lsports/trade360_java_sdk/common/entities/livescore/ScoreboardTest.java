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
        Result result = new Result();
        scoreboard.results = List.of(result);
        assertEquals(FixtureStatus.FINISHED, scoreboard.status);
        assertEquals(StatusDescription.NONE, scoreboard.description);
        assertEquals(2, scoreboard.currentPeriod);
        assertEquals("90:00", scoreboard.time);
        assertNotNull(scoreboard.results);
    }
} 