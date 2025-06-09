package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.MetadataApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageQueryApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.SubscriptionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootCustomersApiClientFactoryComprehensiveTest {

    @Test
    void testCreateMetadataHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient client = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageDistributionHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageDistributionApiClientImplementation client = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageQueryApiHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageQueryApiClient client = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        SubscriptionApiClient client = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithNullBuilder() {
        assertDoesNotThrow(() -> {
            new SpringBootCustomersApiClientFactory(null);
        });
    }

    @Test
    void testCreateMetadataHttpClientWithNullCredentials() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient client = factory.createMetadataHttpClient(baseUrl, null);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageDistributionHttpClientWithNullUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        assertThrows(Exception.class, () -> {
            factory.createPackageDistributionHttpClient(null, mockCredentials);
        });
    }

    @Test
    void testCreatePackageQueryHttpClientWithNullCredentials() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageQueryApiClient client = factory.createPackageQueryApiHttpClient(baseUrl, null);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiHttpClientWithNullUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        assertThrows(Exception.class, () -> {
            factory.createSubscriptionApiHttpClient(null, mockCredentials);
        });
    }

    @Test
    void testMultipleClientCreation() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient metadataClient1 = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        MetadataApiClient metadataClient2 = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        PackageDistributionApiClientImplementation packageDistClient1 = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        PackageDistributionApiClientImplementation packageDistClient2 = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(metadataClient1);
        assertNotNull(metadataClient2);
        assertNotNull(packageDistClient1);
        assertNotNull(packageDistClient2);
        
        assertNotSame(metadataClient1, metadataClient2);
        assertNotSame(packageDistClient1, packageDistClient2);
    }

    @Test
    void testDifferentApiUrls() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl1 = URI.create("https://customers1.example.com");
        URI baseUrl2 = URI.create("https://customers2.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient client1 = factory.createMetadataHttpClient(baseUrl1, mockCredentials);
        MetadataApiClient client2 = factory.createMetadataHttpClient(baseUrl2, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
    }

    @Test
    void testAllClientTypesCreation() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://customers.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient metadataClient = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        PackageDistributionApiClientImplementation packageDistClient = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        PackageQueryApiClient packageQueryClient = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        SubscriptionApiClient subscriptionClient = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(metadataClient);
        assertNotNull(packageDistClient);
        assertNotNull(packageQueryClient);
        assertNotNull(subscriptionClient);
    }
}
