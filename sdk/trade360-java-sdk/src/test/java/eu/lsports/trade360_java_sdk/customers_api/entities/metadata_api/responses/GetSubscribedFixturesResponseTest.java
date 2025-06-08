package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetSubscribedFixturesResponseTest {
    @Test
    void testConstructorAndFields() {
        List<Integer> fixtures = List.of(1, 2, 3);
        GetSubscribedFixturesResponse resp = new GetSubscribedFixturesResponse(fixtures);
        assertEquals(fixtures, resp.fixtures());
    }
} 