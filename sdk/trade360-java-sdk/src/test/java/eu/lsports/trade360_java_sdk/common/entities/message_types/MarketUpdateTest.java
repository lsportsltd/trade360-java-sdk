package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketStatus;
import eu.lsports.trade360_java_sdk.common.entities.markets.Market;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.ProviderMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MarketUpdateTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void testFieldAssignment() {
        MarketUpdate update = new MarketUpdate();
        assertNotNull(update);
    }

    @Test
    void testDeserializeClosedMarketStatusOnMarketsAndProviderMarkets() throws Exception {
        MarketUpdate update = objectMapper.readValue(
                "{\"Events\":[{\"FixtureId\":20009162,\"Markets\":[{\"Id\":1,\"Name\":\"1X2\",\"Status\":4,\"ProviderMarkets\":[{\"Id\":13,\"Name\":\"BWin\",\"MarketStatus\":4}]}]}]}",
                MarketUpdate.class);

        assertNotNull(update.events);
        MarketEvent event = update.events.iterator().next();
        assertEquals(20009162, event.fixtureId);
        assertNotNull(event.markets);
        Market market = event.markets.iterator().next();
        assertEquals(MarketStatus.CLOSED, market.status);
        assertNotNull(market.providerMarkets);
        ProviderMarket providerMarket = market.providerMarkets.iterator().next();
        assertEquals(13, providerMarket.id);
        assertEquals("BWin", providerMarket.name);
        assertEquals(MarketStatus.CLOSED, providerMarket.marketStatus);
    }
}
