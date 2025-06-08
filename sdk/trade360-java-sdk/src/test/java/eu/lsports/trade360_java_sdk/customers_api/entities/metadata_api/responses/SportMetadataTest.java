package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportMetadataTest {
    @Test
    void testConstructorAndFields() {
        int id = 1;
        String name = "Sport";
        SportMetadata sm = new SportMetadata(id, name);
        assertEquals(id, sm.id());
        assertEquals(name, sm.name());
    }
} 