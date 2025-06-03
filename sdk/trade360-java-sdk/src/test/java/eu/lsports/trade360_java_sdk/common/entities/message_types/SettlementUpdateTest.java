package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SettlementUpdateTest {
    @Test
    void testFieldAssignment() {
        SettlementUpdate update = new SettlementUpdate();
        MarketEvent event = new MarketEvent();
        update.events = List.of(event);
        assertEquals(35, SettlementUpdate.entityKey);
        assertNotNull(update.events);
    }
} 