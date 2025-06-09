package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Incident incident = new Incident();
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }
} 