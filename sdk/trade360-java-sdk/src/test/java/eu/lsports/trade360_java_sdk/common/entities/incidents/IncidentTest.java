package eu.lsports.trade360_java_sdk.common.entities.incidents;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Incident incident = new Incident();
        assertNull(incident.sportId);
        assertNull(incident.sportName);
        assertNull(incident.incidentId);
        assertNull(incident.incidentName);
        assertNull(incident.description);
        assertNull(incident.lastUpdate);
        assertNull(incident.creationDate);

        incident.sportId = 1;
        incident.sportName = "Soccer";
        incident.incidentId = 100;
        incident.incidentName = "Goal";
        incident.description = "Scored a goal";
        LocalDateTime now = LocalDateTime.now();
        incident.lastUpdate = now;
        incident.creationDate = now;

        assertEquals(1, incident.sportId);
        assertEquals("Soccer", incident.sportName);
        assertEquals(100, incident.incidentId);
        assertEquals("Goal", incident.incidentName);
        assertEquals("Scored a goal", incident.description);
        assertEquals(now, incident.lastUpdate);
        assertEquals(now, incident.creationDate);
    }

    @Test
    void testInstantiation() {
        Incident incident = new Incident();
        assertNotNull(incident);
    }
} 