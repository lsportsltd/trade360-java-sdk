package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.StatusDescription;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardFieldTest {

    @Test
    void testScoreboardFieldAssignment() {
        Scoreboard scoreboard = new Scoreboard();
        
        FixtureStatus status = FixtureStatus.IN_PROGRESS;
        StatusDescription description = StatusDescription.HT;
        int currentPeriod = 1;
        String time = "45:00";
        Iterable<Result> results = Arrays.asList(new Result(), new Result());
        
        scoreboard.status = status;
        scoreboard.description = description;
        scoreboard.currentPeriod = currentPeriod;
        scoreboard.time = time;
        scoreboard.results = results;
        
        assertEquals(status, scoreboard.status);
        assertEquals(description, scoreboard.description);
        assertEquals(currentPeriod, scoreboard.currentPeriod);
        assertEquals(time, scoreboard.time);
        assertEquals(results, scoreboard.results);
    }

    @Test
    void testScoreboardWithNullValues() {
        Scoreboard scoreboard = new Scoreboard();
        
        scoreboard.status = null;
        scoreboard.description = null;
        scoreboard.time = null;
        scoreboard.results = null;
        
        assertNull(scoreboard.status);
        assertNull(scoreboard.description);
        assertNull(scoreboard.time);
        assertNull(scoreboard.results);
    }

    @Test
    void testScoreboardDefaultConstructor() {
        Scoreboard scoreboard = new Scoreboard();
        
        assertNotNull(scoreboard);
        assertNull(scoreboard.status);
        assertNull(scoreboard.description);
        assertEquals(0, scoreboard.currentPeriod);
        assertNull(scoreboard.time);
        assertNull(scoreboard.results);
    }
}
