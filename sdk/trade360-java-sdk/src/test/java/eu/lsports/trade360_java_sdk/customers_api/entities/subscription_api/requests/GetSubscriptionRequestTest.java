package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetSubscriptionRequestTest {

    @Test
    void testRecordConstruction() {
        List<Integer> sportIds = List.of(1, 2, 3);
        List<Integer> locationIds = List.of(4, 5, 6);
        List<Integer> leagueIds = List.of(7, 8, 9);
        
        GetSubscriptionRequest request = new GetSubscriptionRequest(sportIds, locationIds, leagueIds);
        
        assertEquals(sportIds, request.sportIds());
        assertEquals(locationIds, request.locationIds());
        assertEquals(leagueIds, request.leagueIds());
    }

    @Test
    void testNullParameters() {
        GetSubscriptionRequest request = new GetSubscriptionRequest(null, null, null);
        
        assertNull(request.sportIds());
        assertNull(request.locationIds());
        assertNull(request.leagueIds());
    }

    @Test
    void testEmptyLists() {
        List<Integer> emptyList = List.of();
        GetSubscriptionRequest request = new GetSubscriptionRequest(emptyList, emptyList, emptyList);
        
        assertEquals(emptyList, request.sportIds());
        assertEquals(emptyList, request.locationIds());
        assertEquals(emptyList, request.leagueIds());
        assertTrue(((List<Integer>) request.sportIds()).isEmpty());
    }

    @Test
    void testRecordEquality() {
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        List<Integer> leagueIds = List.of(5, 6);
        
        GetSubscriptionRequest request1 = new GetSubscriptionRequest(sportIds, locationIds, leagueIds);
        GetSubscriptionRequest request2 = new GetSubscriptionRequest(sportIds, locationIds, leagueIds);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }
}
