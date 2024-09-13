package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import jakarta.annotation.Nullable;

public final record FixtureMetadata(
    int fixtureId,
    @Nullable String fixtureName,
    LocalDateTime startDate,
    LocalDateTime lastUpdate,
    int sportId,
    int locationId,
    int leagueId,
    FixtureStatus fixtureStatus,
    @Nullable Iterable<Participant> participants) {
}