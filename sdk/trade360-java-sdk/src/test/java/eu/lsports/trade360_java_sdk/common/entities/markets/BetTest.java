package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BetTest {
    @Test
    void testFieldAssignment() {
        Bet bet = new Bet();
        bet.providerBetId = "bet123";
        assertEquals("bet123", bet.providerBetId);
    }
} 