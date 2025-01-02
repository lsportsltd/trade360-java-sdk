package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code Participant} record represents a participant in a fixture or competition.
 *
 * @param participantId the ID of the participant
 * @param participantName the name of the participant
 */
public final record Participant(
    int participantId,
    @Nullable String participantName) {
}