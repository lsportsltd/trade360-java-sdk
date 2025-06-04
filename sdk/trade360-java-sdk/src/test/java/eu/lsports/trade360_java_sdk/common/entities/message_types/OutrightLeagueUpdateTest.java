package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueFixtureEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueUpdateTest {
    @Test
    void testFieldAssignment() {
        OutrightLeagueUpdate update = new OutrightLeagueUpdate();
        assertNotNull(update);
    }
} 