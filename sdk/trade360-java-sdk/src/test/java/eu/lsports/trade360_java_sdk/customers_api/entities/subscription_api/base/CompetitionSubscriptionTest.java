package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionSubscriptionTest {
    @Test
    void testConstructorAndFields() {
        int sportId = 1;
        int locationId = 2;
        int competitionId = 3;
        CompetitionSubscription cs = new CompetitionSubscription(sportId, locationId, competitionId);
        assertEquals(sportId, cs.sportId());
        assertEquals(locationId, cs.locationId());
        assertEquals(competitionId, cs.competitionId());
    }
} 