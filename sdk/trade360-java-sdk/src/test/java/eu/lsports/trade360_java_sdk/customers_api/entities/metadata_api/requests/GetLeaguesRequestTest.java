package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import static org.junit.jupiter.api.Assertions.*;

class GetLeaguesRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        SubscriptionState status = SubscriptionState.SUBSCRIBED;
        Integer languageId = 5;
        GetLeaguesRequest req = new GetLeaguesRequest(sportIds, locationIds, status, languageId);
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(status, req.subscriptionStatus());
        assertEquals(languageId, req.languageId());
    }
} 