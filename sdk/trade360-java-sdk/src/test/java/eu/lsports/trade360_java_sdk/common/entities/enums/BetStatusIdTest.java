package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BetStatusIdTest {
    @Test
    void testEnumValues() {
        for (BetStatusId status : BetStatusId.values()) {
            assertNotNull(status);
            assertEquals(status, BetStatusId.valueOf(status.name()));
        }
    }

    @Test
    void testValueOf() {
        for (BetStatusId status : BetStatusId.values()) {
            assertEquals(status, BetStatusId.valueOf(status.name()));
        }
    }

    @Test
    void testGetValueMatchesStatusWithoutClosed() {
        assertEquals(BetStatus.OPEN.getValue(), BetStatusId.OPEN.getValue());
        assertEquals(BetStatus.SUSPENDED.getValue(), BetStatusId.SUSPENDED.getValue());
        assertEquals(BetStatus.SETTLED.getValue(), BetStatusId.SETTLED.getValue());
        assertEquals(4, BetStatusId.CLOSED.getValue());
    }
}
