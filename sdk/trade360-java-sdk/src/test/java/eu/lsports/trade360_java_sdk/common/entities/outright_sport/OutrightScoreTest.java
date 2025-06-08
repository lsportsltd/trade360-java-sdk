package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightScoreTest {
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightScore score = new OutrightScore();
        assertNull(score.participantResults);
        assertNull(score.status);

        score.participantResults = null;
        score.status = FixtureStatus.FINISHED;
        assertNull(score.participantResults);
        assertEquals(FixtureStatus.FINISHED, score.status);
    }
} 