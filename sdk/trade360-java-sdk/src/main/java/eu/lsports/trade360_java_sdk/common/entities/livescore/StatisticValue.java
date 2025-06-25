package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code StatisticValue} class represents a statistic value of players in a live score event.
 */
public class StatisticValue {

    /**
     * The ID of the statistic value.
     */
    public int id;

    /**
     * The name of the statistic value.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The value of the statistic.
     * This can be {@code null} if not set.
     */
    @Nullable public String value;
}
