package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

public final record GetSportsRequest(@Nullable Integer languageId) {

    public GetSportsRequest() {
        this(null);
    }
}
