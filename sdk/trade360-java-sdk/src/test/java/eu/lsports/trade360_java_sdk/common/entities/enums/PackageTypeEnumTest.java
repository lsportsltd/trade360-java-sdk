package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageTypeEnumTest {

    @Test
    void testEnumValues() {
        PackageType[] values = PackageType.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (PackageType packageType : PackageType.values()) {
            assertEquals(packageType, PackageType.valueOf(packageType.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(PackageType.values());
    }

    @Test
    void testEnumConsistency() {
        PackageType[] values1 = PackageType.values();
        PackageType[] values2 = PackageType.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
