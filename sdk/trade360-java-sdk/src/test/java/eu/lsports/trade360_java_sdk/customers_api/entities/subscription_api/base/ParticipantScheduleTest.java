package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantScheduleTest {
    @Test
    void testFields() {
        ParticipantSchedule ps = new ParticipantSchedule();
        ps.id = 1;
        ps.position = 2;
        ps.name = "Participant";
        assertEquals(1, ps.id);
        assertEquals(2, ps.position);
        assertEquals("Participant", ps.name);
    }
} 