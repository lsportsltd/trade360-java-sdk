package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightParticipantResultTest {
    @Test
    void testConstructorAndFields() {
        OutrightParticipantResult element = new OutrightParticipantResult();
        element.participantId = 1;
        element.name = "participant";
        element.result = 2;
        assertEquals(1, element.participantId);
        assertEquals("participant", element.name);
        assertEquals(2, element.result);
    }
} 