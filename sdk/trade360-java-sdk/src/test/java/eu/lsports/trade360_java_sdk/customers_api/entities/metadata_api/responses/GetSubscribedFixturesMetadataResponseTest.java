package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetSubscribedFixturesMetadataResponseTest {
    @Test
    void testConstructorAndFields() {
        FixtureMetadata fm = new FixtureMetadata(1, "Fixture", null, null, 2, 3, 4, null, null);
        List<FixtureMetadata> fixtures = List.of(fm);
        GetSubscribedFixturesMetadataResponse resp = new GetSubscribedFixturesMetadataResponse(fixtures);
        assertEquals(fixtures, resp.subscribedFixtures());
    }
} 