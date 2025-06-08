package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightScoreEventTest {
    @Test
    void testInstantiation() {
        OutrightScoreEvent event = new OutrightScoreEvent();
        assertNotNull(event);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightScoreEvent event = new OutrightScoreEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.outrightScore);

        event.fixtureId = 42;
        OutrightScore score = new OutrightScore();
        event.outrightScore = score;
        assertEquals(42, event.fixtureId);
        assertSame(score, event.outrightScore);
    }
} 