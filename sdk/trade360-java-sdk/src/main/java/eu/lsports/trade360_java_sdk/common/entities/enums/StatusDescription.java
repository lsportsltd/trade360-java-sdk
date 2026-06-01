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
    POINT_REPLAYED(45),

    /**
     * Status indicating break after first period.
     */
    BREAK_AFTER_1ST_PERIOD(46),

    /**
     * Status indicating break after second period.
     */
    BREAK_AFTER_2ND_PERIOD(47),

    /**
     * Status indicating break after third period.
     */
    BREAK_AFTER_3RD_PERIOD(48),

    /**
     * Status indicating break after fourth period.
     */
    BREAK_AFTER_4TH_PERIOD(49),

    /**
     * Status indicating break after fifth period.
     */
    BREAK_AFTER_5TH_PERIOD(50),

    /**
     * Status indicating break after sixth period.
     */
    BREAK_AFTER_6TH_PERIOD(51),

    /**
     * Status indicating break after first overtime.
     */
    BREAK_AFTER_1ST_OVERTIME(52),

    /**
     * Status indicating break after second overtime.
     */
    BREAK_AFTER_2ND_OVERTIME(53),

    /**
     * Status indicating break after third overtime.
     */
    BREAK_AFTER_3RD_OVERTIME(54),

    /**
     * Status indicating waiting for extra time.
     */
    WAITING_FOR_EXTRA_TIME(55),

    /**
     * Status indicating waiting for penalties.
     */
    WAITING_FOR_PENALTIES(56),

    /**
     * Status indicating entering extra time.
     */
    ENTERING_EXTRA_TIME(57),

    /**
     * Status indicating extra time break.
     */
    EXTRA_TIME_BREAK(58),

    /**
     * Status indicating entering penalty shootout.
     */
    ENTERING_PENALTY_SHOOTOUT(59),

    /**
     * Status indicating fighter 1 disqualification.
     */
    FIGHTER_1_DISQUALIFICATION(60),

    /**
     * Status indicating fighter 2 disqualification.
     */
    FIGHTER_2_DISQUALIFICATION(61),

    /**
     * Status indicating fighter 1 majority decision.
     */
    FIGHTER_1_MAJORITY_DECISION(62),

    /**
     * Status indicating fighter 2 majority decision.
     */
    FIGHTER_2_MAJORITY_DECISION(63),

    /**
     * Status indicating fighter 1 unanimous decision.
     */
    FIGHTER_1_UNANIMOUS_DECISION(64),

    /**
     * Status indicating fighter 2 unanimous decision.
     */
    FIGHTER_2_UNANIMOUS_DECISION(65),

    /**
     * Status indicating fighter 1 submission.
     */
    FIGHTER_1_SUBMISSION(66),

    /**
     * Status indicating fighter 2 submission.
     */
    FIGHTER_2_SUBMISSION(67),

    /**
     * Status indicating fighter 1 KO/TKO.
     */
    FIGHTER_1_KO_TKO(68),

    /**
     * Status indicating fighter 2 KO/TKO.
     */
    FIGHTER_2_KO_TKO(69),

    /**
     * Status indicating no contest.
     */
    NO_CONTEST(70),

    /**
     * Status indicating top position.
     */
    TOP(71),

    /**
     * Status indicating bottom position.
     */
    BOTTOM(72);

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
