package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents the result of a participant in an outright event.
 */
public final class OutrightParticipantResult {
    /**
     * The unique identifier of the participant.
     */
    public int participantId;

    /**
     * The name of the participant.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The result of the participant.
     */
    public int result;
}