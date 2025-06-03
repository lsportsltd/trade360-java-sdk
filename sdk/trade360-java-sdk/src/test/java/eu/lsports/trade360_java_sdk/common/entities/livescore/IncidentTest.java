package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {
    @Test
    void testFieldAssignment() {
        Incident incident = new Incident();
        incident.period = 1;
        incident.incidentType = 2;
        incident.seconds = 45;
        incident.participantPosition = "Forward";
        incident.playerId = "p123";
        incident.playerName = "John Doe";
        Result result = new Result();
        incident.results = List.of(result);
        assertEquals(1, incident.period);
        assertEquals(2, incident.incidentType);
        assertEquals(45, incident.seconds);
        assertEquals("Forward", incident.participantPosition);
        assertEquals("p123", incident.playerId);
        assertEquals("John Doe", incident.playerName);
        assertNotNull(incident.results);
    }
} 