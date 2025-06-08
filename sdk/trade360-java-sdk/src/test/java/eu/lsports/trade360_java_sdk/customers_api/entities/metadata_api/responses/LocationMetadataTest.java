package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationMetadataTest {
    @Test
    void testConstructorAndFields() {
        int id = 1;
        String name = "Location";
        LocationMetadata lm = new LocationMetadata(id, name);
        assertEquals(id, lm.id());
        assertEquals(name, lm.name());
    }
} 