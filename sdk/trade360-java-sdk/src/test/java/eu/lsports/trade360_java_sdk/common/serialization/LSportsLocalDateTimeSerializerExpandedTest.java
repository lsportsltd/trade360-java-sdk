package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsLocalDateTimeSerializerExpandedTest {

    @Test
    void testSerializeLocalDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime dateTime = LocalDateTime.of(2023, 12, 25, 15, 30, 45);
        long expectedEpochMilli = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(dateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testHandledType() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        
        Class<LocalDateTime> handledType = serializer.handledType();
        
        assertEquals(LocalDateTime.class, handledType);
    }

    @Test
    void testConstructor() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        
        assertNotNull(serializer);
        assertEquals(LocalDateTime.class, serializer.handledType());
    }

    @Test
    void testSerializeWithDifferentDates() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime dateTime1 = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2025, 12, 31, 23, 59, 59);
        
        long expectedEpochMilli1 = dateTime1.toInstant(ZoneOffset.UTC).toEpochMilli();
        long expectedEpochMilli2 = dateTime2.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(dateTime1, mockGenerator, mockProvider);
        serializer.serialize(dateTime2, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli1);
        verify(mockGenerator).writeNumber(expectedEpochMilli2);
    }

    @Test
    void testSerializeEpochStart() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime epochStart = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        long expectedEpochMilli = 0L;
        
        serializer.serialize(epochStart, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }
}
