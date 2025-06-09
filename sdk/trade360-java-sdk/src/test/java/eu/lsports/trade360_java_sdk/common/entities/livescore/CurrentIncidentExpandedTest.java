package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrentIncidentExpandedTest {

    @Test
    void testFieldAssignments() {
        CurrentIncident currentIncident = new CurrentIncident();
        
        currentIncident.setId(123);
        assertEquals(123, currentIncident.getId());
        
        currentIncident.setFixtureId(456);
        assertEquals(456, currentIncident.getFixtureId());
        
        currentIncident.setParticipantId(789);
        assertEquals(789, currentIncident.getParticipantId());
        
        currentIncident.setType(1);
        assertEquals(1, currentIncident.getType());
        
        currentIncident.setPeriod(2);
        assertEquals(2, currentIncident.getPeriod());
        
        currentIncident.setTime("45:00");
        assertEquals("45:00", currentIncident.getTime());
        
        currentIncident.setAddedTime("2");
        assertEquals("2", currentIncident.getAddedTime());
        
        currentIncident.setConfirmed(true);
        assertTrue(currentIncident.getConfirmed());
        
        currentIncident.setPlayerName("John Doe");
        assertEquals("John Doe", currentIncident.getPlayerName());
        
        currentIncident.setResults("1-0");
        assertEquals("1-0", currentIncident.getResults());
        
        currentIncident.setOrder(1);
        assertEquals(1, currentIncident.getOrder());
    }

    @Test
    void testNullValues() {
        CurrentIncident currentIncident = new CurrentIncident();
        
        assertNull(currentIncident.getTime());
        assertNull(currentIncident.getAddedTime());
        assertNull(currentIncident.getConfirmed());
        assertNull(currentIncident.getPlayerName());
        assertNull(currentIncident.getResults());
    }

    @Test
    void testDefaultValues() {
        CurrentIncident currentIncident = new CurrentIncident();
        
        assertEquals(0, currentIncident.getId());
        assertEquals(0, currentIncident.getFixtureId());
        assertEquals(0, currentIncident.getParticipantId());
        assertEquals(0, currentIncident.getType());
        assertEquals(0, currentIncident.getPeriod());
        assertEquals(0, currentIncident.getOrder());
    }

    @Test
    void testBooleanHandling() {
        CurrentIncident currentIncident = new CurrentIncident();
        
        currentIncident.setConfirmed(false);
        assertFalse(currentIncident.getConfirmed());
        
        currentIncident.setConfirmed(true);
        assertTrue(currentIncident.getConfirmed());
        
        currentIncident.setConfirmed(null);
        assertNull(currentIncident.getConfirmed());
    }
}
