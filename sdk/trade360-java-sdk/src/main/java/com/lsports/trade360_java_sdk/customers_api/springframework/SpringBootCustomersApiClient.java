package com.lsports.trade360_java_sdk.customers_api.springframework;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.springframework.SpringBootApiRestClient;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.MetadataApiClientImplementation;
import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClient;
import com.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;

import java.net.URI;

import org.springframework.web.reactive.function.client.WebClient;

public class SpringBootCustomersApiClient implements CustomersApiClient {
    private final WebClient.Builder builder;

    public SpringBootCustomersApiClient(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public PackageDistributionApiClientImplementation createPackageDistributionHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new PackageDistributionApiClientImplementation(client);
    }

    @Override
    public MetadataApiClient createMetadataHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new MetadataApiClientImplementation(client);
    }

    private SpringBootApiRestClient createInternalClient(URI baseUrl, PackageCredentials packageCredentials) {
        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(builder, serializer, baseUrl);
        return client;
    }
}
