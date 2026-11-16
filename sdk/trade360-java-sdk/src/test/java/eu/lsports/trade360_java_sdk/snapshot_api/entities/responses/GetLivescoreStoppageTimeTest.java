package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GetLivescoreStoppageTimeTest {

    private final ObjectMapper mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    void getLivescoreAndGetEventsKeepStoppageTimeSeconds() throws Exception {
        String withStoppage = "{\"FixtureId\":10,\"Livescore\":{\"Scoreboard\":{\"Clock\":{\"Seconds\":5400,\"StoppageTimeSeconds\":300}}}}";
        String cleared = "{\"FixtureId\":10,\"Livescore\":{\"Scoreboard\":{\"Clock\":{\"Seconds\":5400}}}}";

        GetLivescoreResultElement livescore = mapper.readValue(withStoppage, GetLivescoreResultElement.class);
        GetEventsResultElement events = mapper.readValue(withStoppage, GetEventsResultElement.class);
        GetLivescoreResultElement clearedLivescore = mapper.readValue(cleared, GetLivescoreResultElement.class);

        assertEquals(300, livescore.livescore.scoreboard.clock.stoppageTimeSeconds);
        assertEquals(300, events.livescore.scoreboard.clock.stoppageTimeSeconds);
        assertNull(clearedLivescore.livescore.scoreboard.clock.stoppageTimeSeconds);
    }
}
