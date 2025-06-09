package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BetStatusEnumTest {

    @Test
    void testEnumValues() {
        BetStatus[] values = BetStatus.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (BetStatus status : BetStatus.values()) {
            assertEquals(status, BetStatus.valueOf(status.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(BetStatus.values());
    }

    @Test
    void testEnumConsistency() {
        BetStatus[] values1 = BetStatus.values();
        BetStatus[] values2 = BetStatus.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
