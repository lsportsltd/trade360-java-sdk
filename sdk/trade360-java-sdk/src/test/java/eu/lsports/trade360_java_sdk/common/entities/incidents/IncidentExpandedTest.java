package eu.lsports.trade360_java_sdk.common.entities.incidents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidentExpandedTest {

    @Test
    void testFieldAssignments() {
        Incident incident = new Incident();
        
        incident.id = 12345;
        assertEquals(12345, incident.id);
        
        incident.typeId = 1;
        assertEquals(1, incident.typeId);
        
        incident.participantId = 111;
        assertEquals(111, incident.participantId);
        
        incident.elapsed = 75;
        assertEquals(75, incident.elapsed);
        
        incident.addedTime = 3;
        assertEquals(3, incident.addedTime);
        
        incident.period = 2;
        assertEquals(2, incident.period);
    }

    @Test
    void testNullValues() {
        Incident incident = new Incident();
        
        incident.id = null;
        assertNull(incident.id);
        
        incident.typeId = null;
        assertNull(incident.typeId);
        
        incident.participantId = null;
        assertNull(incident.participantId);
        
        incident.elapsed = null;
        assertNull(incident.elapsed);
        
        incident.addedTime = null;
        assertNull(incident.addedTime);
        
        incident.period = null;
        assertNull(incident.period);
    }

    @Test
    void testInstantiation() {
        Incident incident = new Incident();
        assertNotNull(incident);
    }

    @Test
    void testComplexFieldAssignments() {
        Incident incident = new Incident();
        
        incident.description = "Goal scored";
        assertEquals("Goal scored", incident.description);
        
        incident.isActive = true;
        assertTrue(incident.isActive);
        
        incident.isConfirmed = false;
        assertFalse(incident.isConfirmed);
        
        incident.timestamp = "2023-12-01T15:30:00Z";
        assertEquals("2023-12-01T15:30:00Z", incident.timestamp);
    }

    @Test
    void testCompleteIncident() {
        Incident incident = new Incident();
        
        incident.id = 999;
        incident.typeId = 5;
        incident.participantId = 222;
        incident.elapsed = 90;
        incident.addedTime = 5;
        incident.period = 2;
        incident.description = "Match ended";
        incident.isActive = false;
        incident.isConfirmed = true;
        incident.timestamp = "2023-12-01T17:00:00Z";
        
        assertEquals(999, incident.id);
        assertEquals(5, incident.typeId);
        assertEquals(222, incident.participantId);
        assertEquals(90, incident.elapsed);
        assertEquals(5, incident.addedTime);
        assertEquals(2, incident.period);
        assertEquals("Match ended", incident.description);
        assertFalse(incident.isActive);
        assertTrue(incident.isConfirmed);
        assertEquals("2023-12-01T17:00:00Z", incident.timestamp);
    }
}
