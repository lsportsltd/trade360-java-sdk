package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.util.Map;

import jakarta.annotation.Nullable;

/**
 * The {@code GetTranslationsResponse} record represents a response containing translations for various entities.
 *
 * @param sports the translations for sports
 * @param locations the translations for locations
 * @param leagues the translations for leagues
 * @param markets the translations for markets
 * @param participants the translations for participants
 * @see TranslationElement
 */
public final record GetTranslationsResponse(
    @Nullable Map<Integer, Iterable<TranslationElement>> sports,
    @Nullable Map<Integer, Iterable<TranslationElement>> locations,
    @Nullable Map<Integer, Iterable<TranslationElement>> leagues,
    @Nullable Map<Integer, Iterable<TranslationElement>> markets,
    @Nullable Map<Integer, Iterable<TranslationElement>> participants) {
}