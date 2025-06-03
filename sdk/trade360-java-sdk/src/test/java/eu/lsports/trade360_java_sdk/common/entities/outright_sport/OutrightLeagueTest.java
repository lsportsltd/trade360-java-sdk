package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueTest {
    @Test
    void testFieldAssignment() {
        OutrightLeague league = new OutrightLeague();
        Subscription sub = new Subscription();
        league.subscription = sub;
        assertEquals(sub, league.subscription);
    }
} 