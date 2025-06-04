package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionTypeTest {
    @Test
    void testEnumValues() {
        for (CompetitionType type : CompetitionType.values()) {
            assertNotNull(type);
            assertEquals(type, CompetitionType.valueOf(type.name()));
        }
    }
} 