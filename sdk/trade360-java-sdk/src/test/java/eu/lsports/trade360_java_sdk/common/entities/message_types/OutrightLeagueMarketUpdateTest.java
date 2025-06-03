package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueMarketUpdateTest {
    @Test
    void testFieldAssignment() {
        OutrightLeagueMarketUpdate update = new OutrightLeagueMarketUpdate();
        OutrightLeagueCompetition<MarketEvent> comp = new OutrightLeagueCompetition<>();
        update.competition = comp;
        assertEquals(40, OutrightLeagueMarketUpdate.entityKey);
        assertEquals(comp, update.competition);
    }
} 