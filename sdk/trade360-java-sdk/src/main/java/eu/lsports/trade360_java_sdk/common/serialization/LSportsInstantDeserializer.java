package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

/**
 * The {@code LSportsInstantDeserializer} class deserializes JSON strings to {@link Instant} objects.
 * It supports:
 * - ISO-8601 formatted strings with timezone (e.g., "2025-06-15T18:30:00Z", "2025-06-15T18:30:00+02:00")
 * - ISO-8601 formatted strings without timezone (e.g., "2025-06-15T18:30:00") - treated as UTC
 * - Epoch milliseconds as string (e.g., "1750009800000")
 */
public class LSportsInstantDeserializer extends StdDeserializer<Instant> {

    public LSportsInstantDeserializer() {
        super(Instant.class);
    }

    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if (value == null || value.isEmpty()) {
            return null;
        }
        
        // Try parsing as ISO-8601 with timezone (e.g., "2025-06-15T18:30:00Z", "2025-06-15T18:30:00+02:00")
        try {
            return Instant.parse(value);
        } catch (DateTimeParseException e1) {
            // Try parsing as LocalDateTime (no timezone) and assume UTC
            try {
                LocalDateTime localDateTime = LocalDateTime.parse(value);
                return localDateTime.toInstant(ZoneOffset.UTC);
            } catch (DateTimeParseException e2) {
                // Try parsing as epoch milliseconds
                try {
                    return Instant.ofEpochMilli(Long.parseLong(value));
                } catch (NumberFormatException ex) {
                    throw ctxt.instantiationException(Instant.class, 
                        "Failed to parse Instant from string: " + value + ". " + e1.getMessage());
                }
            }
        }
    }
}

