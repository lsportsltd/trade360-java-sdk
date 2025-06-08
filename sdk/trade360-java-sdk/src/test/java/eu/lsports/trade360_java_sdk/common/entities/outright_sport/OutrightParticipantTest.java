package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightParticipantTest {
    @Test
    void testInstantiation() {
        OutrightParticipant participant = new OutrightParticipant();
        assertNotNull(participant);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightParticipant participant = new OutrightParticipant();
        assertEquals(0, participant.id);
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertEquals(-1, participant.isActive);
        assertNull(participant.extraData);

        participant.id = 10;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 99;
        participant.isActive = 1;
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        participant.extraData = Arrays.asList(nvp);

        assertEquals(10, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(99, participant.rotationId);
        assertEquals(1, participant.isActive);
        assertNotNull(participant.extraData);
    }
} 