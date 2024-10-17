package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code TranslationElement} record represents a translation element for a specific language.
 *
 * @param languageId the ID of the language
 * @param value the translated value
 */
public final record TranslationElement(
    int languageId,
    @Nullable String value) {
}