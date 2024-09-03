package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.ApiSettings;

public interface ApiClientFactory {

    PackageDistributionApiClientImplementation createInPlayApiClient(ApiSettings settings);

    PackageDistributionApiClientImplementation createPreMatchApiClient(ApiSettings settings);
}