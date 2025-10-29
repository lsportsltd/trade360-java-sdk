package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.*;

public class LSportsLocalDateTimeSerializerTests {

    private LSportsLocalDateTimeSerializer serializer;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        serializer = new LSportsLocalDateTimeSerializer();
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, serializer);
        objectMapper.registerModule(module);
    }

    @Test
    public void constructor_withNoArguments_createsValidSerializer() {
        LSportsLocalDateTimeSerializer ser = new LSportsLocalDateTimeSerializer();
        
        assertNotNull(ser);
    }

    @Test
    public void constructor_withClassArgument_createsValidSerializer() {
        LSportsLocalDateTimeSerializer ser = new LSportsLocalDateTimeSerializer(LocalDateTime.class);
        
        assertNotNull(ser);
    }

    @Test
    public void constructor_withNullClassArgument_createsValidSerializer() {
        LSportsLocalDateTimeSerializer ser = new LSportsLocalDateTimeSerializer(null);
        
        assertNotNull(ser);
    }

    @Test
    public void handledType_returnsLocalDateTimeClass() {
        Class<LocalDateTime> handledType = serializer.handledType();
        
        assertEquals(LocalDateTime.class, handledType);
    }

    @Test
    public void serialize_validDateTime_writesEpochMilliseconds() throws IOException {
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 12, 0, 0);
        long expectedEpochMilli = dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(dateTime, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
    }

    @Test
    public void serialize_epoch_writesZero() throws IOException {
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(epoch, generator, provider);
        generator.flush();
        
        assertEquals("0", writer.toString());
    }

    @Test
    public void serialize_beforeEpoch_writesNegativeNumber() throws IOException {
        LocalDateTime beforeEpoch = LocalDateTime.of(1969, 12, 31, 23, 59, 59);
        long expectedEpochMilli = beforeEpoch.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(beforeEpoch, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
        assertTrue(expectedEpochMilli < 0);
    }

    @Test
    public void serialize_futureDate_writesLargePositiveNumber() throws IOException {
        LocalDateTime futureDate = LocalDateTime.of(2050, 12, 31, 23, 59, 59);
        long expectedEpochMilli = futureDate.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(futureDate, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
    }

    @Test
    public void serialize_withMilliseconds_preservesMilliseconds() throws IOException {
        LocalDateTime dateTimeWithMillis = LocalDateTime.of(2024, 6, 15, 10, 30, 45, 123_000_000);
        long expectedEpochMilli = dateTimeWithMillis.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(dateTimeWithMillis, generator, provider);
        generator.flush();
        
        String result = writer.toString();
        assertEquals(String.valueOf(expectedEpochMilli), result);
        assertTrue(result.endsWith("123"));
    }

    @Test
    public void serialize_midnightUTC_writesCorrectValue() throws IOException {
        LocalDateTime midnight = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        long expectedEpochMilli = midnight.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(midnight, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
    }

    @Test
    public void serialize_endOfDay_writesCorrectValue() throws IOException {
        LocalDateTime endOfDay = LocalDateTime.of(2024, 12, 31, 23, 59, 59, 999_000_000);
        long expectedEpochMilli = endOfDay.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(endOfDay, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
    }

    @Test
    public void serialize_leapYear_handlesCorrectly() throws IOException {
        LocalDateTime leapDay = LocalDateTime.of(2024, 2, 29, 12, 0, 0);
        long expectedEpochMilli = leapDay.toInstant(ZoneOffset.UTC).toEpochMilli();
        
        StringWriter writer = new StringWriter();
        JsonGenerator generator = new JsonFactory().createGenerator(writer);
        SerializerProvider provider = objectMapper.getSerializerProvider();
        
        serializer.serialize(leapDay, generator, provider);
        generator.flush();
        
        assertEquals(String.valueOf(expectedEpochMilli), writer.toString());
    }

    @Test
    public void serialize_twoDifferentDates_producesDifferentValues() throws IOException {
        LocalDateTime date1 = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2024, 1, 2, 0, 0, 0);
        
        StringWriter writer1 = new StringWriter();
        JsonGenerator generator1 = new JsonFactory().createGenerator(writer1);
        serializer.serialize(date1, generator1, objectMapper.getSerializerProvider());
        generator1.flush();
        
        StringWriter writer2 = new StringWriter();
        JsonGenerator generator2 = new JsonFactory().createGenerator(writer2);
        serializer.serialize(date2, generator2, objectMapper.getSerializerProvider());
        generator2.flush();
        
        assertNotEquals(writer1.toString(), writer2.toString());
    }

    @Test
    public void serialize_sameDateTime_producesSameValue() throws IOException {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 15, 10, 30, 45);
        
        StringWriter writer1 = new StringWriter();
        JsonGenerator generator1 = new JsonFactory().createGenerator(writer1);
        serializer.serialize(dateTime, generator1, objectMapper.getSerializerProvider());
        generator1.flush();
        
        StringWriter writer2 = new StringWriter();
        JsonGenerator generator2 = new JsonFactory().createGenerator(writer2);
        serializer.serialize(dateTime, generator2, objectMapper.getSerializerProvider());
        generator2.flush();
        
        assertEquals(writer1.toString(), writer2.toString());
    }
}

