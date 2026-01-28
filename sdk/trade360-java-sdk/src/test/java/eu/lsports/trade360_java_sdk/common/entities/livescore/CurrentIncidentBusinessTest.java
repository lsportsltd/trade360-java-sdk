package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentConfirmation;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentType;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentBusinessTest {
    @Test
    void testFullFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = IncidentType.GOAL;
        ci.name = "Goal";
        ci.lastUpdate = Instant.parse("2024-07-01T15:30:00Z");
        ci.confirmation = IncidentConfirmation.CONFIRMED;
        
        assertEquals(IncidentType.GOAL, ci.id);
        assertEquals("Goal", ci.name);
        assertEquals(Instant.parse("2024-07-01T15:30:00Z"), ci.lastUpdate);
        assertEquals(IncidentConfirmation.CONFIRMED, ci.confirmation);
    }

    @Test
    void testNullNameAndLastUpdate() {
        CurrentIncident ci = new CurrentIncident();
        ci.name = null;
        ci.lastUpdate = null;
        assertNull(ci.name);
        assertNull(ci.lastUpdate);
    }

    @Test
    void testDefaultId() {
        CurrentIncident ci = new CurrentIncident();
        assertNull(ci.id);
    }
} 