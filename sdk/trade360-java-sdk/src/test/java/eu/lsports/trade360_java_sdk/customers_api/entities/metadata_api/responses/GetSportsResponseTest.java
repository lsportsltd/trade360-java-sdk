package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetSportsResponseTest {
    @Test
    void testConstructorAndFields() {
        SportMetadata sm = new SportMetadata(1, "Sport");
        List<SportMetadata> sports = List.of(sm);
        GetSportsResponse resp = new GetSportsResponse(sports);
        assertEquals(sports, resp.sports());
    }
} 