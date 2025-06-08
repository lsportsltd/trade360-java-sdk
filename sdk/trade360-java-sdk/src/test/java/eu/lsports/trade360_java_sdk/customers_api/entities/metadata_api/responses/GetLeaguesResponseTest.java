package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetLeaguesResponseTest {
    @Test
    void testConstructorAndFields() {
        LeagueMetadata lm = new LeagueMetadata(1, "League", "2023", 2, 3);
        List<LeagueMetadata> leagues = List.of(lm);
        GetLeaguesResponse resp = new GetLeaguesResponse(leagues);
        assertEquals(leagues, resp.leagues());
    }
} 