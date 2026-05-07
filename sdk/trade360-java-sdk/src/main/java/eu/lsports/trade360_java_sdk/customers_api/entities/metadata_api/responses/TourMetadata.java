package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code TourMetadata} record represents metadata for a tour.
 *
 * @param tourId the ID of the tour
 * @param tourName the name of the tour
 * @param sportId the ID of the sport associated with this tour
 * @param sportName the name of the sport associated with this tour
 */
public final record TourMetadata(int tourId, @Nullable String tourName, @Nullable Integer sportId, @Nullable String sportName) {
}


