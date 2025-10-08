package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code VenueMetadata} record represents metadata for a venue.
 *
 * @param venueId the ID of the venue
 * @param name the name of the venue
 * @param country the country where the venue is located
 * @param state the state where the venue is located
 * @param city the city where the venue is located
 */
public final record VenueMetadata(int venueId, String name, @Nullable IdNamePair country, @Nullable IdNamePair state, @Nullable IdNamePair city) {
}
