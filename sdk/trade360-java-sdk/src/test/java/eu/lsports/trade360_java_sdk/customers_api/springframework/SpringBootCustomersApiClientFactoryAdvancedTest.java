package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.MetadataApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.PackageQueryApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.SubscriptionApiClientImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootCustomersApiClientFactoryAdvancedTest {

    @Test
    void testCreatePackageDistributionApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageDistributionApiClientImplementation client = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateMetadataApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        MetadataApiClientImplementation client = (MetadataApiClientImplementation) factory.createMetadataHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        SubscriptionApiClientImplementation client = (SubscriptionApiClientImplementation) factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageQueryApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(mockBuilder);
        
        PackageQueryApiClientImplementation client = (PackageQueryApiClientImplementation) factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithNullBuilder() {
        SpringBootCustomersApiClientFactory factory = new SpringBootCustomersApiClientFactory(null);
        assertNotNull(factory);
    }
}
