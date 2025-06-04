package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageTypeTest {
    @Test
    void testEnumValues() {
        for (PackageType type : PackageType.values()) {
            assertNotNull(type);
            assertEquals(type, PackageType.valueOf(type.name()));
        }
    }
} 