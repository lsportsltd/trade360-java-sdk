package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code SportMetadata} record represents metadata for a sport.
 *
 * @param id the ID of the sport
 * @param name the name of the sport
 */
public final record SportMetadata(int id, @Nullable String name) {
}