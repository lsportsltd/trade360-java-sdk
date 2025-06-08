package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueTest {
    @Test
    void testInstantiation() {
        OutrightLeague league = new OutrightLeague();
        assertNotNull(league);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeague league = new OutrightLeague();
        assertNull(league.subscription);
        Subscription sub = new Subscription();
        league.subscription = sub;
        assertSame(sub, league.subscription);
    }
} 