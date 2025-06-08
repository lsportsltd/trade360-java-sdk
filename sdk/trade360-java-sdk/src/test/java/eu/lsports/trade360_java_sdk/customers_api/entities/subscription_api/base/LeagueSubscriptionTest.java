package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeagueSubscriptionTest {
    @Test
    void testConstructorAndAccessors() {
        int sportId = 1;
        int locationId = 2;
        int leagueId = 3;
        LeagueSubscription ls = new LeagueSubscription(sportId, locationId, leagueId);
        assertEquals(sportId, ls.sportId());
        assertEquals(locationId, ls.locationId());
        assertEquals(leagueId, ls.leagueId());
    }
} 