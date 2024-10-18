package com.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Statistic} class represents a statistic in a live score event.
 */
public class Statistic {

    /**
     * The type of the statistic.
     * This can be {@code null} if not set.
     */
    @Nullable public Integer type;

    /**
     * The results associated with the statistic.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Result> results;

    /**
     * The incidents associated with the statistic.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Incident> incidents;
}