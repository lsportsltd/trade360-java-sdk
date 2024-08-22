package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;

public interface SnapshotApiClientFactory {

    InPlaySnapshotApiClient createInPlayApiClient(SnapshotApiSettings settings);

    PreMatchSnapshotApiClient createPreMatchApiClient(SnapshotApiSettings settings);

}