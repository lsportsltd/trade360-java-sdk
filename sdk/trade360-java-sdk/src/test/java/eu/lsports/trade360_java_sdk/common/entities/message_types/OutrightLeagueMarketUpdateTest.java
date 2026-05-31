package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueMarketCompetition;
import eu.lsports.trade360_java_sdk.common.serialization.LSportsInstantDeserializer;
import eu.lsports.trade360_java_sdk.common.serialization.LSportsInstantSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueMarketUpdateTest {
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
    void testFieldAssignment() {
        OutrightLeagueMarketUpdate update = new OutrightLeagueMarketUpdate();
        assertNotNull(update);
    }

    @Test
    void testDeserializeFullProductionPayload() throws Exception {
        try (InputStream input = getClass().getResourceAsStream("/outright-league-market-update-type40.json")) {
            assertNotNull(input, "fixture resource missing");

            OutrightLeagueMarketUpdate update = objectMapper.readValue(input, OutrightLeagueMarketUpdate.class);

            assertNotNull(update.competition);
            OutrightLeagueMarketCompetition competition = update.competition;
            assertEquals(67, competition.id);
            assertEquals("League_67", competition.name);
            assertEquals(3, competition.type);
            assertEquals(Instant.parse("2026-05-29T14:44:55Z"), competition.nextFixtureStartTime);

            var season = ((java.util.List<?>) competition.competitions).get(0);
            var seasonClass = season.getClass();
            assertEquals(2029, seasonClass.getField("id").getInt(season));
            assertEquals("Season_2029", seasonClass.getField("name").get(season));

            var event = ((java.lang.Iterable<?>) seasonClass.getField("events").get(season)).iterator().next();
            var eventClass = event.getClass();
            assertEquals(26721036, eventClass.getField("fixtureId").getInt(event));

            var market = ((java.lang.Iterable<?>) eventClass.getField("markets").get(event)).iterator().next();
            var marketClass = market.getClass();
            assertEquals(274, marketClass.getField("id").getInt(market));
            assertEquals("Outright Winner", marketClass.getField("name").get(market));
        }
    }
}
