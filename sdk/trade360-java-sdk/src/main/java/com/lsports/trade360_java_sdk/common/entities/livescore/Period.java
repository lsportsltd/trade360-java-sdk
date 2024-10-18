package com.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Period} class represents a period in a live score event.
 */
public class Period {

    /**
     * The type of the period.
     */
    public int type;

    /**
     * Indicates whether the period is finished.
     */
    public boolean isFinished;

    /**
     * Indicates whether the period is confirmed.
     */
    public boolean isConfirmed;

    /**
     * The results associated with the period.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Result> results;

    /**
     * The incidents associated with the period.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Incident> incidents;

    /**
     * The sub-periods associated with the period.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Period> subPeriods;

    /**
     * The sequence number of the period.
     */
    public int sequenceNumber;
}