package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    @Test
    void testConstructorAndAccessors() {
        Participant participant = new Participant(101, "Alice");
        assertEquals(101, participant.participantId());
        assertEquals("Alice", participant.participantName());
    }

    @Test
    void testNullName() {
        Participant participant = new Participant(202, null);
        assertEquals(202, participant.participantId());
        assertNull(participant.participantName());
    }

    @Test
    void testEqualsAndHashCode() {
        Participant p1 = new Participant(1, "Bob");
        Participant p2 = new Participant(1, "Bob");
        Participant p3 = new Participant(2, "Carol");
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    void testToString() {
        Participant participant = new Participant(5, "Dave");
        String str = participant.toString();
        assertTrue(str.contains("5"));
        assertTrue(str.contains("Dave"));
    }
} 