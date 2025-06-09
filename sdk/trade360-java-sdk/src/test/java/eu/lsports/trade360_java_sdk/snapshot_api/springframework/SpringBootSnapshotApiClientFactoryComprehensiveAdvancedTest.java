package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import eu.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiClientFactoryComprehensiveAdvancedTest {

    @Mock
    private WebClient.Builder mockWebClientBuilder;

    @Mock
    private PackageCredentials mockCredentials;

    private SpringBootSnapshotApiClientFactory factory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        WebClient mockWebClient = mock(WebClient.class);
        when(mockWebClientBuilder.baseUrl(anyString())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.codecs(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.defaultHeaders(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.build()).thenReturn(mockWebClient);
        
        factory = new SpringBootSnapshotApiClientFactory(mockWebClientBuilder);
    }

    @Test
    void testFactoryConstructor() {
        assertNotNull(factory);
    }

    @Test
    void testCreateInPlayApiClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        InPlaySnapshotApiClient client = factory.createInPlayApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePreMatchApiClientWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PreMatchSnapshotApiClient client = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateInPlayApiClientWithHttpsUrl() {
        URI httpsUrl = URI.create("https://secure.api.example.com:8443");
        
        InPlaySnapshotApiClient client = factory.createInPlayApiClient(httpsUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePreMatchApiClientWithHttpsUrl() {
        URI httpsUrl = URI.create("https://secure.api.example.com:8443");
        
        PreMatchSnapshotApiClient client = factory.createPreMatchApiClient(httpsUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreateInPlayApiClientWithDifferentCredentials() {
        URI baseUrl = URI.create("https://api.example.com");
        PackageCredentials credentials1 = mock(PackageCredentials.class);
        PackageCredentials credentials2 = mock(PackageCredentials.class);
        
        InPlaySnapshotApiClient client1 = factory.createInPlayApiClient(baseUrl, credentials1);
        InPlaySnapshotApiClient client2 = factory.createInPlayApiClient(baseUrl, credentials2);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreatePreMatchApiClientWithDifferentCredentials() {
        URI baseUrl = URI.create("https://api.example.com");
        PackageCredentials credentials1 = mock(PackageCredentials.class);
        PackageCredentials credentials2 = mock(PackageCredentials.class);
        
        PreMatchSnapshotApiClient client1 = factory.createPreMatchApiClient(baseUrl, credentials1);
        PreMatchSnapshotApiClient client2 = factory.createPreMatchApiClient(baseUrl, credentials2);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultipleInPlayClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        InPlaySnapshotApiClient client1 = factory.createInPlayApiClient(baseUrl, mockCredentials);
        InPlaySnapshotApiClient client2 = factory.createInPlayApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateMultiplePreMatchClients() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PreMatchSnapshotApiClient client1 = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        PreMatchSnapshotApiClient client2 = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreateClientsWithDifferentUrls() {
        URI url1 = URI.create("https://api1.example.com");
        URI url2 = URI.create("https://api2.example.com");
        
        InPlaySnapshotApiClient inPlayClient1 = factory.createInPlayApiClient(url1, mockCredentials);
        InPlaySnapshotApiClient inPlayClient2 = factory.createInPlayApiClient(url2, mockCredentials);
        PreMatchSnapshotApiClient preMatchClient1 = factory.createPreMatchApiClient(url1, mockCredentials);
        PreMatchSnapshotApiClient preMatchClient2 = factory.createPreMatchApiClient(url2, mockCredentials);
        
        assertNotNull(inPlayClient1);
        assertNotNull(inPlayClient2);
        assertNotNull(preMatchClient1);
        assertNotNull(preMatchClient2);
        assertNotSame(inPlayClient1, inPlayClient2);
        assertNotSame(preMatchClient1, preMatchClient2);
    }

    @Test
    void testFactoryWithDifferentWebClientBuilders() {
        WebClient.Builder builder1 = mock(WebClient.Builder.class);
        WebClient.Builder builder2 = mock(WebClient.Builder.class);
        
        SpringBootSnapshotApiClientFactory factory1 = new SpringBootSnapshotApiClientFactory(builder1);
        SpringBootSnapshotApiClientFactory factory2 = new SpringBootSnapshotApiClientFactory(builder2);
        
        assertNotNull(factory1);
        assertNotNull(factory2);
        assertNotSame(factory1, factory2);
    }

    @Test
    void testCreateBothClientTypesFromSameFactory() {
        URI baseUrl = URI.create("https://api.example.com");
        
        InPlaySnapshotApiClient inPlayClient = factory.createInPlayApiClient(baseUrl, mockCredentials);
        PreMatchSnapshotApiClient preMatchClient = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        
        assertNotNull(inPlayClient);
        assertNotNull(preMatchClient);
    }

    @Test
    void testFactoryConsistency() {
        URI baseUrl = URI.create("https://api.example.com");
        
        for (int i = 0; i < 5; i++) {
            InPlaySnapshotApiClient inPlayClient = factory.createInPlayApiClient(baseUrl, mockCredentials);
            PreMatchSnapshotApiClient preMatchClient = factory.createPreMatchApiClient(baseUrl, mockCredentials);
            
            assertNotNull(inPlayClient);
            assertNotNull(preMatchClient);
        }
    }
}
