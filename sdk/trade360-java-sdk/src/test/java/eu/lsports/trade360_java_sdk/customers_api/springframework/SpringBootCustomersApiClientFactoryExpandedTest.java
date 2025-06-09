package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

class SpringBootCustomersApiClientFactoryExpandedTest {

    @Test
    void testCreatePackageDistributionHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageDistributionApiClientImplementation client = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateMetadataHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClient client = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        SubscriptionApiClient client = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageQueryApiHttpClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageQueryApiClient client = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testFactoryConstructor() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        assertNotNull(factory);
    }

    @Test
    void testCreateAllClientTypes() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageDistributionApiClientImplementation packageDistClient = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        MetadataApiClient metadataClient = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        SubscriptionApiClient subscriptionClient = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        PackageQueryApiClient packageQueryClient = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(packageDistClient);
        assertNotNull(metadataClient);
        assertNotNull(subscriptionClient);
        assertNotNull(packageQueryClient);
    }
}
