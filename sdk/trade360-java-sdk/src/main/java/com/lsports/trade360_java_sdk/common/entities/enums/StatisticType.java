package com.lsports.trade360_java_sdk.common.entities.enums;

public enum StatisticType {
    NO_TSET (0),
    CORNERS (1),
    SHOTS_ON_TARGET (2),
    SHOTS_OFF_TARGET (3),
    ATTACKS (4),
    DANGEROUS_ATTACKS (5),
    YELLOW_CARD (6),
    RED_CARD (7),
    PENALTIES (8),
    GOAL (9),
    SUBSTITUTIONS (10),
    POSSESSION (11),
    FOULS (12),
    FREE_KICKS (13),
    GOAL_KICKS (14),
    OFFSIDES (15),
    BLOCKED_SHOTS (16),
    THROW_INS (17),
    WOODWORK_SHOTS (18),
    CLEARANCE (19),
    ACES (20),
    DOUBLE_FAULTS (21),
    SERVICE_POINTS (22),
    BREAKPOINTS (23),
    OWN_GOAL (24),
    PENALTY_GOAL (25),
    SCORE (27),
    TWO_POINTS (28),
    PCT (29),
    THREE_POINTS (30),
    TIMEOUTS (31),
    FREE_THROWS (32),
    HITS (33),
    FIRST_SERVE_WINS (34),
    BALL (35),
    WICKET_TAKEN (36),
    WIDE_BALL (37),
    NO_BALL (38),
    LEG_BYE (39),
    MISSED_PENALTY (40),
    CARDS (41);

    private int value;

    StatisticType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
