package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import eu.lsports.trade360_java_sdk.common.serialization.LSportsInstantDeserializer;
import eu.lsports.trade360_java_sdk.common.serialization.LSportsInstantSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetOutrightLeagueMarketsResultElementTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule()
                        .addSerializer(new LSportsInstantSerializer())
                        .addDeserializer(Instant.class, new LSportsInstantDeserializer()));
    }

    @Test
    void testDeserializeSnapshotResponseUsesSnapshotEntities() throws Exception {
        try (InputStream input = getClass().getResourceAsStream("/get-outright-league-markets-snapshot.json")) {
            assertNotNull(input, "fixture resource missing");

            List<GetOutrightLeagueMarketsResultElement> response = objectMapper.readValue(
                    input,
                    new TypeReference<List<GetOutrightLeagueMarketsResultElement>>() {});

            assertEquals(1, response.size());

            GetOutrightLeagueMarketsResultElement resultElement = response.get(0);
            assertNotNull(resultElement.competition);

            OutrightLeagueMarketsCompetitionElement league =
                    ((List<OutrightLeagueMarketsCompetitionElement>) resultElement.competition).get(0);
            assertInstanceOf(OutrightLeagueMarketsCompetitionElement.class, league);
            assertEquals(67, league.id);
            assertEquals("League_67", league.name);
            assertEquals(3, league.type);
            assertEquals(Instant.parse("2026-05-29T14:44:55Z"), league.nextFixtureStartTime);

            OutrightLeagueMarketsCompetition season =
                    ((List<OutrightLeagueMarketsCompetition>) league.competitions).get(0);
            assertInstanceOf(OutrightLeagueMarketsCompetition.class, season);
            assertEquals(2029, season.id);
            assertEquals("Season_2029", season.name);

            OutrightFixtureMarketsElement event =
                    ((List<OutrightFixtureMarketsElement>) season.events).get(0);
            assertInstanceOf(OutrightFixtureMarketsElement.class, event);
            assertEquals(26721036, event.fixtureId);

            OutrightMarketElement market =
                    ((List<OutrightMarketElement>) event.markets).get(0);
            assertInstanceOf(OutrightMarketElement.class, market);
            assertEquals(274, market.id);
            assertEquals("Outright Winner", market.name);

            Bet bet = ((List<Bet>) market.bets).get(0);
            assertInstanceOf(Bet.class, bet);
            assertEquals("Not Simply Simon", bet.name);
        }
    }
}
