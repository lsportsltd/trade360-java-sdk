package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreTest {
    @Test
    void testFieldAssignment() {
        Livescore livescore = new Livescore();
        Scoreboard scoreboard = new Scoreboard();
        Period period = new Period();
        Statistic statistic = new Statistic();
        PlayerStatistic playerStatistic = new PlayerStatistic();
        NameValuePair extra = new NameValuePair();
        CurrentIncident currentIncident = new CurrentIncident();
        DangerIndicator danger = new DangerIndicator();
        livescore.scoreboard = scoreboard;
        livescore.periods = List.of(period);
        livescore.statistics = List.of(statistic);
        livescore.playerStatistics = List.of(playerStatistic);
        livescore.livescoreExtraData = List.of(extra);
        livescore.currentIncident = currentIncident;
        livescore.dangerTriggers = List.of(danger);
        assertNotNull(livescore.scoreboard);
        assertNotNull(livescore.periods);
        assertNotNull(livescore.statistics);
        assertNotNull(livescore.playerStatistics);
        assertNotNull(livescore.livescoreExtraData);
        assertNotNull(livescore.currentIncident);
        assertNotNull(livescore.dangerTriggers);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Livescore livescore = new Livescore();
        assertNull(livescore.scoreboard);
        assertNull(livescore.periods);
        assertNull(livescore.statistics);
        assertNull(livescore.playerStatistics);
        assertNull(livescore.livescoreExtraData);
        assertNull(livescore.currentIncident);
        assertNull(livescore.dangerTriggers);
    }
} 