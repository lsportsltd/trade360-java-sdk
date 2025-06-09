package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightParticipantResultTest {
    @Test
    void testInstantiation() {
        OutrightParticipantResult result = new OutrightParticipantResult();
        assertNotNull(result);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightParticipantResult result = new OutrightParticipantResult();
        assertEquals(0, result.participantId);
        assertNull(result.name);
        assertEquals(0, result.result);

        result.participantId = 5;
        result.name = "PlayerName";
        result.result = 1;

        assertEquals(5, result.participantId);
        assertEquals("PlayerName", result.name);
        assertEquals(1, result.result);
    }
} 