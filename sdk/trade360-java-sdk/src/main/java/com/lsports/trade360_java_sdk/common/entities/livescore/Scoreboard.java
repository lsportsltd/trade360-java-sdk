package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.*;
import jakarta.annotation.Nullable;

/**
 * The {@code Scoreboard} class represents the scoreboard information for a live score event.
 */
public class Scoreboard {

    /**
     * The status of the fixture.
     */
    public FixtureStatus status;

    /**
     * The description of the status.
     */
    public StatusDescription description;

    /**
     * The current period of the fixture.
     */
    public int currentPeriod;

    /**
     * The time associated with the scoreboard.
     * This can be {@code null} if not set.
     */
    @Nullable public String time;

    /**
     * The results associated with the scoreboard.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Result> results;
}