package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentCorrectTest {

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

    @Test
    void testIncidentPeriodAssignment() {
        Incident incident = new Incident();
        int testPeriod = 2;
        
        incident.period = testPeriod;
        
        assertEquals(testPeriod, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentTypeAssignment() {
        Incident incident = new Incident();
        int testIncidentType = 1;
        
        incident.incidentType = testIncidentType;
        
        assertEquals(testIncidentType, incident.incidentType);
        assertEquals(0, incident.period);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentSecondsAssignment() {
        Incident incident = new Incident();
        int testSeconds = 2700;
        
        incident.seconds = testSeconds;
        
        assertEquals(testSeconds, incident.seconds);
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentParticipantPositionAssignment() {
        Incident incident = new Incident();
        String testPosition = "Forward";
        
        incident.participantPosition = testPosition;
        
        assertEquals(testPosition, incident.participantPosition);
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentPlayerIdAssignment() {
        Incident incident = new Incident();
        String testPlayerId = "12345";
        
        incident.playerId = testPlayerId;
        
        assertEquals(testPlayerId, incident.playerId);
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerName);
        assertNull(incident.results);
    }

    @Test
    void testIncidentPlayerNameAssignment() {
        Incident incident = new Incident();
        String testPlayerName = "John Doe";
        
        incident.playerName = testPlayerName;
        
        assertEquals(testPlayerName, incident.playerName);
        assertEquals(0, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.results);
    }

    @Test
    void testIncidentAllFieldsAssignment() {
        Incident incident = new Incident();
        int testPeriod = 1;
        int testIncidentType = 1;
        int testSeconds = 2700;
        String testPosition = "Midfielder";
        String testPlayerId = "67890";
        String testPlayerName = "Jane Smith";
        
        incident.period = testPeriod;
        incident.incidentType = testIncidentType;
        incident.seconds = testSeconds;
        incident.participantPosition = testPosition;
        incident.playerId = testPlayerId;
        incident.playerName = testPlayerName;
        
        assertEquals(testPeriod, incident.period);
        assertEquals(testIncidentType, incident.incidentType);
        assertEquals(testSeconds, incident.seconds);
        assertEquals(testPosition, incident.participantPosition);
        assertEquals(testPlayerId, incident.playerId);
        assertEquals(testPlayerName, incident.playerName);
    }

    @Test
    void testIncidentNullAssignments() {
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
    void testIncidentIntegerEdgeCases() {
        Incident incident = new Incident();
        
        incident.period = 0;
        assertEquals(0, incident.period);
        
        incident.period = -1;
        assertEquals(-1, incident.period);
        
        incident.period = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, incident.period);
        
        incident.incidentType = 0;
        assertEquals(0, incident.incidentType);
        
        incident.seconds = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, incident.seconds);
    }

    @Test
    void testIncidentStringEdgeCases() {
        Incident incident = new Incident();
        
        incident.participantPosition = "";
        assertEquals("", incident.participantPosition);
        
        incident.playerId = "";
        assertEquals("", incident.playerId);
        
        incident.playerName = "";
        assertEquals("", incident.playerName);
        
        incident.participantPosition = "Very Long Position Name";
        assertEquals("Very Long Position Name", incident.participantPosition);
        
        incident.playerName = "Very Long Player Name With Many Characters";
        assertEquals("Very Long Player Name With Many Characters", incident.playerName);
    }

    @Test
    void testIncidentReassignment() {
        Incident incident = new Incident();
        
        incident.period = 1;
        incident.incidentType = 1;
        incident.seconds = 1800;
        incident.participantPosition = "Forward";
        incident.playerId = "100";
        incident.playerName = "Player One";
        
        assertEquals(1, incident.period);
        assertEquals(1, incident.incidentType);
        assertEquals(1800, incident.seconds);
        assertEquals("Forward", incident.participantPosition);
        assertEquals("100", incident.playerId);
        assertEquals("Player One", incident.playerName);
        
        incident.period = 2;
        incident.incidentType = 2;
        incident.seconds = 4500;
        incident.participantPosition = "Defender";
        incident.playerId = "200";
        incident.playerName = "Player Two";
        
        assertEquals(2, incident.period);
        assertEquals(2, incident.incidentType);
        assertEquals(4500, incident.seconds);
        assertEquals("Defender", incident.participantPosition);
        assertEquals("200", incident.playerId);
        assertEquals("Player Two", incident.playerName);
    }

    @Test
    void testMultipleIncidentInstances() {
        Incident incident1 = new Incident();
        Incident incident2 = new Incident();
        
        incident1.period = 1;
        incident1.incidentType = 1;
        incident1.seconds = 1800;
        incident1.playerName = "First Player";
        
        incident2.period = 2;
        incident2.incidentType = 2;
        incident2.seconds = 3600;
        incident2.playerName = "Second Player";
        
        assertEquals(1, incident1.period);
        assertEquals(2, incident2.period);
        assertNotEquals(incident1.period, incident2.period);
        assertNotEquals(incident1.incidentType, incident2.incidentType);
        assertNotEquals(incident1.seconds, incident2.seconds);
        assertNotEquals(incident1.playerName, incident2.playerName);
    }

    @Test
    void testIncidentFieldIndependence() {
        Incident incident = new Incident();
        
        incident.period = 1;
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.playerName);
        assertNull(incident.results);
        
        incident.playerName = "Test Player";
        assertEquals(1, incident.period);
        assertEquals(0, incident.incidentType);
        assertEquals(0, incident.seconds);
        assertNull(incident.participantPosition);
        assertNull(incident.playerId);
        assertNull(incident.results);
    }

    @Test
    void testIncidentStringImmutability() {
        Incident incident = new Incident();
        String originalPosition = "Goalkeeper";
        String originalPlayerId = "999";
        String originalPlayerName = "Test Player";
        
        incident.participantPosition = originalPosition;
        incident.playerId = originalPlayerId;
        incident.playerName = originalPlayerName;
        
        String retrievedPosition = incident.participantPosition;
        String retrievedPlayerId = incident.playerId;
        String retrievedPlayerName = incident.playerName;
        
        assertEquals(originalPosition, retrievedPosition);
        assertEquals(originalPlayerId, retrievedPlayerId);
        assertEquals(originalPlayerName, retrievedPlayerName);
        assertSame(originalPosition, retrievedPosition);
        assertSame(originalPlayerId, retrievedPlayerId);
        assertSame(originalPlayerName, retrievedPlayerName);
    }

    @Test
    void testIncidentWithSpecialCharacters() {
        Incident incident = new Incident();
        
        incident.playerName = "Player with special chars: !@#$%^&*()";
        assertEquals("Player with special chars: !@#$%^&*()", incident.playerName);
        
        incident.playerName = "Unicode: ñáéíóú 中文";
        assertEquals("Unicode: ñáéíóú 中文", incident.playerName);
        
        incident.participantPosition = "Position with symbols: @#$";
        assertEquals("Position with symbols: @#$", incident.participantPosition);
    }

    @Test
    void testIncidentWithWhitespace() {
        Incident incident = new Incident();
        
        incident.participantPosition = "  Forward  ";
        assertEquals("  Forward  ", incident.participantPosition);
        
        incident.playerName = "  Player Name  ";
        assertEquals("  Player Name  ", incident.playerName);
        
        incident.playerId = "  123  ";
        assertEquals("  123  ", incident.playerId);
    }
}
