package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionMetadataTest {
    @Test
    void testConstructorAndFields() {
        int id = 1;
        String name = "Competition";
        int type = 2;
        int trackId = 3;
        CompetitionMetadata cm = new CompetitionMetadata(id, name, type, trackId);
        assertEquals(id, cm.id());
        assertEquals(name, cm.name());
        assertEquals(type, cm.type());
        assertEquals(trackId, cm.trackId());
    }
} 