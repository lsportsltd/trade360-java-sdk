package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentTest {
    @Test
    void testFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = 42;
        ci.name = "IncidentName";
        ci.lastUpdate = LocalDateTime.of(2024, 6, 1, 12, 0);
        assertEquals(42, ci.id);
        assertEquals("IncidentName", ci.name);
        assertEquals(LocalDateTime.of(2024, 6, 1, 12, 0), ci.lastUpdate);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        CurrentIncident incident = new CurrentIncident();
        assertEquals(0, incident.id);
        assertNull(incident.name);
        assertNull(incident.lastUpdate);
    }
} 