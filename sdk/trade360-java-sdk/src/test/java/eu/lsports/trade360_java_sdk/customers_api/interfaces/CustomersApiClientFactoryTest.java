package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CustomersApiClientFactoryTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements CustomersApiClientFactory {
                public eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation createPackageDistributionHttpClient(java.net.URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials packageCredentials) { return null; }
                public MetadataApiClient createMetadataHttpClient(java.net.URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials packageCredentials) { return null; }
                public SubscriptionApiClient createSubscriptionApiHttpClient(java.net.URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials packageCredentials) { return null; }
                public PackageQueryApiClient createPackageQueryApiHttpClient(java.net.URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials packageCredentials) { return null; }
            }
            new Impl();
        });
    }
} 