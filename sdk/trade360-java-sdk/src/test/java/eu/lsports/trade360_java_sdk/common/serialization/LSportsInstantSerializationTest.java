package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LSportsInstantSerializer and LSportsInstantDeserializer.
 */
class LSportsInstantSerializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule()
                        .addSerializer(Instant.class, new LSportsInstantSerializer())
                        .addDeserializer(Instant.class, new LSportsInstantDeserializer()));
    }

    @Test
    void serialize_instant_toEpochMillis() throws JsonProcessingException {
        Instant instant = Instant.parse("2025-06-15T18:30:00Z");
        String json = objectMapper.writeValueAsString(instant);
        assertEquals(String.valueOf(instant.toEpochMilli()), json);
    }

    @Test
    void deserialize_utcString_toInstant() throws JsonProcessingException {
        String json = "\"2025-06-15T18:30:00Z\"";
        Instant instant = objectMapper.readValue(json, Instant.class);
        assertEquals(Instant.parse("2025-06-15T18:30:00Z"), instant);
    }

    @Test
    void deserialize_offsetString_toInstant() throws JsonProcessingException {
        // +02:00 offset means the actual UTC time is 16:30:00
        String json = "\"2025-06-15T18:30:00+02:00\"";
        Instant instant = objectMapper.readValue(json, Instant.class);
        assertEquals(Instant.parse("2025-06-15T16:30:00Z"), instant);
    }

    @Test
    void deserialize_epochMillis_toInstant() throws JsonProcessingException {
        Instant expected = Instant.parse("2025-06-15T18:30:00Z");
        String json = "\"" + expected.toEpochMilli() + "\"";
        Instant instant = objectMapper.readValue(json, Instant.class);
        assertEquals(expected, instant);
    }

    @Test
    void roundTrip_preservesInstant() throws JsonProcessingException {
        Instant original = Instant.parse("2025-06-15T18:30:00Z");
        String json = objectMapper.writeValueAsString(original);
        // Deserialize from epoch millis string
        Instant deserialized = objectMapper.readValue(json, Instant.class);
        assertEquals(original, deserialized);
    }

    @Test
    void deserialize_nullOrEmpty_returnsNull() throws JsonProcessingException {
        String jsonEmpty = "\"\"";
        Instant instant = objectMapper.readValue(jsonEmpty, Instant.class);
        assertNull(instant);
    }

    @Test
    void deserialize_noTimezone_treatedAsUtc() throws JsonProcessingException {
        // API often returns dates without timezone - should be treated as UTC
        String json = "\"2026-01-27T00:00:00\"";
        Instant instant = objectMapper.readValue(json, Instant.class);
        assertEquals(Instant.parse("2026-01-27T00:00:00Z"), instant);
    }

    @Test
    void deserialize_withMilliseconds_noTimezone() throws JsonProcessingException {
        String json = "\"2026-01-27T12:30:45.123\"";
        Instant instant = objectMapper.readValue(json, Instant.class);
        assertEquals(Instant.parse("2026-01-27T12:30:45.123Z"), instant);
    }
}

