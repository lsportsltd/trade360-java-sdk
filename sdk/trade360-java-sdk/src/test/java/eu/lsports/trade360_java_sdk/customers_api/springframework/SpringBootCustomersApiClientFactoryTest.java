package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpringBootCustomersApiClientFactoryTest {

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private PackageCredentials packageCredentials;

    private SpringBootCustomersApiClientFactory factory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.codecs(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeaders(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(mock(WebClient.class));
        factory = new SpringBootCustomersApiClientFactory(webClientBuilder);
    }

    @Test
    void testConstructor() {
        SpringBootCustomersApiClientFactory testFactory = new SpringBootCustomersApiClientFactory(webClientBuilder);
        assertNotNull(testFactory);
    }

    @Test
    void testCreatePackageDistributionHttpClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageDistributionApiClientImplementation client = factory.createPackageDistributionHttpClient(baseUrl, packageCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateMetadataHttpClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        MetadataApiClient client = factory.createMetadataHttpClient(baseUrl, packageCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiHttpClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        SubscriptionApiClient client = factory.createSubscriptionApiHttpClient(baseUrl, packageCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageQueryApiHttpClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageQueryApiClient client = factory.createPackageQueryApiHttpClient(baseUrl, packageCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateClientsWithNullCredentials() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageDistributionApiClientImplementation packageDistClient = factory.createPackageDistributionHttpClient(baseUrl, null);
        MetadataApiClient metadataClient = factory.createMetadataHttpClient(baseUrl, null);
        SubscriptionApiClient subscriptionClient = factory.createSubscriptionApiHttpClient(baseUrl, null);
        PackageQueryApiClient queryClient = factory.createPackageQueryApiHttpClient(baseUrl, null);
        
        assertNotNull(packageDistClient);
        assertNotNull(metadataClient);
        assertNotNull(subscriptionClient);
        assertNotNull(queryClient);
    }

    @Test
    void testCreateClientsWithDifferentUrls() {
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        
        PackageDistributionApiClientImplementation client1 = factory.createPackageDistributionHttpClient(baseUrl1, packageCredentials);
        MetadataApiClient client2 = factory.createMetadataHttpClient(baseUrl2, packageCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }
}   