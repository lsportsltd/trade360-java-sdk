package eu.lsports.trade360_java_sdk.common.serialization;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * The {@code LSportsLocalDateTimeSerializer} class serializes {@link LocalDateTime} objects to their epoch millisecond representation in UTC.
 */
public class LSportsLocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    /**
     * Constructs a new {@code LSportsLocalDateTimeSerializer} with the specified class type.
     *
     * @param t the class type to serialize
     */
    public LSportsLocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    /**
     * Constructs a new {@code LSportsLocalDateTimeSerializer} with no specified class type.
     */
    public LSportsLocalDateTimeSerializer() {
        this(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<LocalDateTime> handledType() {
        return LocalDateTime.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}