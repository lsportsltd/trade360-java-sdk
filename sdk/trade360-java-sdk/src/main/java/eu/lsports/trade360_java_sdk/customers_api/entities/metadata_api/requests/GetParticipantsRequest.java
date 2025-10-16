package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import eu.lsports.trade360_java_sdk.common.entities.enums.AgeCategory;
import eu.lsports.trade360_java_sdk.common.entities.enums.Gender;
import eu.lsports.trade360_java_sdk.common.entities.enums.ParticipantType;
import jakarta.annotation.Nullable;

/**
 * The {@code GetParticipantsRequest} record represents a request to retrieve Participants based on various criteria.
 *
 * @param filter object containing the relevant request filters
 * @param page the page number for pagination
 * @param pageSize the number of items per page
 * @see GetParticipantsRequest.ParticipantsFilter
 */
public final record GetParticipantsRequest(ParticipantsFilter filter, @Nullable Integer page, @Nullable Integer pageSize) {
    /**
     * The {@code ParticipantsFilter} record represents a request filters in order retrieve Participants based on various criteria.
     *
     * @param ids The IDs of the participants to filter by
     * @param sportIds The IDs of the sports to filter participants by
     * @param locationIds The IDs of the locations to filter participants by
     * @param name The partial name match to filter participants by
     * @param gender The gender to filter participants by
     * @param ageCategory The age category to filter participants by
     * @param type The participant type to filter by
     */
    public final record ParticipantsFilter(
            @Nullable Iterable<Integer> ids,
            @Nullable Iterable<Integer> sportIds,
            @Nullable Iterable<Integer> locationIds,
            @Nullable String name,
            @Nullable Gender gender,
            @Nullable AgeCategory ageCategory,
            @Nullable ParticipantType type) {
    }
}

