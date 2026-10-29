package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketStatus;
import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MarketLeagueTest {
    @Test
    void testFieldAssignmentAndNullability() {
        MarketLeague league = new MarketLeague();
        assertEquals(0, league.id);
        assertNull(league.name);
        assertNull(league.bets);
        assertNull(league.mainLine);

        league.id = 5;
        league.name = "LeagueName";
        league.bets = Arrays.asList(new Bet());
        league.mainLine = "MainLine";

        assertEquals(5, league.id);
        assertEquals("LeagueName", league.name);
        assertNotNull(league.bets);
        assertEquals("MainLine", league.mainLine);
        assertNull(league.status);

        league.status = MarketStatus.SUSPENDED;
        assertEquals(MarketStatus.SUSPENDED, league.status);
    }

    @Test
    void testDeserializeStatusFromJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MarketLeague parsed = objectMapper.readValue(
                "{\"Id\":590,\"Name\":\"To Be Relegated\",\"Status\":2,\"Bets\":[]}",
                MarketLeague.class);

        assertEquals(590, parsed.id);
        assertEquals("To Be Relegated", parsed.name);
        assertEquals(MarketStatus.SUSPENDED, parsed.status);
    }

    @Test
    void testDeserializeClosedStatusFromJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MarketLeague parsed = objectMapper.readValue(
                "{\"Id\":590,\"Name\":\"To Be Relegated\",\"Status\":4,\"Bets\":[]}",
                MarketLeague.class);

        assertEquals(MarketStatus.CLOSED, parsed.status);
    }

    @Test
    void testInstantiation() {
        MarketLeague league = new MarketLeague();
        assertNotNull(league);
    }
} 