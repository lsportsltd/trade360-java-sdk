package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code StatusDescription} enum represents the various status descriptions.
 */
public enum StatusDescription {
    /**
     * Status indicating none.
     */
    NONE(0),

    /**
     * Status indicating half-time.
     */
    HT(1),

    /**
     * Status indicating overtime half-time.
     */
    OTHT(2),

    /**
     * Status indicating home team retired.
     */
    HOME_RETIRED(3),

    /**
     * Status indicating away team retired.
     */
    AWAY_RETIRED(4),

    /**
     * Status indicating lost coverage.
     */
    LOST_COVERAGE(5),

    /**
     * Status indicating medical timeout.
     */
    MEDICAL_TIMEOUT(6),

    /**
     * Status indicating timeout for home team.
     */
    TIMEOUT_HOME_TEAM(7),

    /**
     * Status indicating timeout for away team.
     */
    TIMEOUT_AWAY_TEAM(8),

    /**
     * Status indicating timeout.
     */
    TIMEOUT(9),

    /**
     * Status indicating home team walkover.
     */
    HOME_WALKOVER(10),

    /**
     * Status indicating away team walkover.
     */
    AWAY_WALKOVER(11),

    /**
     * Status indicating match drawn.
     */
    MATCH_DRAWN(12),

    /**
     * Status indicating ball mark inspection.
     */
    BALL_MARK_INSPECTION(13),

    /**
     * Status indicating ball mark inspection completed.
     */
    BALL_MARK_INSPECTION_COMPLETED(14),

    /**
     * Status indicating correction mode.
     */
    CORRECTION_MODE(15),

    /**
     * Status indicating medical treatment.
     */
    MEDICAL_TREATMENT(16),

    /**
     * Status indicating treatment completed.
     */
    TREATMENT_COMPLETED(17),

    /**
     * Status indicating players on court.
     */
    PLAYERS_ON_COURT(18),

    /**
     * Status indicating toss started.
     */
    TOSS_STARTED(19),

    /**
     * Status indicating toss saved.
     */
    TOSS_SAVED(20),

    /**
     * Status indicating umpire on court.
     */
    UMPIRE_ON_COURT(21),

    /**
     * Status indicating umpiring cancelled.
     */
    UMPIRING_CANCELLED(22),

    /**
     * Status indicating warm up started.
     */
    WARM_UP_STARTED(23),

    /**
     * Status indicating warm up completed.
     */
    WARM_UP_COMPLETED(24),

    /**
     * Status indicating medical timeout cancelled.
     */
    MEDICAL_TIMEOUT_CANCELLED(25),

    /**
     * Status indicating medical timeout completed.
     */
    MEDICAL_TIMEOUT_COMPLETED(26),

    /**
     * Status indicating swap server.
     */
    SWAP_SERVER(27),

    /**
     * Status indicating swap receiver.
     */
    SWAP_RECEIVER(28),

    /**
     * Status indicating challenge started.
     */
    CHALLENGE_STARTED(29),

    /**
     * Status indicating challenge completed.
     */
    CHALLENGE_COMPLETED(30),

    /**
     * Status indicating challenge cancelled.
     */
    CHALLENGE_CANCELLED(31),

    /**
     * Status indicating toilet break started.
     */
    TOILET_BREAK_STARTED(32),

    /**
     * Status indicating toilet break completed.
     */
    TOILET_BREAK_COMPLETED(33),

    /**
     * Status indicating toilet break cancelled.
     */
    TOILET_BREAK_CANCELLED(34),

    /**
     * Status indicating evaluation started.
     */
    EVALUATION_STARTED(35),

    /**
     * Status indicating time penalty.
     */
    TIME_PENALTY(36),

    /**
     * Status indicating game penalty.
     */
    GAME_PENALTY(37),

    /**
     * Status indicating coaching started.
     */
    COACHING_STARTED(38),

    /**
     * Status indicating coaching cancelled.
     */
    COACHING_CANCELLED(39),

    /**
     * Status indicating coaching completed.
     */
    COACHING_COMPLETED(40),

    /**
     * Status indicating breaktime.
     */
    BREAKTIME(41),

    /**
     * Status indicating point started.
     */
    POINT_STARTED(42),

    /**
     * Status indicating point scored.
     */
    POINT_SCORED(43),

    /**
     * Status indicating point fault.
     */
    POINT_FAULT(44),

    /**
     * Status indicating point replayed.
     */
    POINT_REPLAYED(45);

    private int value;

    StatusDescription(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the status description.
     *
     * @return the integer value representing the status description
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
