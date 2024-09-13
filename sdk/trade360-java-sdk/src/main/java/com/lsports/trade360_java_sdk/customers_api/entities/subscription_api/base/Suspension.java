package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public record Suspension(
    Boolean succeeded,
    int sportId,
    @Nullable Integer locationId, // Nullable to handle missing values
    int competitionId,
    @Nullable Integer fixtureId, // Nullable to handle missing values
    LocalDateTime creationDate,
    @Nullable Iterable<Market> markets) {
}
