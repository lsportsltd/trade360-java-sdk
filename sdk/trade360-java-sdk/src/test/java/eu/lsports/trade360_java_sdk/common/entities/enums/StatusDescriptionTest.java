package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusDescriptionTest {
    @Test
    void testEnumValues() {
        for (StatusDescription desc : StatusDescription.values()) {
            assertNotNull(desc);
            assertEquals(desc, StatusDescription.valueOf(desc.name()));
        }
    }

    @Test
    void testGetValue() {
        assertEquals(0, StatusDescription.NONE.getValue());
        assertEquals(1, StatusDescription.HT.getValue());
        assertEquals(2, StatusDescription.OTHT.getValue());
        // ... add more if desired
    }
} 