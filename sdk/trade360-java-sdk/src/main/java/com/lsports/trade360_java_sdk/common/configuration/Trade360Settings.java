package com.lsports.trade360_java_sdk.common.configuration;

import jakarta.annotation.Nullable;

/**
 * The {@code Trade360Settings} class holds the configuration settings for the Trade360 SDK.
 * It includes the base URLs for the customers and snapshot APIs, as well as the credentials for in-play and pre-match packages.
 */
public class Trade360Settings {
    /**
     * The base URL for the customers API.
     */
    @Nullable public String customersApiBaseUrl;

    /**
     * The base URL for the snapshot API.
     */
    @Nullable public String snapshotApiBaseUrl;

    /**
     * The credentials for the in-play package.
     */
    @Nullable public PackageCredentials InplayPackageCredentials;

    /**
     * The credentials for the pre-match package.
     */
    @Nullable public PackageCredentials PrematchPackageCredentials;
}
