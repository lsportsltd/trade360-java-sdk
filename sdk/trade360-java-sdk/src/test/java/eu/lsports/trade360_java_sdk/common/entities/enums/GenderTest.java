package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void testGenderValues() {
        assertEquals(1, Gender.MEN.getValue());
        assertEquals(2, Gender.WOMEN.getValue());
        assertEquals(3, Gender.MIX.getValue());
    }

    @Test
    void testGenderEnumCount() {
        assertEquals(3, Gender.values().length);
    }

    @Test
    void testGenderValueOf() {
        assertEquals(Gender.MEN, Gender.valueOf("MEN"));
        assertEquals(Gender.WOMEN, Gender.valueOf("WOMEN"));
        assertEquals(Gender.MIX, Gender.valueOf("MIX"));
    }
}

