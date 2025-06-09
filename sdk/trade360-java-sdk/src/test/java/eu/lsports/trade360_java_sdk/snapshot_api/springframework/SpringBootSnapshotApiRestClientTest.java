package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiRestClientTest {

    @Mock
    private WebClient.Builder webClientBuilder;
    
    @Mock
    private WebClient webClient;
    
    @Mock
    private JsonApiSerializer serializer;

    private SpringBootSnapshotApiRestClient client;
    private URI baseUri;
    private ObjectMapper realObjectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        baseUri = URI.create("https://api.example.com");
        realObjectMapper = new ObjectMapper();
        
        when(serializer.getObjectMapper()).thenReturn(realObjectMapper);
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.codecs(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeaders(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
        
        client = new SpringBootSnapshotApiRestClient(webClientBuilder, serializer, baseUri);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
        verify(webClientBuilder).baseUrl(baseUri.toString());
        verify(webClientBuilder).build();
    }

    @Test
    void testConstructorWithNullBuilder() {
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(null, serializer, baseUri);
        });
    }

    @Test
    void testConstructorWithNullSerializer() {
        assertDoesNotThrow(() -> {
            new SpringBootSnapshotApiRestClient(webClientBuilder, null, baseUri);
        });
    }

    @Test
    void testConstructorWithNullBaseUri() {
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(webClientBuilder, serializer, null);
        });
    }

    @Test
    void testWebClientBuilderConfiguration() {
        verify(webClientBuilder).baseUrl(baseUri.toString());
        verify(webClientBuilder).codecs(any());
        verify(webClientBuilder).defaultHeaders(any());
        verify(webClientBuilder).build();
    }



    @Test
    void testInstantiation() {
        SpringBootSnapshotApiRestClient newClient = new SpringBootSnapshotApiRestClient(
            webClientBuilder, serializer, URI.create("https://test.com"));
        assertNotNull(newClient);
    }
}
