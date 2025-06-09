package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IncidentFieldTest {

    @Test
    void testIncidentFieldAssignment() {
        Incident incident = new Incident();
        
        int period = 1;
        int incidentType = 3;
        int seconds = 2700;
        String participantPosition = "Forward";
        String playerId = "12345";
        String playerName = "John Doe";
        Iterable<Result> results = Arrays.asList(new Result(), new Result());
        
        incident.period = period;
        incident.incidentType = incidentType;
        incident.seconds = seconds;
        incident.participantPosition = participantPosition;
        incident.playerId = playerId;
        incident.playerName = playerName;
        incident.results = results;
        
        assertEquals(period, incident.period);
        assertEquals(incidentType, incident.incidentType);
        assertEquals(seconds, incident.seconds);
        assertEquals(participantPosition, incident.participantPosition);
        assertEquals(playerId, incident.playerId);
        assertEquals(playerName, incident.playerName);
        assertEquals(results, incident.results);
    }

    @Test
    void testIncidentWithNullValues() {
        Incident incident = new Incident();
        
        incident.participantPosition = null;
        incident.playerId = null;
        incident.playerName = null;
        incident.results = null;
        
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentDefaultConstructor() {
        Incident incident = new Incident();
        
        assertNotNull(incident);
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }
}
