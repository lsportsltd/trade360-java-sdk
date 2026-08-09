package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueMarketEventTest {

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueMarketEvent event = new OutrightLeagueMarketEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.fixtureName);
        assertNull(event.markets);

        event.fixtureId = 42;
        event.fixtureName = "Premier League 2023/2024 Outright Winner";
        assertEquals(42, event.fixtureId);
        assertEquals("Premier League 2023/2024 Outright Winner", event.fixtureName);
    }

    @Test
    void testFixtureNameOmittedWhenNullOrEmpty() throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);

        OutrightLeagueMarketEvent withNull = new OutrightLeagueMarketEvent();
        withNull.fixtureId = 1;
        withNull.fixtureName = null;
        assertFalse(mapper.writeValueAsString(withNull).contains("FixtureName"));

        OutrightLeagueMarketEvent withEmpty = new OutrightLeagueMarketEvent();
        withEmpty.fixtureId = 1;
        withEmpty.fixtureName = "";
        assertFalse(mapper.writeValueAsString(withEmpty).contains("FixtureName"));

        OutrightLeagueMarketEvent withValue = new OutrightLeagueMarketEvent();
        withValue.fixtureId = 1;
        withValue.fixtureName = "Premier League 2023/2024 Outright Winner";
        assertTrue(mapper.writeValueAsString(withValue)
                .contains("\"FixtureName\":\"Premier League 2023/2024 Outright Winner\""));
    }

    @Test
    void testSharedMarketEventDoesNotExposeFixtureName() throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);

        eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent shared =
                new eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent();
        shared.fixtureId = 1;

        String json = mapper.writeValueAsString(shared);
        assertFalse(json.contains("FixtureName"));
        assertFalse(json.contains("fixtureName"));
    }
}
