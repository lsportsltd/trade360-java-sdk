package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusDescriptionEnumTest {

    @Test
    void testEnumValues() {
        StatusDescription[] values = StatusDescription.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (StatusDescription status : StatusDescription.values()) {
            assertEquals(status, StatusDescription.valueOf(status.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(StatusDescription.values());
    }

    @Test
    void testEnumConsistency() {
        StatusDescription[] values1 = StatusDescription.values();
        StatusDescription[] values2 = StatusDescription.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
