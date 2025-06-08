package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetLocationsResponseTest {
    @Test
    void testConstructorAndFields() {
        LocationMetadata lm = new LocationMetadata(1, "Location");
        List<LocationMetadata> locations = List.of(lm);
        GetLocationsResponse resp = new GetLocationsResponse(locations);
        assertEquals(locations, resp.locations());
    }
} 