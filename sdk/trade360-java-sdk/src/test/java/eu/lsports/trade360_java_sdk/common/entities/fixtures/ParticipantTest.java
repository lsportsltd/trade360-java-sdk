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
        participant.shirtColor = new UniformColor();
        participant.shirtColor.primary = "ffffff";
        participant.shirtColor.number = "000000";
        participant.shirtColor.outline = "ffffff";
        participant.goalKeeperShirtColor = new UniformColor();
        participant.goalKeeperShirtColor.primary = "ffff00";
        participant.goalKeeperShirtColor.number = "000000";
        participant.goalKeeperShirtColor.outline = "ffff00";

        assertEquals(42, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(7, participant.rotationId);
        assertEquals(1, participant.isActive);
        assertNotNull(participant.shirtColor);
        assertEquals("ffffff", participant.shirtColor.primary);
        assertNotNull(participant.goalKeeperShirtColor);
        assertEquals("ffff00", participant.goalKeeperShirtColor.primary);
        assertNotNull(participant);
    }

    @Test
    void testDefaultIsActive() {
        Participant participant = new Participant();
        assertEquals(-1, participant.isActive);
    }

    @Test
    void testNullableFields() {
        Participant participant = new Participant();
        
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertNull(participant.shirtColor);
        assertNull(participant.goalKeeperShirtColor);
    }

    @Test
    void testFieldModification() {
        Participant participant = new Participant();
        
        participant.name = "Initial Name";
        assertEquals("Initial Name", participant.name);
        
        participant.name = "Updated Name";
        assertEquals("Updated Name", participant.name);
        
        participant.name = null;
        assertNull(participant.name);
    }

    @Test
    void testRotationIdHandling() {
        Participant participant = new Participant();
        
        participant.rotationId = 0;
        assertEquals(0, participant.rotationId);
        
        participant.rotationId = 999;
        assertEquals(999, participant.rotationId);
        
        participant.rotationId = null;
        assertNull(participant.rotationId);
    }

    @Test
    void testIsActiveStates() {
        Participant participant = new Participant();
        
        assertEquals(-1, participant.isActive);
        
        participant.isActive = 0;
        assertEquals(0, participant.isActive);
        
        participant.isActive = 1;
        assertEquals(1, participant.isActive);
    }

    @Test
    void testCompleteParticipantData() {
        Participant participant = new Participant();
        participant.id = 123;
        participant.name = "Test Player";
        participant.position = "Goalkeeper";
        participant.rotationId = 1;
        participant.isActive = 1;
        
        assertEquals(123, participant.id);
        assertEquals("Test Player", participant.name);
        assertEquals("Goalkeeper", participant.position);
        assertEquals(1, participant.rotationId);
        assertEquals(1, participant.isActive);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Participant participant = new Participant();
        assertEquals(0, participant.id);
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertEquals(-1, participant.isActive);

        participant.id = 10;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 99;
        participant.isActive = 1;

        assertEquals(10, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(99, participant.rotationId);
        assertEquals(1, participant.isActive);
    }
}   