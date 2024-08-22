package com.lsports.trade360_java_sdk.snapshot_api.http;

import com.lsports.trade360_java_sdk.common.models.MessageHeader;

import jakarta.annotation.Nullable;

public record ApiResponse<T>(@Nullable MessageHeader header, @Nullable T body) {
}