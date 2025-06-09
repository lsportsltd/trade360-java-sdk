package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProviderOddsTypeEnumTest {

    @Test
    void testEnumValues() {
        ProviderOddsType[] values = ProviderOddsType.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (ProviderOddsType oddsType : ProviderOddsType.values()) {
            assertEquals(oddsType, ProviderOddsType.valueOf(oddsType.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(ProviderOddsType.values());
    }

    @Test
    void testEnumConsistency() {
        ProviderOddsType[] values1 = ProviderOddsType.values();
        ProviderOddsType[] values2 = ProviderOddsType.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
