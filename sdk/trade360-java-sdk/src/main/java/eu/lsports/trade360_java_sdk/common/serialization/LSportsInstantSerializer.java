package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;

/**
 * The {@code LSportsInstantSerializer} class serializes {@link Instant} objects to their epoch millisecond representation.
 */
public class LSportsInstantSerializer extends StdSerializer<Instant> {

    public LSportsInstantSerializer() {
        super(Instant.class);
    }

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.toEpochMilli());
    }
}

