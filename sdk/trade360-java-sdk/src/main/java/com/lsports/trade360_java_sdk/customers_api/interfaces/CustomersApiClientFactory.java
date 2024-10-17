package com.lsports.trade360_java_sdk.customers_api.interfaces;

import java.net.URI;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;

/**
 * Factory interface for creating API clients.
 */
public interface CustomersApiClientFactory {
    /**
     * Creates a client for the Package Distribution API.
     *
     * @param baseUrl The base URL of the API
     * @param packageCredentials The credentials for the package
     * @return A new instance of {@link PackageDistributionApiClientImplementation}
     */
    PackageDistributionApiClientImplementation createPackageDistributionHttpClient(URI baseUrl, PackageCredentials packageCredentials);

    /**
     * Creates a client for the Metadata API.
     *
     * @param baseUrl The base URL of the API
     * @param packageCredentials The credentials for the package
     * @return A new instance of {@link MetadataApiClient}
     */
    MetadataApiClient createMetadataHttpClient(URI baseUrl, PackageCredentials packageCredentials);

    /**
     * Creates a client for the Subscription API.
     *
     * @param baseUrl The base URL of the API
     * @param packageCredentials The credentials for the package
     * @return A new instance of {@link SubscriptionApiClient}
     */
    SubscriptionApiClient createSubscriptionApiHttpClient(URI baseUrl, PackageCredentials packageCredentials);
}