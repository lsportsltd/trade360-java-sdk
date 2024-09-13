package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nullable;

public final record GetSubscribedFixturesMetadataRequest(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") @Nullable LocalDate fromDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") @Nullable LocalDate toDate) {
}