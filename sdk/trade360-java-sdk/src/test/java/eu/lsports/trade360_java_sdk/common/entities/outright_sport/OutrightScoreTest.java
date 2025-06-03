package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OutrightScoreTest {
    @Test
    void testFieldAssignment() {
        OutrightScore score = new OutrightScore();
        OutrightParticipantResult result = new OutrightParticipantResult();
        score.participantResults = List.of(result);
        score.status = FixtureStatus.FINISHED;
        assertNotNull(score.participantResults);
        assertEquals(FixtureStatus.FINISHED, score.status);
    }
} 