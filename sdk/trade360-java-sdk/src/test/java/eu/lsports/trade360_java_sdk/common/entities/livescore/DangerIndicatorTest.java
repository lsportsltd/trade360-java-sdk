package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DangerIndicatorTest {
    @Test
    void testFieldAssignment() {
        DangerIndicator indicator = new DangerIndicator();
        indicator.type = DangerIndicatorType.GENERAL;
        indicator.status = DangerIndicatorStatus.SAFE;
        indicator.lastUpdate = LocalDateTime.of(2024, 6, 1, 12, 0);
        assertEquals(DangerIndicatorType.GENERAL, indicator.type);
        assertEquals(DangerIndicatorStatus.SAFE, indicator.status);
        assertEquals(LocalDateTime.of(2024, 6, 1, 12, 0), indicator.lastUpdate);
    }
} 