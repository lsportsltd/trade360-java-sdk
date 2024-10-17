package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightParticipant;

import jakarta.annotation.Nullable;

/**
 * Represents an outright score element.
 */
public final class OutrightScoreElement {
    /**
     * The collection of participant results associated with the outright score element.
     * Can be {@code null}.
     * 
     * @see OutrightParticipant
     */
    @Nullable public Iterable<OutrightParticipant> participantResults;

    /**
     * The status of the outright score element.
     * 
     * @see FixtureStatus
     */
    public FixtureStatus status;
}