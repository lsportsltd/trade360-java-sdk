package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.common.springframework.SpringBootApiRestClient;
import eu.lsports.trade360_java_sdk.common.serialization.JacksonApiSerializer;
import eu.lsports.trade360_java_sdk.customers_api.MetadataApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageQueryApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.SubscriptionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;

import java.net.URI;

import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Factory for creating Spring Boot API clients.
 */
public class SpringBootCustomersApiClientFactory implements CustomersApiClientFactory {
    private final WebClient.Builder builder;

    /**
     * Constructs a new factory with the given WebClient builder.
     *
     * @param builder The WebClient builder
     */
    public SpringBootCustomersApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PackageDistributionApiClientImplementation createPackageDistributionHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new PackageDistributionApiClientImplementation(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataApiClient createMetadataHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new MetadataApiClientImplementation(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriptionApiClient createSubscriptionApiHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new SubscriptionApiClientImplementation(client);
    }

    @Override
    public PackageQueryApiClient createPackageQueryApiHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
        var client = this.createInternalClient(baseUrl, packageCredentials);
        return new PackageQueryApiClientImplementation(client);
    }
    private SpringBootApiRestClient createInternalClient(URI baseUrl, PackageCredentials packageCredentials) {
        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(builder, serializer, baseUrl);
        return client;
    }
}