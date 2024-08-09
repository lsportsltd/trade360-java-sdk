package com.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import java.time.ZonedDateTime;

import jakarta.annotation.Nullable;

public record GetFixturesRequestDto(
    @Nullable ZonedDateTime fromDate,
    @Nullable ZonedDateTime toDate,
    @Nullable Iterable<Integer> sports,
    @Nullable Iterable<Integer> locations,
    @Nullable Iterable<Integer> fixtures,
    @Nullable Iterable<Integer> leagues) {
};
