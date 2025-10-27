package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.AgeCategory;
import eu.lsports.trade360_java_sdk.common.entities.enums.Gender;
import eu.lsports.trade360_java_sdk.common.entities.enums.ParticipantType;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetParticipantsResponseTest {

    @Test
    void testConstructorWithParticipants() {
        ParticipantMetadata participant1 = new ParticipantMetadata(
            1, 1, 5, "Team 1", Gender.MEN, AgeCategory.REGULAR, ParticipantType.CLUB
        );
        ParticipantMetadata participant2 = new ParticipantMetadata(
            2, 1, 5, "Team 2", Gender.WOMEN, AgeCategory.YOUTH, ParticipantType.NATIONAL
        );
        Iterable<ParticipantMetadata> participants = Arrays.asList(participant1, participant2);
        
        GetParticipantsResponse response = new GetParticipantsResponse();
        response.data = participants;
        response.totalItems = 150;
        
        assertNotNull(response);
        assertEquals(participants, response.data);
        assertEquals(150, response.totalItems);
    }

    @Test
    void testConstructorWithNullParticipants() {
        GetParticipantsResponse response = new GetParticipantsResponse();
        response.data = null;
        response.totalItems = 0;
        
        assertNotNull(response);
        assertNull(response.data);
        assertEquals(0, response.totalItems);
    }

    @Test
    void testConstructorWithEmptyParticipants() {
        Iterable<ParticipantMetadata> emptyParticipants = Collections.emptyList();
        
        GetParticipantsResponse response = new GetParticipantsResponse();
        response.data = emptyParticipants;
        response.totalItems = 0;
        
        assertNotNull(response);
        assertEquals(emptyParticipants, response.data);
        assertEquals(0, response.totalItems);
    }

    @Test
    void testConstructorWithSingleParticipant() {
        ParticipantMetadata participant = new ParticipantMetadata(
            100, 1, 5, "Single Team", Gender.MIX, null, ParticipantType.INDIVIDUAL
        );
        Iterable<ParticipantMetadata> participants = Arrays.asList(participant);
        
        GetParticipantsResponse response = new GetParticipantsResponse();
        response.data = participants;
        response.totalItems = 1;
        
        assertNotNull(response);
        assertEquals(participants, response.data);
        assertEquals(1, ((java.util.List<ParticipantMetadata>) response.data).size());
        assertEquals(1, response.totalItems);
    }

    @Test
    void testDataFieldAssignment() {
        GetParticipantsResponse response = new GetParticipantsResponse();
        
        assertNull(response.data);
        assertEquals(0, response.totalItems);
        
        ParticipantMetadata participant = new ParticipantMetadata(
            1, 1, 5, "Team", Gender.MEN, AgeCategory.REGULAR, ParticipantType.CLUB
        );
        Iterable<ParticipantMetadata> participants = Arrays.asList(participant);
        
        response.data = participants;
        response.totalItems = 100;
        
        assertEquals(participants, response.data);
        assertEquals(100, response.totalItems);
    }

    @Test
    void testTotalItemsGreaterThanDataSize() {
        ParticipantMetadata participant1 = new ParticipantMetadata(
            1, 1, 5, "Team 1", Gender.MEN, null, null
        );
        ParticipantMetadata participant2 = new ParticipantMetadata(
            2, 1, 5, "Team 2", Gender.WOMEN, null, null
        );
        Iterable<ParticipantMetadata> participants = Arrays.asList(participant1, participant2);
        
        GetParticipantsResponse response = new GetParticipantsResponse();
        response.data = participants;
        response.totalItems = 500;
        
        assertEquals(2, ((java.util.List<ParticipantMetadata>) response.data).size());
        assertEquals(500, response.totalItems);
    }
}

