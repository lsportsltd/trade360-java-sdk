package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    @Test
    void testFieldAssignment() {
        Participant participant = new Participant();
        participant.id = 42;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 7;
        participant.isActive = 1;

        assertEquals(42, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(7, participant.rotationId);
        assertEquals(1, participant.isActive);
        assertNotNull(participant);
    }

    @Test
    void testDefaultIsActive() {
        Participant participant = new Participant();
        assertEquals(-1, participant.isActive);
    }
} 