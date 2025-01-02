package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightParticipantResult;

import jakarta.annotation.Nullable;

/**
 * Represents an outright score element.
 */
public final class OutrightScoreElement {
    /**
     * The collection of participant results associated with the outright score element.
     * Can be {@code null}.
     * 
     * @see OutrightParticipantResult
     */
    @Nullable public Iterable<OutrightParticipantResult> participantResults;

    /**
     * The status of the outright score element.
     * 
     * @see FixtureStatus
     */
    public FixtureStatus status;
}