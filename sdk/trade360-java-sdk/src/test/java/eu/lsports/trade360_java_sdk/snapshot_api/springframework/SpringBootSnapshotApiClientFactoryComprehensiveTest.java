package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import eu.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiClientFactoryComprehensiveTest {

    @Test
    void testCreateInPlayApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        InPlaySnapshotApiClient client = factory.createInPlayApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePreMatchApiClient() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        PreMatchSnapshotApiClient client = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithNullBuilder() {
        assertDoesNotThrow(() -> {
            new SpringBootSnapshotApiClientFactory(null);
        });
    }

    @Test
    void testCreateInPlayWithNullCredentials() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        InPlaySnapshotApiClient client = factory.createInPlayApiClient(baseUrl, null);
        
        assertNotNull(client);
    }

    @Test
    void testCreatePreMatchWithNullCredentials() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        PreMatchSnapshotApiClient client = factory.createPreMatchApiClient(baseUrl, null);
        
        assertNotNull(client);
    }

    @Test
    void testCreateInPlayWithNullUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        assertThrows(Exception.class, () -> {
            factory.createInPlayApiClient(null, mockCredentials);
        });
    }

    @Test
    void testCreatePreMatchWithNullUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        assertThrows(Exception.class, () -> {
            factory.createPreMatchApiClient(null, mockCredentials);
        });
    }

    @Test
    void testMultipleClientCreation() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        InPlaySnapshotApiClient inPlayClient1 = factory.createInPlayApiClient(baseUrl, mockCredentials);
        InPlaySnapshotApiClient inPlayClient2 = factory.createInPlayApiClient(baseUrl, mockCredentials);
        PreMatchSnapshotApiClient preMatchClient1 = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        PreMatchSnapshotApiClient preMatchClient2 = factory.createPreMatchApiClient(baseUrl, mockCredentials);
        
        assertNotNull(inPlayClient1);
        assertNotNull(inPlayClient2);
        assertNotNull(preMatchClient1);
        assertNotNull(preMatchClient2);
        
        assertNotSame(inPlayClient1, inPlayClient2);
        assertNotSame(preMatchClient1, preMatchClient2);
    }

    @Test
    void testDifferentApiUrls() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        PackageCredentials mockCredentials = mock(PackageCredentials.class);
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiClientFactory factory = new SpringBootSnapshotApiClientFactory(mockBuilder);
        
        InPlaySnapshotApiClient client1 = factory.createInPlayApiClient(baseUrl1, mockCredentials);
        InPlaySnapshotApiClient client2 = factory.createInPlayApiClient(baseUrl2, mockCredentials);
        
        assertNotNull(client1);
        assertNotNull(client2);
    }
}
