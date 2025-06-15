package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.StatusDescription;
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
     * The clock associated with the scoreboard.
     * This can be {@code null} if not set.
     */
    @Nullable public Clock clock;

    /**
     * The results associated with the scoreboard.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Result> results;
}