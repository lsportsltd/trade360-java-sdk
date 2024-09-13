package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

public final record GetSubscribedFixturesResponse(
    @Nullable Iterable<Integer> fixtures) {
}