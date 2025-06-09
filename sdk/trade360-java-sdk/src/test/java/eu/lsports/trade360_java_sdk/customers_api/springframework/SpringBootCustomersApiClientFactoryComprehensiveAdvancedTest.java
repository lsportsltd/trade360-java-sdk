package eu.lsports.trade360_java_sdk.customers_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootCustomersApiClientFactoryComprehensiveAdvancedTest {

    @Mock
    private WebClient.Builder mockWebClientBuilder;

    @Mock
    private PackageCredentials mockCredentials;

    private SpringBootCustomersApiClientFactory factory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        WebClient mockWebClient = mock(WebClient.class);
        when(mockWebClientBuilder.baseUrl(anyString())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.codecs(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.defaultHeaders(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.build()).thenReturn(mockWebClient);
        
        factory = new SpringBootCustomersApiClientFactory(mockWebClientBuilder);
    }

    @Test
    void testFactoryConstructor() {
        assertNotNull(factory);
    }

    @Test
    void testCreatePackageDistributionHttpClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageDistributionApiClientImplementation client = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateMetadataHttpClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        MetadataApiClient client = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateSubscriptionApiHttpClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        SubscriptionApiClient client = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePackageQueryApiHttpClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageQueryApiClient client = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateAllClientTypesWithHttpsUrl() {
        URI httpsUrl = URI.create("https://secure.api.example.com:8443");
        
        PackageDistributionApiClientImplementation packageDistClient = factory.createPackageDistributionHttpClient(httpsUrl, mockCredentials);
        MetadataApiClient metadataClient = factory.createMetadataHttpClient(httpsUrl, mockCredentials);
        SubscriptionApiClient subscriptionClient = factory.createSubscriptionApiHttpClient(httpsUrl, mockCredentials);
        PackageQueryApiClient packageQueryClient = factory.createPackageQueryApiHttpClient(httpsUrl, mockCredentials);
        
        assertNotNull(packageDistClient);
        assertNotNull(metadataClient);
        assertNotNull(subscriptionClient);
        assertNotNull(packageQueryClient);
    }

    @Test
    void testCreateClientsWithDifferentCredentials() {
        URI baseUrl = URI.create("https://api.example.com");
        PackageCredentials credentials1 = mock(PackageCredentials.class);
        PackageCredentials credentials2 = mock(PackageCredentials.class);
        
        PackageDistributionApiClientImplementation client1 = factory.createPackageDistributionHttpClient(baseUrl, credentials1);
        PackageDistributionApiClientImplementation client2 = factory.createPackageDistributionHttpClient(baseUrl, credentials2);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultiplePackageDistributionClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageDistributionApiClientImplementation client1 = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        PackageDistributionApiClientImplementation client2 = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultipleMetadataClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        MetadataApiClient client1 = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        MetadataApiClient client2 = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultipleSubscriptionClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        SubscriptionApiClient client1 = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        SubscriptionApiClient client2 = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultiplePackageQueryClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageQueryApiClient client1 = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        PackageQueryApiClient client2 = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateClientsWithDifferentUrls() {
        URI url1 = URI.create("https://api1.example.com");
        URI url2 = URI.create("https://api2.example.com");
        
        PackageDistributionApiClientImplementation packageDistClient1 = factory.createPackageDistributionHttpClient(url1, mockCredentials);
        PackageDistributionApiClientImplementation packageDistClient2 = factory.createPackageDistributionHttpClient(url2, mockCredentials);
        MetadataApiClient metadataClient1 = factory.createMetadataHttpClient(url1, mockCredentials);
        MetadataApiClient metadataClient2 = factory.createMetadataHttpClient(url2, mockCredentials);
        
        assertNotNull(packageDistClient1);
        assertNotNull(packageDistClient2);
        assertNotNull(metadataClient1);
        assertNotNull(metadataClient2);
        assertNotSame(packageDistClient1, packageDistClient2);
        assertNotSame(metadataClient1, metadataClient2);
    }

    @Test
    void testFactoryWithDifferentWebClientBuilders() {
        WebClient.Builder builder1 = mock(WebClient.Builder.class);
        WebClient.Builder builder2 = mock(WebClient.Builder.class);
        
        SpringBootCustomersApiClientFactory factory1 = new SpringBootCustomersApiClientFactory(builder1);
        SpringBootCustomersApiClientFactory factory2 = new SpringBootCustomersApiClientFactory(builder2);
        
        assertNotNull(factory1);
        assertNotNull(factory2);
        assertNotSame(factory1, factory2);
    }

    @Test
    void testCreateAllClientTypesFromSameFactory() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PackageDistributionApiClientImplementation packageDistClient = factory.createPackageDistributionHttpClient(baseUrl, mockCredentials);
        MetadataApiClient metadataClient = factory.createMetadataHttpClient(baseUrl, mockCredentials);
        SubscriptionApiClient subscriptionClient = factory.createSubscriptionApiHttpClient(baseUrl, mockCredentials);
        PackageQueryApiClient packageQueryClient = factory.createPackageQueryApiHttpClient(baseUrl, mockCredentials);
        
        assertNotNull(packageDistClient);
        assertNotNull(metadataClient);
        assertNotNull(subscriptionClient);
        assertNotNull(packageQueryClient);
    }

    @Test
    void testFactoryConsistency() {
        URI baseUrl = URI.create("https://api.example.com");
        
        for (int i = 0; i < 3; i++) {
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

    @Test
    void testInternalClientCreationConsistency() {
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        
        PackageDistributionApiClientImplementation client1 = factory.createPackageDistributionHttpClient(baseUrl1, mockCredentials);
        MetadataApiClient client2 = factory.createMetadataHttpClient(baseUrl2, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
    }
}
