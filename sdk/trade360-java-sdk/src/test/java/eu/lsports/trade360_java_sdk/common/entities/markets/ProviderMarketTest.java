package eu.lsports.trade360_java_sdk.common.entities.markets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderMarketTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
    }

    @Test
    void testFieldAssignment() {
        ProviderMarket pm = new ProviderMarket();
        assertNotNull(pm);
    }

    @Test
    void testDeserializeMarketStatusFromJson() throws Exception {
        ProviderMarket parsed = objectMapper.readValue(
                "{\"Id\":57,\"Name\":\"Bet365\",\"MarketStatus\":2,\"Bets\":[]}",
                ProviderMarket.class);

        assertEquals(57, parsed.id);
        assertEquals("Bet365", parsed.name);
        assertEquals(MarketStatus.SUSPENDED, parsed.marketStatus);
    }
}
