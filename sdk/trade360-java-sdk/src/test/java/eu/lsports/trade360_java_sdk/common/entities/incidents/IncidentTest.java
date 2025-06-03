package eu.lsports.trade360_java_sdk.common.entities.incidents;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {
    @Test
    void testFieldAssignment() {
        Incident incident = new Incident();
        incident.sportId = 1;
        incident.sportName = "Soccer";
        incident.incidentId = 100;
        incident.incidentName = "Goal";
        incident.description = "A goal was scored.";
        incident.lastUpdate = LocalDateTime.now();
        incident.creationDate = LocalDateTime.of(2024, 1, 1, 0, 0);

        assertEquals(1, incident.sportId);
        assertEquals("Soccer", incident.sportName);
        assertEquals(100, incident.incidentId);
        assertEquals("Goal", incident.incidentName);
        assertEquals("A goal was scored.", incident.description);
        assertNotNull(incident.lastUpdate);
        assertEquals(LocalDateTime.of(2024, 1, 1, 0, 0), incident.creationDate);
    }
} 