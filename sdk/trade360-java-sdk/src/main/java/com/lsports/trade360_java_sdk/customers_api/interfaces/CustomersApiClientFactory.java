package com.lsports.trade360_java_sdk.customers_api.interfaces;

import java.net.URI;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;

public interface CustomersApiClientFactory {
    PackageDistributionApiClientImplementation createPackageDistributionHttpClient(URI baseUrl, PackageCredentials packageCredentials);

    MetadataApiClient createMetadataHttpClient(URI baseUrl, PackageCredentials packageCredentials);

    SubscriptionApiClient createSubscriptionApiHttpClient(URI baseUrl, PackageCredentials packageCredentials);
}