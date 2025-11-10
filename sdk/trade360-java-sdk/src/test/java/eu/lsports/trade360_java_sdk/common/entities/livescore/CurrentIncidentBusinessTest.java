package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentConfirmation;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentBusinessTest {
    @Test
    void testFullFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = IncidentType.GOAL;
        ci.name = IncidentType.GOAL.getIncidentName();
        ci.lastUpdate = LocalDateTime.of(2024, 7, 1, 15, 30);
        ci.confirmation = IncidentConfirmation.CONFIRMED;
        assertEquals(100L, ci.id);
        assertEquals("Goal", ci.name);
        assertEquals(LocalDateTime.of(2024, 7, 1, 15, 30), ci.lastUpdate);
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
        assertEquals(0L, ci.id);
    }
} 