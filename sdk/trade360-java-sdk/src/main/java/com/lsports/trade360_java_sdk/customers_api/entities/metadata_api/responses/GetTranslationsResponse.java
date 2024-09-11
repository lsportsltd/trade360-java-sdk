package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.util.Map;

import jakarta.annotation.Nullable;

public final record GetTranslationsResponse(
    @Nullable Map<Integer, Iterable<TranslationElement>> sports,
    @Nullable Map<Integer, Iterable<TranslationElement>> locations,
    @Nullable Map<Integer, Iterable<TranslationElement>> leagues,
    @Nullable Map<Integer, Iterable<TranslationElement>> markets,
    @Nullable Map<Integer, Iterable<TranslationElement>> participants
) {
}