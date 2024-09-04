package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import jakarta.annotation.Nullable;

public interface CustomersApiClientFactory {
    PackageDistributionApiClientImplementation createPackageDistributionHttpClient(@Nullable String baseUrl, @Nullable PackageCredentials packageCredentials);
}