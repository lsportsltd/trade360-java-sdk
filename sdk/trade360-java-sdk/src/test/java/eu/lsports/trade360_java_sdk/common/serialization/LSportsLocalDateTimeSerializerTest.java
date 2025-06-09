package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsLocalDateTimeSerializerTest {
    @Test
    void serializeLocalDateTimeToEpochMillis() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 1, 12, 0);
        long expectedMillis = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        JsonGenerator gen = mock(JsonGenerator.class);
        SerializerProvider provider = mock(SerializerProvider.class);

        serializer.serialize(dateTime, gen, provider);
        verify(gen).writeNumber(expectedMillis);
    }

    @Test
    void testHandledType() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        assertEquals(LocalDateTime.class, serializer.handledType());
    }

    @Test
    void testSerializeToEpochMillisUTC() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 10, 12, 0, 0);
        long expectedMillis = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();

        JsonGenerator gen = mock(JsonGenerator.class);
        SerializerProvider provider = mock(SerializerProvider.class);

        serializer.serialize(dateTime, gen, provider);
        verify(gen).writeNumber(expectedMillis);
    }
} 