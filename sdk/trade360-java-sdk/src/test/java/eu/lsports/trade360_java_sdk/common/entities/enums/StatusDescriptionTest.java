package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusDescriptionTest {
    @Test
    void testEnumValues() {
        for (StatusDescription desc : StatusDescription.values()) {
            assertNotNull(desc);
            assertEquals(desc, StatusDescription.valueOf(desc.name()));
        }
    }

    @Test
    void testGetValue() {
        assertEquals(0, StatusDescription.NONE.getValue());
        assertEquals(1, StatusDescription.HT.getValue());
        assertEquals(2, StatusDescription.OTHT.getValue());
        assertEquals(3, StatusDescription.HOME_RETIRED.getValue());
        assertEquals(4, StatusDescription.AWAY_RETIRED.getValue());
        assertEquals(5, StatusDescription.LOST_COVERAGE.getValue());
        assertEquals(6, StatusDescription.MEDICAL_TIMEOUT.getValue());
        assertEquals(7, StatusDescription.TIMEOUT_HOME_TEAM.getValue());
        assertEquals(8, StatusDescription.TIMEOUT_AWAY_TEAM.getValue());
        assertEquals(9, StatusDescription.TIMEOUT.getValue());
        assertEquals(10, StatusDescription.HOME_WALKOVER.getValue());
        assertEquals(11, StatusDescription.AWAY_WALKOVER.getValue());
        assertEquals(12, StatusDescription.MATCH_DRAWN.getValue());
        assertEquals(13, StatusDescription.BALL_MARK_INSPECTION.getValue());
        assertEquals(14, StatusDescription.BALL_MARK_INSPECTION_COMPLETED.getValue());
        assertEquals(15, StatusDescription.CORRECTION_MODE.getValue());
        assertEquals(16, StatusDescription.MEDICAL_TREATMENT.getValue());
        assertEquals(17, StatusDescription.TREATMENT_COMPLETED.getValue());
        assertEquals(18, StatusDescription.PLAYERS_ON_COURT.getValue());
        assertEquals(19, StatusDescription.TOSS_STARTED.getValue());
        assertEquals(20, StatusDescription.TOSS_SAVED.getValue());
        assertEquals(21, StatusDescription.UMPIRE_ON_COURT.getValue());
        assertEquals(22, StatusDescription.UMPIRING_CANCELLED.getValue());
        assertEquals(23, StatusDescription.WARM_UP_STARTED.getValue());
        assertEquals(24, StatusDescription.WARM_UP_COMPLETED.getValue());
        assertEquals(25, StatusDescription.MEDICAL_TIMEOUT_CANCELLED.getValue());
        assertEquals(26, StatusDescription.MEDICAL_TIMEOUT_COMPLETED.getValue());
        assertEquals(27, StatusDescription.SWAP_SERVER.getValue());
        assertEquals(28, StatusDescription.SWAP_RECEIVER.getValue());
        assertEquals(29, StatusDescription.CHALLENGE_STARTED.getValue());
        assertEquals(30, StatusDescription.CHALLENGE_COMPLETED.getValue());
        assertEquals(31, StatusDescription.CHALLENGE_CANCELLED.getValue());
        assertEquals(32, StatusDescription.TOILET_BREAK_STARTED.getValue());
        assertEquals(33, StatusDescription.TOILET_BREAK_COMPLETED.getValue());
        assertEquals(34, StatusDescription.TOILET_BREAK_CANCELLED.getValue());
        assertEquals(35, StatusDescription.EVALUATION_STARTED.getValue());
        assertEquals(36, StatusDescription.TIME_PENALTY.getValue());
        assertEquals(37, StatusDescription.GAME_PENALTY.getValue());
        assertEquals(38, StatusDescription.COACHING_STARTED.getValue());
        assertEquals(39, StatusDescription.COACHING_CANCELLED.getValue());
        assertEquals(40, StatusDescription.COACHING_COMPLETED.getValue());
        assertEquals(41, StatusDescription.BREAKTIME.getValue());
        assertEquals(42, StatusDescription.POINT_STARTED.getValue());
        assertEquals(43, StatusDescription.POINT_SCORED.getValue());
        assertEquals(44, StatusDescription.POINT_FAULT.getValue());
        assertEquals(45, StatusDescription.POINT_REPLAYED.getValue());
    }
} 