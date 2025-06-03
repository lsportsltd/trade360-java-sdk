package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsLocalDateTimeSerializerTest {
    @Test
    void testSerialize() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator gen = mock(JsonGenerator.class);
        LocalDateTime now = LocalDateTime.of(2024, 1, 2, 3, 4, 5);
        serializer.serialize(now, gen, null);
        verify(gen).writeNumber(anyLong());
    }
} 