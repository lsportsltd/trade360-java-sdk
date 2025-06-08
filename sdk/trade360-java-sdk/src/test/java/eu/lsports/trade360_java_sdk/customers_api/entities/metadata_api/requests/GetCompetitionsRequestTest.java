package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import static org.junit.jupiter.api.Assertions.*;

class GetCompetitionsRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        List<Integer> competitionIds = List.of(5, 6);
        SubscriptionState status = SubscriptionState.SUBSCRIBED;
        GetCompetitionsRequest req = new GetCompetitionsRequest(sportIds, locationIds, competitionIds, status);
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(competitionIds, req.competitionIds());
        assertEquals(status, req.subscriptionStatus());
    }
} 