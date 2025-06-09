package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DangerIndicatorTypeEnumTest {

    @Test
    void testEnumValues() {
        DangerIndicatorType[] values = DangerIndicatorType.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (DangerIndicatorType type : DangerIndicatorType.values()) {
            assertEquals(type, DangerIndicatorType.valueOf(type.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(DangerIndicatorType.values());
    }

    @Test
    void testEnumConsistency() {
        DangerIndicatorType[] values1 = DangerIndicatorType.values();
        DangerIndicatorType[] values2 = DangerIndicatorType.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
