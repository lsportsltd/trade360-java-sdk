package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetTranslationsRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> languages = List.of(1, 2);
        List<Integer> sportIds = List.of(3, 4);
        List<Integer> locationIds = List.of(5, 6);
        List<Integer> leagueIds = List.of(7, 8);
        List<Integer> marketIds = List.of(9, 10);
        List<Integer> participantIds = List.of(11, 12);
        GetTranslationsRequest req = new GetTranslationsRequest(languages, sportIds, locationIds, leagueIds, marketIds, participantIds);
        assertEquals(languages, req.languages());
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(leagueIds, req.leagueIds());
        assertEquals(marketIds, req.marketIds());
        assertEquals(participantIds, req.participantIds());
    }
} 