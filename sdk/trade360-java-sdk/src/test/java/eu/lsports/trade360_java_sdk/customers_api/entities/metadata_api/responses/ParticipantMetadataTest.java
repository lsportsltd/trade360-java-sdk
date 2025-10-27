package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.AgeCategory;
import eu.lsports.trade360_java_sdk.common.entities.enums.Gender;
import eu.lsports.trade360_java_sdk.common.entities.enums.ParticipantType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantMetadataTest {

    @Test
    void testConstructorWithAllFields() {
        ParticipantMetadata metadata = new ParticipantMetadata(
            123,
            1,
            5,
            "Team Name",
            Gender.MEN,
            AgeCategory.YOUTH,
            ParticipantType.CLUB
        );
        
        assertNotNull(metadata);
        assertEquals(123, metadata.id());
        assertEquals(1, metadata.sportId());
        assertEquals(5, metadata.locationId());
        assertEquals("Team Name", metadata.name());
        assertEquals(Gender.MEN, metadata.gender());
        assertEquals(AgeCategory.YOUTH, metadata.ageCategory());
        assertEquals(ParticipantType.CLUB, metadata.type());
    }

    @Test
    void testConstructorWithNullableFieldsAsNull() {
        ParticipantMetadata metadata = new ParticipantMetadata(
            123,
            1,
            5,
            "Team Name",
            null,
            null,
            null
        );
        
        assertNotNull(metadata);
        assertEquals(123, metadata.id());
        assertEquals(1, metadata.sportId());
        assertEquals(5, metadata.locationId());
        assertEquals("Team Name", metadata.name());
        assertNull(metadata.gender());
        assertNull(metadata.ageCategory());
        assertNull(metadata.type());
    }

    @Test
    void testWithDifferentEnumValues() {
        ParticipantMetadata metadata1 = new ParticipantMetadata(
            1, 1, 1, "Team 1", Gender.WOMEN, AgeCategory.REGULAR, ParticipantType.NATIONAL
        );
        ParticipantMetadata metadata2 = new ParticipantMetadata(
            2, 2, 2, "Team 2", Gender.MIX, AgeCategory.RESERVES, ParticipantType.VIRTUAL
        );
        
        assertEquals(Gender.WOMEN, metadata1.gender());
        assertEquals(AgeCategory.REGULAR, metadata1.ageCategory());
        assertEquals(ParticipantType.NATIONAL, metadata1.type());
        
        assertEquals(Gender.MIX, metadata2.gender());
        assertEquals(AgeCategory.RESERVES, metadata2.ageCategory());
        assertEquals(ParticipantType.VIRTUAL, metadata2.type());
    }

    @Test
    void testRecordEquality() {
        ParticipantMetadata metadata1 = new ParticipantMetadata(
            123, 1, 5, "Team Name", Gender.MEN, AgeCategory.YOUTH, ParticipantType.CLUB
        );
        ParticipantMetadata metadata2 = new ParticipantMetadata(
            123, 1, 5, "Team Name", Gender.MEN, AgeCategory.YOUTH, ParticipantType.CLUB
        );
        
        assertEquals(metadata1, metadata2);
        assertEquals(metadata1.hashCode(), metadata2.hashCode());
    }

    @Test
    void testRecordInequality() {
        ParticipantMetadata metadata1 = new ParticipantMetadata(
            123, 1, 5, "Team Name", Gender.MEN, AgeCategory.YOUTH, ParticipantType.CLUB
        );
        ParticipantMetadata metadata2 = new ParticipantMetadata(
            456, 1, 5, "Team Name", Gender.MEN, AgeCategory.YOUTH, ParticipantType.CLUB
        );
        
        assertNotEquals(metadata1, metadata2);
    }
}

