package com.lsports.trade360_java_sdk.common.configuration;

import jakarta.annotation.Nullable;

public class Trade360Settings {
    @Nullable public String customersApiBaseUrl;

    @Nullable public String snapshotApiBaseUrl;

    @Nullable public PackageCredentials InplayPackageCredentials;

    @Nullable public PackageCredentials PrematchPackageCredentials;
}
