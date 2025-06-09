package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsLocalDateTimeDeserializerComprehensiveTest {

    @Mock
    private JsonParser jsonParser;
    
    @Mock
    private DeserializationContext deserializationContext;

    @Test
    void testDeserializeValidDateTimeString() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(12, result.getMonthValue());
        assertEquals(25, result.getDayOfMonth());
        assertEquals(15, result.getHour());
        assertEquals(30, result.getMinute());
        assertEquals(45, result.getSecond());
    }

    @Test
    void testDeserializeNullString() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        
        when(jsonParser.getText()).thenReturn(null);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNull(result);
    }

    @Test
    void testDeserializeEmptyString() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        
        when(jsonParser.getText()).thenReturn("");
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNull(result);
    }

    @Test
    void testDeserializeWhitespaceString() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        
        when(jsonParser.getText()).thenReturn("   ");
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNull(result);
    }

    @Test
    void testDeserializeValidDateTimeWithMilliseconds() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45.123";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(12, result.getMonthValue());
        assertEquals(25, result.getDayOfMonth());
        assertEquals(15, result.getHour());
        assertEquals(30, result.getMinute());
        assertEquals(45, result.getSecond());
    }

    @Test
    void testDeserializeValidDateTimeWithMicroseconds() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45.123456";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(12, result.getMonthValue());
        assertEquals(25, result.getDayOfMonth());
        assertEquals(15, result.getHour());
        assertEquals(30, result.getMinute());
        assertEquals(45, result.getSecond());
    }

    @Test
    void testDeserializeValidDateTimeWithNanoseconds() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45.123456789";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(12, result.getMonthValue());
        assertEquals(25, result.getDayOfMonth());
        assertEquals(15, result.getHour());
        assertEquals(30, result.getMinute());
        assertEquals(45, result.getSecond());
    }

    @Test
    void testDeserializeInvalidDateTimeFormat() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String invalidDateTime = "invalid-date-time";
        
        when(jsonParser.getText()).thenReturn(invalidDateTime);
        
        assertThrows(RuntimeException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializePartialDateTime() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String partialDateTime = "2023-12-25";
        
        when(jsonParser.getText()).thenReturn(partialDateTime);
        
        assertThrows(RuntimeException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializeLeapYearDateTime() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String leapYearDateTime = "2024-02-29T12:00:00";
        
        when(jsonParser.getText()).thenReturn(leapYearDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(2, result.getMonthValue());
        assertEquals(29, result.getDayOfMonth());
        assertEquals(12, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    void testDeserializeMinDateTime() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String minDateTime = "0001-01-01T00:00:00";
        
        when(jsonParser.getText()).thenReturn(minDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(1, result.getYear());
        assertEquals(1, result.getMonthValue());
        assertEquals(1, result.getDayOfMonth());
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    @Test
    void testDeserializeMaxDateTime() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String maxDateTime = "9999-12-31T23:59:59";
        
        when(jsonParser.getText()).thenReturn(maxDateTime);
        
        LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertNotNull(result);
        assertEquals(9999, result.getYear());
        assertEquals(12, result.getMonthValue());
        assertEquals(31, result.getDayOfMonth());
        assertEquals(23, result.getHour());
        assertEquals(59, result.getMinute());
        assertEquals(59, result.getSecond());
    }

    @Test
    void testDeserializeWithDifferentSeparators() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String dateTimeWithSpace = "2023-12-25 15:30:45";
        
        when(jsonParser.getText()).thenReturn(dateTimeWithSpace);
        
        assertThrows(RuntimeException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializeWithTimeZone() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String dateTimeWithTimeZone = "2023-12-25T15:30:45Z";
        
        when(jsonParser.getText()).thenReturn(dateTimeWithTimeZone);
        
        assertThrows(RuntimeException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializeWithOffset() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String dateTimeWithOffset = "2023-12-25T15:30:45+02:00";
        
        when(jsonParser.getText()).thenReturn(dateTimeWithOffset);
        
        assertThrows(RuntimeException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializeConsistency() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result1 = deserializer.deserialize(jsonParser, deserializationContext);
        LocalDateTime result2 = deserializer.deserialize(jsonParser, deserializationContext);
        
        assertEquals(result1, result2);
    }

    @Test
    void testDeserializeMultipleInstances() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer1 = new LSportsLocalDateTimeDeserializer();
        LSportsLocalDateTimeDeserializer deserializer2 = new LSportsLocalDateTimeDeserializer();
        String validDateTime = "2023-12-25T15:30:45";
        
        when(jsonParser.getText()).thenReturn(validDateTime);
        
        LocalDateTime result1 = deserializer1.deserialize(jsonParser, deserializationContext);
        LocalDateTime result2 = deserializer2.deserialize(jsonParser, deserializationContext);
        
        assertEquals(result1, result2);
    }

    @Test
    void testDeserializeWithIOException() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        
        when(jsonParser.getText()).thenThrow(new IOException("Test IO Exception"));
        
        assertThrows(IOException.class, () -> {
            deserializer.deserialize(jsonParser, deserializationContext);
        });
    }

    @Test
    void testDeserializeEdgeCaseDates() throws IOException {
        MockitoAnnotations.openMocks(this);
        LSportsLocalDateTimeDeserializer deserializer = new LSportsLocalDateTimeDeserializer();
        
        String[] edgeCaseDates = {
            "2023-01-01T00:00:00",
            "2023-12-31T23:59:59",
            "2023-06-15T12:30:45",
            "2023-02-28T23:59:59",
            "2024-02-29T00:00:01"
        };
        
        for (String dateTime : edgeCaseDates) {
            when(jsonParser.getText()).thenReturn(dateTime);
            LocalDateTime result = deserializer.deserialize(jsonParser, deserializationContext);
            assertNotNull(result);
        }
    }
}
