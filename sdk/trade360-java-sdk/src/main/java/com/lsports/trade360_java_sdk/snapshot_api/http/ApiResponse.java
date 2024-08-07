package com.lsports.trade360_java_sdk.snapshot_api.http;

import org.springframework.lang.Nullable;

import com.lsports.trade360_java_sdk.common.models.MessageHeader;


public record ApiResponse<T>(@Nullable MessageHeader header, @Nullable T body) {
}