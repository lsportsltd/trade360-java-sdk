package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetMarketsResponseTest {
    @Test
    void testConstructorAndFields() {
        MarketMetadata mm = new MarketMetadata(1, "Market", true);
        List<MarketMetadata> markets = List.of(mm);
        GetMarketsResponse resp = new GetMarketsResponse(markets);
        assertEquals(markets, resp.markets());
    }
} 