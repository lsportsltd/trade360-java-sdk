package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    @Test
    void testFieldAssignment() {
        Participant participant = new Participant();
        participant.id = 42;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 7;
        participant.isActive = 1;

        assertEquals(42, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(7, participant.rotationId);
        assertEquals(1, participant.isActive);
        assertNotNull(participant);
    }

    @Test
    void testDefaultIsActive() {
        Participant participant = new Participant();
        assertEquals(-1, participant.isActive);
    }

    @Test
    void testNullableFields() {
        Participant participant = new Participant();
        
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertNull(participant.form);
        assertNull(participant.formation);
        assertNull(participant.fixturePlayers);
        assertNull(participant.gender);
        assertNull(participant.ageCategory);
        assertNull(participant.type);
    }

    @Test
    void testFieldModification() {
        Participant participant = new Participant();
        
        participant.name = "Initial Name";
        assertEquals("Initial Name", participant.name);
        
        participant.name = "Updated Name";
        assertEquals("Updated Name", participant.name);
        
        participant.name = null;
        assertNull(participant.name);
    }

    @Test
    void testRotationIdHandling() {
        Participant participant = new Participant();
        
        participant.rotationId = 0;
        assertEquals(0, participant.rotationId);
        
        participant.rotationId = 999;
        assertEquals(999, participant.rotationId);
        
        participant.rotationId = null;
        assertNull(participant.rotationId);
    }

    @Test
    void testIsActiveStates() {
        Participant participant = new Participant();
        
        assertEquals(-1, participant.isActive);
        
        participant.isActive = 0;
        assertEquals(0, participant.isActive);
        
        participant.isActive = 1;
        assertEquals(1, participant.isActive);
    }

    @Test
    void testCompleteParticipantData() {
        Participant participant = new Participant();
        participant.id = 123;
        participant.name = "Test Player";
        participant.position = "Goalkeeper";
        participant.rotationId = 1;
        participant.isActive = 1;
        
        assertEquals(123, participant.id);
        assertEquals("Test Player", participant.name);
        assertEquals("Goalkeeper", participant.position);
        assertEquals(1, participant.rotationId);
        assertEquals(1, participant.isActive);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Participant participant = new Participant();
        assertEquals(0, participant.id);
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertEquals(-1, participant.isActive);

        participant.id = 10;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 99;
        participant.isActive = 1;

        assertEquals(10, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(99, participant.rotationId);
        assertEquals(1, participant.isActive);
    }

    @Test
    void testFormAssignment() {
        Participant participant = new Participant();

        participant.form = "WWDLW";
        assertEquals("WWDLW", participant.form);

        participant.form = "LLDWW";
        assertEquals("LLDWW", participant.form);

        participant.form = null;
        assertNull(participant.form);
    }

    @Test
    void testFormationAssignment() {
        Participant participant = new Participant();

        participant.formation = "4-3-3";
        assertEquals("4-3-3", participant.formation);

        participant.formation = "4-4-2";
        assertEquals("4-4-2", participant.formation);

        participant.formation = "3-5-2";
        assertEquals("3-5-2", participant.formation);

        participant.formation = null;
        assertNull(participant.formation);
    }

    @Test
    void testFixturePlayersAssignment() {
        Participant participant = new Participant();

        FixturePlayer player1 = new FixturePlayer();
        player1.playerId = 10;
        player1.shirtNumber = "10";
        player1.isCaptain = true;

        FixturePlayer player2 = new FixturePlayer();
        player2.playerId = 7;
        player2.shirtNumber = "7";
        player2.isCaptain = false;

        participant.fixturePlayers = Arrays.asList(player1, player2);

        assertNotNull(participant.fixturePlayers);
        int count = 0;
        for (FixturePlayer player : participant.fixturePlayers) {
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void testEmptyFixturePlayers() {
        Participant participant = new Participant();

        participant.fixturePlayers = Collections.emptyList();

        assertNotNull(participant.fixturePlayers);
        int count = 0;
        for (FixturePlayer player : participant.fixturePlayers) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    void testGenderAssignment() {
        Participant participant = new Participant();

        participant.gender = 1;
        assertEquals(1, participant.gender);

        participant.gender = 2;
        assertEquals(2, participant.gender);

        participant.gender = null;
        assertNull(participant.gender);
    }

    @Test
    void testAgeCategoryAssignment() {
        Participant participant = new Participant();

        participant.ageCategory = 21;
        assertEquals(21, participant.ageCategory);

        participant.ageCategory = 0;
        assertEquals(0, participant.ageCategory);

        participant.ageCategory = null;
        assertNull(participant.ageCategory);
    }

    @Test
    void testTypeAssignment() {
        Participant participant = new Participant();

        participant.type = 1;
        assertEquals(1, participant.type);

        participant.type = 2;
        assertEquals(2, participant.type);

        participant.type = null;
        assertNull(participant.type);
    }

    @Test
    void testAllNewFieldsTogether() {
        Participant participant = new Participant();

        participant.id = 1;
        participant.name = "Manchester United";
        participant.position = "1";
        participant.rotationId = 100;
        participant.isActive = 1;
        participant.form = "WDWWL";
        participant.formation = "4-2-3-1";
        participant.gender = 1;
        participant.ageCategory = 0;
        participant.type = 1;

        FixturePlayer captain = new FixturePlayer();
        captain.playerId = 7;
        captain.shirtNumber = "7";
        captain.isCaptain = true;
        captain.isStartingLineup = true;

        participant.fixturePlayers = Collections.singletonList(captain);

        assertEquals(1, participant.id);
        assertEquals("Manchester United", participant.name);
        assertEquals("WDWWL", participant.form);
        assertEquals("4-2-3-1", participant.formation);
        assertEquals(1, participant.gender);
        assertEquals(0, participant.ageCategory);
        assertEquals(1, participant.type);
        assertNotNull(participant.fixturePlayers);
    }
}
