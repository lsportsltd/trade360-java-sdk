package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportTest {
    @Test
    void testFieldAssignment() {
        Sport sport = new Sport();
        assertNotNull(sport);
    }
} 