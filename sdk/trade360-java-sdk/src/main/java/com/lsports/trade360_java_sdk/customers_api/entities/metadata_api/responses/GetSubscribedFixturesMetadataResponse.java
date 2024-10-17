package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSubscribedFixturesMetadataResponse} record represents a response containing metadata for subscribed fixtures.
 *
 * @param subscribedFixtures the metadata for the subscribed fixtures
 * @see FixtureMetadata
 */
public final record GetSubscribedFixturesMetadataResponse(
    @Nullable Iterable<FixtureMetadata> subscribedFixtures) {
}