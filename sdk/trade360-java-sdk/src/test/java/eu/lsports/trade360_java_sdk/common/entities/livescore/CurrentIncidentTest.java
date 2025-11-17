package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentConfirmation;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentTest {
    @Test
    void testFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = IncidentType.BATSMAN_SIXES;
        ci.name = "IncidentName";
        ci.lastUpdate = LocalDateTime.of(2024, 6, 1, 12, 0);
        ci.confirmation = IncidentConfirmation.CONFIRMED;
        
        assertEquals(IncidentType.BATSMAN_SIXES, ci.id);
        assertEquals("IncidentName", ci.name);
        assertEquals(LocalDateTime.of(2024, 6, 1, 12, 0), ci.lastUpdate);
        assertEquals(IncidentConfirmation.CONFIRMED, ci.confirmation);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        CurrentIncident incident = new CurrentIncident();
        assertNull(incident.id);
        assertNull(incident.name);
        assertNull(incident.lastUpdate);
    }
} 