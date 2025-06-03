package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentTest {
    @Test
    void testFieldAssignment() {
        CurrentIncident ci = new CurrentIncident();
        ci.id = 42L;
        ci.name = "IncidentName";
        ci.lastUpdate = LocalDateTime.of(2024, 6, 1, 12, 0);
        assertEquals(42L, ci.id);
        assertEquals("IncidentName", ci.name);
        assertEquals(LocalDateTime.of(2024, 6, 1, 12, 0), ci.lastUpdate);
    }
} 