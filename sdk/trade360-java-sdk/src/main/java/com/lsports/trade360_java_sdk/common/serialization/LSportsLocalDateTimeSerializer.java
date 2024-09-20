package com.lsports.trade360_java_sdk.common.serialization;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LSportsLocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
    public LSportsLocalDateTimeSerializer() {
        this(null);
    }

    public LSportsLocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public Class<LocalDateTime> handledType() {
        return LocalDateTime.class;
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
