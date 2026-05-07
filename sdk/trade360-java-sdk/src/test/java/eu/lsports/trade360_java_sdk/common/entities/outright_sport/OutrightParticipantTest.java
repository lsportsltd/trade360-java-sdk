package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixturePlayer;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightParticipantTest {
    @Test
    void testInstantiation() {
        OutrightParticipant participant = new OutrightParticipant();
        assertNotNull(participant);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightParticipant participant = new OutrightParticipant();
        assertEquals(0, participant.id);
        assertNull(participant.name);
        assertNull(participant.position);
        assertNull(participant.rotationId);
        assertEquals(-1, participant.isActive);
        assertNull(participant.extraData);

        participant.id = 10;
        participant.name = "John Doe";
        participant.position = "Forward";
        participant.rotationId = 99;
        participant.isActive = 1;
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        participant.extraData = Arrays.asList(nvp);

        assertEquals(10, participant.id);
        assertEquals("John Doe", participant.name);
        assertEquals("Forward", participant.position);
        assertEquals(99, participant.rotationId);
        assertEquals(1, participant.isActive);
        assertNotNull(participant.extraData);
    }

    @Test
    void testNewParticipantFields() {
        OutrightParticipant participant = new OutrightParticipant();

        assertNull(participant.form);
        assertNull(participant.formation);
        assertNull(participant.fixturePlayers);
        assertNull(participant.gender);
        assertNull(participant.ageCategory);
        assertNull(participant.type);

        participant.form = "WWDLW";
        participant.formation = "4-3-3";
        FixturePlayer player = new FixturePlayer();
        player.playerId = 1;
        player.shirtNumber = "10";
        participant.fixturePlayers = Arrays.asList(player);
        participant.gender = 1;
        participant.ageCategory = 2;
        participant.type = 3;

        assertEquals("WWDLW", participant.form);
        assertEquals("4-3-3", participant.formation);
        assertNotNull(participant.fixturePlayers);
        assertEquals(1, participant.gender);
        assertEquals(2, participant.ageCategory);
        assertEquals(3, participant.type);
    }

    @Test
    void testNewParticipantFieldsNullability() {
        OutrightParticipant participant = new OutrightParticipant();

        participant.form = null;
        participant.formation = null;
        participant.fixturePlayers = null;
        participant.gender = null;
        participant.ageCategory = null;
        participant.type = null;

        assertNull(participant.form);
        assertNull(participant.formation);
        assertNull(participant.fixturePlayers);
        assertNull(participant.gender);
        assertNull(participant.ageCategory);
        assertNull(participant.type);
    }
} 