package com.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;

public final record GetSnapshotRequest(
    @Nullable LocalDateTime timestamp,
    @Nullable LocalDateTime fromDate,
    @Nullable LocalDateTime toDate,
    @Nullable Iterable<Integer> sports,
    @Nullable Iterable<Integer> locations,
    @Nullable Iterable<Integer> leagues,
    @Nullable Iterable<Integer> tournaments,
    @Nullable Iterable<Integer> fixtures,
    @Nullable Iterable<Integer> markets) {
}