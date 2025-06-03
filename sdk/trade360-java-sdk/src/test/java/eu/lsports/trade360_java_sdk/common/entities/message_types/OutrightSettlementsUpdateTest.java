package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightSettlementsUpdateTest {
    @Test
    void testFieldAssignment() {
        OutrightSettlementsUpdate update = new OutrightSettlementsUpdate();
        OutrightCompetition<MarketEvent> comp = new OutrightCompetition<>();
        update.competition = comp;
        assertEquals(42, OutrightSettlementsUpdate.entityKey);
        assertEquals(comp, update.competition);
    }
} 