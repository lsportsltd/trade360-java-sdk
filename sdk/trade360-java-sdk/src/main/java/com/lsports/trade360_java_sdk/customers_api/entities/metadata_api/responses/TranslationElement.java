package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

public final record TranslationElement(
    int languageId,
    @Nullable String value) {
}