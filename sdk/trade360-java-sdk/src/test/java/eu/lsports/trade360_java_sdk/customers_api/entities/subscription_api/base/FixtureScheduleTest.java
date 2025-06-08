package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FixtureScheduleTest {
    @Test
    void testFields() {
        FixtureSchedule fs = new FixtureSchedule();
        fs.fixtureId = 1;
        fs.startDate = LocalDateTime.now();
        fs.lastUpdate = LocalDateTime.now();
        fs.status = 2;
        assertEquals(1, fs.fixtureId);
        assertNotNull(fs.startDate);
        assertNotNull(fs.lastUpdate);
        assertEquals(2, fs.status);
    }
} 