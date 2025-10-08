package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code StateMetadata} record represents metadata for a state or province.
 *
 * @param stateId the ID of the state
 * @param name the name of the state
 * @param country the country where the state is located
 */
public final record StateMetadata(int stateId, String name, @Nullable IdNamePair country) {
}