package com.lsports.trade360_java_sdk.common.entities.enums;

public enum StatisticType {
    NotSet (0),
    Corners (1),
    ShotsOnTarget (2),
    ShotsOffTarget (3),
    Attacks (4),
    DangerousAttacks (5),
    YellowCard (6),
    RedCard (7),
    Penalties (8),
    Goal (9),
    Substitutions (10),
    Possession (11),
    Fouls (12),
    FreeKicks (13),
    GoalKicks (14),
    Offsides (15),
    BlockedShots (16),
    ThrowIns (17),
    WoodworkShots (18),
    Clearance (19),
    Aces (20),
    DoubleFaults (21),
    ServicePoints (22),
    BreakPoints (23),
    OwnGoal (24),
    PenaltyGoal (25),
    Score (27),
    TwoPoints (28),
    PCT (29),
    ThreePoints (30),
    TimeOuts (31),
    FreeThrows (32),
    Hits (33),
    FirstServeWins (34),
    Ball (35),
    WicketTaken (36),
    WideBall (37),
    NoBall (38),
    LegBye (39),
    MissedPenalty (40),
    Cards (41);

    private int value;

    StatisticType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
