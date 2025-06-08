package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetIncidentsRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> ids = List.of(1, 2);
        List<Integer> sports = List.of(3, 4);
        String searchText = "incident";
        LocalDateTime from = LocalDateTime.now();
        GetIncidentsRequest.IncidentsFilter filter = new GetIncidentsRequest.IncidentsFilter(ids, sports, searchText, from);
        GetIncidentsRequest req = new GetIncidentsRequest(filter);
        assertEquals(filter, req.filter());
        assertEquals(ids, filter.ids());
        assertEquals(sports, filter.sports());
        assertEquals(searchText, filter.searchText());
        assertEquals(from, filter.from());
    }
} 