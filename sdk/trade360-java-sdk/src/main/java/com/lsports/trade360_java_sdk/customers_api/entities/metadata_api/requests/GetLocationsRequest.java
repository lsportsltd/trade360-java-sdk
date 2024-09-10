package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

public final record GetLocationsRequest(@Nullable Integer languageId) {

    public GetLocationsRequest() {
        this(null);
    }
}