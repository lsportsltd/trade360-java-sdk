package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsLocalDateTimeSerializerComprehensiveTest {

    @Test
    void testConstructorWithClass() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        
        assertNotNull(serializer);
        assertEquals(LocalDateTime.class, serializer.handledType());
    }

    @Test
    void testConstructorWithoutClass() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        
        assertNotNull(serializer);
        assertEquals(LocalDateTime.class, serializer.handledType());
    }

    @Test
    void testHandledType() {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        
        assertEquals(LocalDateTime.class, serializer.handledType());
    }

    @Test
    void testSerializeValidDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 12, 0, 0);
        long expectedEpochMilli = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(dateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeNullDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        assertThrows(NullPointerException.class, () -> {
            serializer.serialize(null, mockGenerator, mockProvider);
        });
    }

    @Test
    void testSerializeReasonableDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime reasonableDateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
        long expectedEpochMilli = reasonableDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(reasonableDateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeFutureDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime futureDateTime = LocalDateTime.of(2030, 12, 31, 23, 59, 59);
        long expectedEpochMilli = futureDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(futureDateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeEpochDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime epochDateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        long expectedEpochMilli = 0L;
        
        serializer.serialize(epochDateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeCurrentDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime now = LocalDateTime.now();
        long expectedEpochMilli = now.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(now, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeWithIOException() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 12, 0, 0);
        doThrow(new IOException("Test IO Exception")).when(mockGenerator).writeNumber(anyLong());
        
        assertThrows(IOException.class, () -> {
            serializer.serialize(dateTime, mockGenerator, mockProvider);
        });
    }

    @Test
    void testSerializeLeapYearDateTime() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime leapYearDateTime = LocalDateTime.of(2020, 2, 29, 23, 59, 59);
        long expectedEpochMilli = leapYearDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(leapYearDateTime, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }

    @Test
    void testSerializeWithNanoseconds() throws IOException {
        LSportsLocalDateTimeSerializer serializer = new LSportsLocalDateTimeSerializer();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        SerializerProvider mockProvider = mock(SerializerProvider.class);
        
        LocalDateTime dateTimeWithNanos = LocalDateTime.of(2023, 1, 1, 12, 0, 0, 123456789);
        long expectedEpochMilli = dateTimeWithNanos.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        serializer.serialize(dateTimeWithNanos, mockGenerator, mockProvider);
        
        verify(mockGenerator).writeNumber(expectedEpochMilli);
    }
}
