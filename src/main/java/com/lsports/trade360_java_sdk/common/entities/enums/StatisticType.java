package com.lsports.trade360_java_sdk.common.entities.enums;

public enum StatisticType {
    NOTSET (0),
    CORNERS (1),
    SHOTSONTARGET (2),
    SHOTSOFFTARGET (3),
    ATTACKS (4),
    DANGEROUSATTACKS (5),
    YELLOWCARD (6),
    REDCARD (7),
    PENALTIES (8),
    GOAL (9),
    SUBSTITUTIONS (10),
    POSSESSION (11),
    FOULS (12),
    FREEKICKS (13),
    GOALKICKS (14),
    OFFSIDES (15),
    BLOCKEDSHOTS (16),
    THROWINS (17),
    WOODWORKSHOTS (18),
    CLEARANCE (19),
    ACES (20),
    DOUBLEFAULTS (21),
    SERVICEPOINTS (22),
    BREAKPOINTS (23),
    OWNGOAL (24),
    PENALTYGOAL (25),
    SCORE (27),
    TWOPOINTS (28),
    PCT (29),
    THREEPOINTS (30),
    TIMEOUTS (31),
    FREETHROWS (32),
    HITS (33),
    FIRSTSERVEWINS (34),
    BALL (35),
    WICKETTAKEN (36),
    WIDEBALL (37),
    NOBALL (38),
    LEGBYE (39),
    MISSEDPENALTY (40),
    CARDS (41);

    private int value;

    StatisticType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
