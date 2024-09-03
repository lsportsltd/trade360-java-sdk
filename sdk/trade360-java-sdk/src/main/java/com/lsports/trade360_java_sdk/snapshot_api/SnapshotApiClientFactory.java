package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.configuration.ApiSettings;

public interface SnapshotApiClientFactory {

    InPlayApiClient createInPlayApiClient(ApiSettings settings);

    PreMatchApiClient createPreMatchApiClient(ApiSettings settings);

}