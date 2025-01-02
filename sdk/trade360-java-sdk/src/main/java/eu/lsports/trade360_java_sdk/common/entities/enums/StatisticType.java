package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code StatisticType} enum represents the various types of statistics.
 */
public enum StatisticType {
    /**
     * Type indicating that the statistic type is not set.
     */
    NOT_SET(0),

    /**
     * Type indicating number of corners.
     */
    CORNERS(1),

    /**
     * Type indicating shots on target.
     */
    SHOTS_ON_TARGET(2),

    /**
     * Type indicating shots off target.
     */
    SHOTS_OFF_TARGET(3),

    /**
     * Type indicating attacks.
     */
    ATTACKS(4),

    /**
     * Type indicating dangerous attacks.
     */
    DANGEROUS_ATTACKS(5),

    /**
     * Type indicating yellow cards.
     */
    YELLOW_CARD(6),

    /**
     * Type indicating red cards.
     */
    RED_CARD(7),

    /**
     * Type indicating penalties.
     */
    PENALTIES(8),

    /**
     * Type indicating goals.
     */
    GOAL(9),

    /**
     * Type indicating substitutions.
     */
    SUBSTITUTIONS(10),

    /**
     * Type indicating possession.
     */
    POSSESSION(11),

    /**
     * Type indicating fouls.
     */
    FOULS(12),

    /**
     * Type indicating free kicks.
     */
    FREE_KICKS(13),

    /**
     * Type indicating goal kicks.
     */
    GOAL_KICKS(14),

    /**
     * Type indicating offsides.
     */
    OFFSIDES(15),

    /**
     * Type indicating blocked shots.
     */
    BLOCKED_SHOTS(16),

    /**
     * Type indicating throw-ins.
     */
    THROW_INS(17),

    /**
     * Type indicating woodwork shots.
     */
    WOODWORK_SHOTS(18),

    /**
     * Type indicating clearances.
     */
    CLEARANCE(19),

    /**
     * Type indicating aces.
     */
    ACES(20),

    /**
     * Type indicating double faults.
     */
    DOUBLE_FAULTS(21),

    /**
     * Type indicating service points.
     */
    SERVICE_POINTS(22),

    /**
     * Type indicating breakpoints.
     */
    BREAKPOINTS(23),

    /**
     * Type indicating own goals.
     */
    OWN_GOAL(24),

    /**
     * Type indicating penalty goals.
     */
    PENALTY_GOAL(25),

    /**
     * Type indicating scores.
     */
    SCORE(27),

    /**
     * Type indicating two points.
     */
    TWO_POINTS(28),

    /**
     * Type indicating percentage.
     */
    PCT(29),

    /**
     * Type indicating three points.
     */
    THREE_POINTS(30),

    /**
     * Type indicating timeouts.
     */
    TIMEOUTS(31),

    /**
     * Type indicating free throws.
     */
    FREE_THROWS(32),

    /**
     * Type indicating hits.
     */
    HITS(33),

    /**
     * Type indicating first serve wins.
     */
    FIRST_SERVE_WINS(34),

    /**
     * Type indicating balls.
     */
    BALL(35),

    /**
     * Type indicating wickets taken.
     */
    WICKET_TAKEN(36),

    /**
     * Type indicating wide balls.
     */
    WIDE_BALL(37),

    /**
     * Type indicating no balls.
     */
    NO_BALL(38),

    /**
     * Type indicating leg byes.
     */
    LEG_BYE(39),

    /**
     * Type indicating missed penalties.
     */
    MISSED_PENALTY(40),

    /**
     * Type indicating cards.
     */
    CARDS(41);

    private int value;

    StatisticType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the statistic type.
     *
     * @return the integer value representing the statistic type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
