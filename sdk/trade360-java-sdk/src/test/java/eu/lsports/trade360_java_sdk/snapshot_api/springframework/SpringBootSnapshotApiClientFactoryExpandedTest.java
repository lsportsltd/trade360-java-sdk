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
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiClientFactoryExpandedTest {

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private PackageCredentials credentials;

    private SpringBootSnapshotApiClientFactory factory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.codecs(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeaders(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(mock(WebClient.class));
        
        factory = new SpringBootSnapshotApiClientFactory(webClientBuilder);
    }

    @Test
    void testCreateInPlayApiClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        InPlaySnapshotApiClient client = factory.createInPlayApiClient(baseUrl, credentials);
        
        assertNotNull(client);
        assertTrue(client instanceof InPlaySnapshotApiClient);
    }

    @Test
    void testCreatePreMatchApiClient() {
        URI baseUrl = URI.create("https://api.example.com");
        
        PreMatchSnapshotApiClient client = factory.createPreMatchApiClient(baseUrl, credentials);
        
        assertNotNull(client);
        assertTrue(client instanceof PreMatchSnapshotApiClient);
    }

    @Test
    void testCreateInPlayApiClientWithDifferentUrls() {
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        
        InPlaySnapshotApiClient client1 = factory.createInPlayApiClient(baseUrl1, credentials);
        InPlaySnapshotApiClient client2 = factory.createInPlayApiClient(baseUrl2, credentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testCreatePreMatchApiClientWithDifferentUrls() {
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        
        PreMatchSnapshotApiClient client1 = factory.createPreMatchApiClient(baseUrl1, credentials);
        PreMatchSnapshotApiClient client2 = factory.createPreMatchApiClient(baseUrl2, credentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testFactoryConstructor() {
        SpringBootSnapshotApiClientFactory newFactory = new SpringBootSnapshotApiClientFactory(webClientBuilder);
        
        assertNotNull(newFactory);
    }
}
