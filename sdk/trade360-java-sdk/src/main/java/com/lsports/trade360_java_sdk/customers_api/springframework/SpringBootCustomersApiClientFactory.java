package com.lsports.trade360_java_sdk.customers_api.springframework;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.customers_api.JacksonCustomersApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.reactive.function.client.WebClient;

public class SpringBootCustomersApiClientFactory implements CustomersApiClientFactory {
    private final WebClient.Builder builder;

    public SpringBootCustomersApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public PackageDistributionApiClientImplementation createPackageDistributionHttpClient(@Nullable String baseUrl, @Nullable PackageCredentials packageCredentials) {
        var serializer = new JacksonCustomersApiSerializer(packageCredentials);
        var client = new SpringBootCustomersApiRestClient(builder, serializer, baseUrl);
        return new PackageDistributionApiClientImplementation(client);
    }
}
