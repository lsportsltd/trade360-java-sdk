package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeartbeatUpdateTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void testEntityKey() {
        assertEquals(32, HeartbeatUpdate.entityKey);
    }

    @Test
    void testFieldAssignment() {
        HeartbeatUpdate update = new HeartbeatUpdate();
        assertNotNull(update);
    }

    @Test
    void testFeedInterruptedDefaultsToEmptyArray() {
        HeartbeatUpdate update = new HeartbeatUpdate();
        assertEquals(0, update.feedInterrupted.length);
    }

    @Test
    void testDeserializeFeedInterruptedArrayFromBody() throws Exception {
        String body = "{\"FeedInterrupted\":[1]}";

        HeartbeatUpdate update = objectMapper.readValue(body, HeartbeatUpdate.class);

        assertArrayEquals(new int[] {1}, update.feedInterrupted);
    }

    @Test
    void testDeserializeWithoutFeedInterruptedDefaultsToEmptyArray() throws Exception {
        String body = "{}";

        HeartbeatUpdate update = objectMapper.readValue(body, HeartbeatUpdate.class);

        assertEquals(0, update.feedInterrupted.length);
    }
}
