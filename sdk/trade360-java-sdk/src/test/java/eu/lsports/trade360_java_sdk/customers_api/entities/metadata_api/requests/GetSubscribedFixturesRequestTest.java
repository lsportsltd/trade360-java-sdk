package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetSubscribedFixturesRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        List<Integer> leagueIds = List.of(5, 6);
        GetSubscribedFixturesRequest req = new GetSubscribedFixturesRequest(sportIds, locationIds, leagueIds);
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(leagueIds, req.leagueIds());
    }
} 