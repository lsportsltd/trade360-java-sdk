package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code CityMetadata} record represents metadata for a city.
 *
 * @param cityId the ID of the city
 * @param name the name of the city
 * @param state the state where the city is located
 * @param country the country where the city is located
 */
public final record CityMetadata(int cityId, String name, @Nullable IdNamePair state, @Nullable IdNamePair country) {
}