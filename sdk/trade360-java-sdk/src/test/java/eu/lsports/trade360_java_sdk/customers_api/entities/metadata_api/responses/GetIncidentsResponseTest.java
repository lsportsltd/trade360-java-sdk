package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.common.entities.incidents.Incident;
import static org.junit.jupiter.api.Assertions.*;

class GetIncidentsResponseTest {
    @Test
    void testConstructorAndFields() {
        Incident incident = new Incident();
        List<Incident> data = List.of(incident);
        GetIncidentsResponse resp = new GetIncidentsResponse(data);
        assertEquals(data, resp.data());
    }
} 