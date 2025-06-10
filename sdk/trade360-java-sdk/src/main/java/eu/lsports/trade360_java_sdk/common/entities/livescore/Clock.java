package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

import eu.lsports.trade360_java_sdk.common.entities.enums.ClockStatus;

/**
 * The {@code Clock} class represents a clock in a livescore event.
 */
public class Clock {

    /**
     * The status of the clock.
     * This can be {@code null} if not set.
     */
    @Nullable public ClockStatus status;

    /**
     * The number of seconds on the clock.
     */
    public int seconds;
}
