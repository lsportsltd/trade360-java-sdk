package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreFieldsTest {

    @Test
    void testScoreboardFieldAssignment() {
        Livescore livescore = new Livescore();
        Scoreboard scoreboard = new Scoreboard();
        
        livescore.scoreboard = scoreboard;
        assertEquals(scoreboard, livescore.scoreboard);
        
        livescore.scoreboard = null;
        assertNull(livescore.scoreboard);
    }

    @Test
    void testPeriodsFieldAssignment() {
        Livescore livescore = new Livescore();
        
        livescore.periods = null;
        assertNull(livescore.periods);
    }

    @Test
    void testStatisticsFieldAssignment() {
        Livescore livescore = new Livescore();
        
        livescore.statistics = null;
        assertNull(livescore.statistics);
    }

    @Test
    void testLivescoreExtraDataFieldAssignment() {
        Livescore livescore = new Livescore();
        
        livescore.livescoreExtraData = null;
        assertNull(livescore.livescoreExtraData);
    }

    @Test
    void testCurrentIncidentFieldAssignment() {
        Livescore livescore = new Livescore();
        CurrentIncident incident = new CurrentIncident();
        
        livescore.currentIncident = incident;
        assertEquals(incident, livescore.currentIncident);
        
        livescore.currentIncident = null;
        assertNull(livescore.currentIncident);
    }

    @Test
    void testDangerTriggersFieldAssignment() {
        Livescore livescore = new Livescore();
        
        livescore.dangerTriggers = null;
        assertNull(livescore.dangerTriggers);
    }

    @Test
    void testInstantiation() {
        Livescore livescore = new Livescore();
        assertNotNull(livescore);
    }
}
