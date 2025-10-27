package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.AgeCategory;
import eu.lsports.trade360_java_sdk.common.entities.enums.Gender;
import eu.lsports.trade360_java_sdk.common.entities.enums.ParticipantType;
import jakarta.annotation.Nullable;

/**
 * The {@code ParticipantMetadata} record represents metadata for a participant.
 *
 * @param id the ID of the participant
 * @param sportId the ID of the sport
 * @param locationId the ID of the location
 * @param name the name of the participant
 * @param gender the gender of the participant
 * @param ageCategory the age category of the participant
 * @param type the type of the participant
 */
public final record ParticipantMetadata(
        int id,
        int sportId,
        int locationId,
        String name,
        @Nullable Gender gender,
        @Nullable AgeCategory ageCategory,
        @Nullable ParticipantType type) {
}

