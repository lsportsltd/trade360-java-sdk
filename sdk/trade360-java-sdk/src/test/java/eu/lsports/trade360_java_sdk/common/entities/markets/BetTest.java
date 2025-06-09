package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BetTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Bet bet = new Bet();
        assertNull(bet.providerBetId);
        bet.providerBetId = "bet123";
        assertEquals("bet123", bet.providerBetId);
    }
} 