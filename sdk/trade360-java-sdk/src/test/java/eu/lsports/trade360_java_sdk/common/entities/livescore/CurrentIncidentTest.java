package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentConfirmation;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentType;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentTest {
    @Test
    void testFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = IncidentType.BATSMAN_SIXES;
        ci.name = "IncidentName";
        ci.lastUpdate = Instant.parse("2024-06-01T12:00:00Z");
        ci.confirmation = IncidentConfirmation.CONFIRMED;
        
        assertEquals(IncidentType.BATSMAN_SIXES, ci.id);
        assertEquals("IncidentName", ci.name);
        assertEquals(Instant.parse("2024-06-01T12:00:00Z"), ci.lastUpdate);
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