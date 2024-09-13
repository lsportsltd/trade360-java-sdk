package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

public final record GetTranslationsRequest(
    Iterable<Integer> languages,
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leagueIds,
    @Nullable Iterable<Integer> marketIds,
    @Nullable Iterable<Integer> participantIds) {
}