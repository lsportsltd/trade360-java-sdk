package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorType;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class DangerIndicatorTest {
    @Test
    void testFieldAssignment() {
        DangerIndicator indicator = new DangerIndicator();
        indicator.type = DangerIndicatorType.GENERAL;
        indicator.status = DangerIndicatorStatus.SAFE;
        indicator.lastUpdate = Instant.parse("2024-06-01T12:00:00Z");
        assertEquals(DangerIndicatorType.GENERAL, indicator.type);
        assertEquals(DangerIndicatorStatus.SAFE, indicator.status);
        assertEquals(Instant.parse("2024-06-01T12:00:00Z"), indicator.lastUpdate);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        DangerIndicator indicator = new DangerIndicator();
        assertNull(indicator.type);
        assertNull(indicator.status);
        assertNull(indicator.lastUpdate);
    }
} 