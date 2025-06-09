package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixtureStatusEnumTest {

    @Test
    void testEnumValues() {
        FixtureStatus[] values = FixtureStatus.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (FixtureStatus status : FixtureStatus.values()) {
            assertEquals(status, FixtureStatus.valueOf(status.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(FixtureStatus.values());
    }

    @Test
    void testEnumConsistency() {
        FixtureStatus[] values1 = FixtureStatus.values();
        FixtureStatus[] values2 = FixtureStatus.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
