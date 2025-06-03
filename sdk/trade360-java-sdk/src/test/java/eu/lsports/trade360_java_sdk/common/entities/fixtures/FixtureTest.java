package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FixtureTest {
    @Test
    void testFieldAssignment() {
        Fixture fixture = new Fixture();
        fixture.externalFixtureId = "ext123";
        fixture.lastUpdate = LocalDateTime.now();
        fixture.status = FixtureStatus.NSY;
        fixture.startDate = LocalDateTime.of(2024, 6, 1, 12, 0);
        assertEquals("ext123", fixture.externalFixtureId);
        assertNotNull(fixture.lastUpdate);
        assertEquals(FixtureStatus.NSY, fixture.status);
        assertEquals(LocalDateTime.of(2024, 6, 1, 12, 0), fixture.startDate);
    }
} 