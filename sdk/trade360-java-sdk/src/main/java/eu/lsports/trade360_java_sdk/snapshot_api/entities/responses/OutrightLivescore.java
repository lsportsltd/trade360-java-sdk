package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import jakarta.annotation.Nullable;

/**
 * Represents a live score for an outright event.
 */
public final class OutrightLivescore {
    /**
     * The collection of participant results associated with the live score.
     * Can be {@code null}.
     * 
     * @see OutrightParticipantResult
     */
    @Nullable public Iterable<OutrightParticipantResult> participantResults;

    /**
     * The status of the live score.
     * 
     * @see FixtureStatus
     */
    public FixtureStatus status;
}