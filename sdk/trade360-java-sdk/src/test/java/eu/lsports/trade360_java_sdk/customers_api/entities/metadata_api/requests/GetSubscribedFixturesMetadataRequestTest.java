package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetSubscribedFixturesMetadataRequestTest {
    @Test
    void testConstructorAndFields() {
        LocalDate fromDate = LocalDate.of(2024, 1, 1);
        LocalDate toDate = LocalDate.of(2024, 1, 31);
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        Integer languageId = 5;
        GetSubscribedFixturesMetadataRequest req = new GetSubscribedFixturesMetadataRequest(fromDate, toDate, sportIds, locationIds, languageId);
        assertEquals(fromDate, req.fromDate());
        assertEquals(toDate, req.toDate());
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(languageId, req.languageId());
    }
} 