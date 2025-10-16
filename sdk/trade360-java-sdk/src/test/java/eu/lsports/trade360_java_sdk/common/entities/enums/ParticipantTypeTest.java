package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTypeTest {

    @Test
    void testParticipantTypeValues() {
        assertEquals(1, ParticipantType.CLUB.getValue());
        assertEquals(2, ParticipantType.NATIONAL.getValue());
        assertEquals(3, ParticipantType.INDIVIDUAL.getValue());
        assertEquals(4, ParticipantType.VIRTUAL.getValue());
        assertEquals(5, ParticipantType.ESPORTS.getValue());
        assertEquals(6, ParticipantType.VIRTUREAL.getValue());
        assertEquals(7, ParticipantType.DOUBLES.getValue());
    }

    @Test
    void testParticipantTypeEnumCount() {
        assertEquals(7, ParticipantType.values().length);
    }

    @Test
    void testParticipantTypeValueOf() {
        assertEquals(ParticipantType.CLUB, ParticipantType.valueOf("CLUB"));
        assertEquals(ParticipantType.NATIONAL, ParticipantType.valueOf("NATIONAL"));
        assertEquals(ParticipantType.INDIVIDUAL, ParticipantType.valueOf("INDIVIDUAL"));
        assertEquals(ParticipantType.VIRTUAL, ParticipantType.valueOf("VIRTUAL"));
        assertEquals(ParticipantType.ESPORTS, ParticipantType.valueOf("ESPORTS"));
        assertEquals(ParticipantType.VIRTUREAL, ParticipantType.valueOf("VIRTUREAL"));
        assertEquals(ParticipantType.DOUBLES, ParticipantType.valueOf("DOUBLES"));
    }
}

