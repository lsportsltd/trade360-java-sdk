package com.lsports.trade360_java_sdk.customers_api.springframework;

import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import com.lsports.trade360_java_sdk.customers_api.interfaces.ApiClientFactory;
import com.lsports.trade360_java_sdk.snapshot_api.*;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.ApiSettings;
import org.springframework.web.reactive.function.client.WebClient;

public class SpringBootApiClientFactory implements ApiClientFactory {
    private final WebClient.Builder builder;

    public SpringBootApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public PackageDistributionApiClientImplementation createInPlayApiClient(ApiSettings settings) {
        var serializer = new JacksonSnapshotApiSerializer(settings);
        var client = new SpringBootApiRestClient(builder, serializer, settings);
        return new PackageDistributionApiClientImplementation(client) {
        };
    }

    @Override
    public PackageDistributionApiClientImplementation createPreMatchApiClient(ApiSettings settings) {
        var serializer = new JacksonSnapshotApiSerializer(settings);
        var client = new SpringBootApiRestClient(builder, serializer, settings);
        return new PackageDistributionApiClientImplementation(client);
    }
}
