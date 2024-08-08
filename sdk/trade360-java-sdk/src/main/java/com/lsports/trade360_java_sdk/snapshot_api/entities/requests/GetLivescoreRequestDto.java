package com.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import java.time.ZonedDateTime;

import org.springframework.lang.Nullable;

public record GetLivescoreRequestDto(
    @Nullable ZonedDateTime fromDate,
    @Nullable ZonedDateTime toDate,
    @Nullable Iterable<Integer> sports,
    @Nullable Iterable<Integer> locations,
    @Nullable Iterable<Integer> fixtures,
    @Nullable Iterable<Integer> leagues) {
}