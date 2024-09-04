package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;

public interface SnapshotApiClientFactory {

    InPlayApiClient createInPlayApiClient(PackageCredentials settings);

    PreMatchApiClient createPreMatchApiClient(PackageCredentials settings);

}