package eu.lsports.trade360_java_sdk.common.entities.markets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        MarketEvent event = new MarketEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.fixtureName);
        assertNull(event.markets);

        event.fixtureId = 42;
        event.fixtureName = "Premier League 2023/2024 Outright Winner";
        event.markets = null;
        assertEquals(42, event.fixtureId);
        assertEquals("Premier League 2023/2024 Outright Winner", event.fixtureName);
        assertNull(event.markets);
    }

    @Test
    void testFixtureNameOmittedWhenNullOrEmpty() throws Exception {
        ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);

        MarketEvent withNull = new MarketEvent();
        withNull.fixtureId = 1;
        withNull.fixtureName = null;
        String nullJson = mapper.writeValueAsString(withNull);
        assertFalse(nullJson.contains("FixtureName"));

        MarketEvent withEmpty = new MarketEvent();
        withEmpty.fixtureId = 1;
        withEmpty.fixtureName = "";
        String emptyJson = mapper.writeValueAsString(withEmpty);
        assertFalse(emptyJson.contains("FixtureName"));

        MarketEvent withValue = new MarketEvent();
        withValue.fixtureId = 1;
        withValue.fixtureName = "Premier League 2023/2024 Outright Winner";
        String valueJson = mapper.writeValueAsString(withValue);
        assertTrue(valueJson.contains("\"FixtureName\":\"Premier League 2023/2024 Outright Winner\""));
    }
} 