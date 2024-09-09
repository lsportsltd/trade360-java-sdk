package com.lsports.trade360_java_sdk.snapshot_api;

import java.net.URI;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;

public interface SnapshotApiClientFactory {

    InPlaySnapshotApiClient createInPlayApiClient(URI baseUrl, PackageCredentials credentials);

    PreMatchSnapshotApiClient createPreMatchApiClient(URI baseUrl, PackageCredentials credentials);

}