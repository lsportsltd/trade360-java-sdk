package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiRestClientExpandedTest {

    @Mock
    private WebClient.Builder webClientBuilder;
    
    @Mock
    private WebClient webClient;
    
    @Mock
    private JsonApiSerializer serializer;
    
    @Mock
    private ObjectMapper objectMapper;
    
    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    
    @Mock
    private WebClient.ResponseSpec responseSpec;
    
    @Mock
    private ClientResponse clientResponse;

    private SpringBootSnapshotApiRestClient client;
    private URI baseUrl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        baseUrl = URI.create("https://api.test.com");
        
        when(serializer.getObjectMapper()).thenReturn(objectMapper);
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.codecs(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeaders(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
        
        client = new SpringBootSnapshotApiRestClient(webClientBuilder, serializer, baseUrl);
    }

    @Test
    void testConstructorInitialization() {
        assertNotNull(client);
        verify(webClientBuilder).baseUrl(baseUrl.toString());
        verify(webClientBuilder).build();
    }

    @Test
    void testPostRequestWithBody() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("test", "value");
        
        JsonNode responseNode = mock(JsonNode.class);
        JsonNode headerNode = mock(JsonNode.class);
        JsonNode bodyNode = mock(JsonNode.class);
        
        when(serializer.serializeRequest(requestBody)).thenReturn(responseNode);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(responseNode));
        
        when(responseNode.has("Header")).thenReturn(true);
        when(responseNode.get("Body")).thenReturn(bodyNode);
        when(serializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn("test result");

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.postRequest(requestBody, typeRef, "/test");
        
        StepVerifier.create(result)
            .expectNext("test result")
            .verifyComplete();
    }

    @Test
    void testPostRequestWithoutBody() {
        JsonNode responseNode = mock(JsonNode.class);
        JsonNode bodyNode = mock(JsonNode.class);
        
        when(serializer.serializeRequest(any())).thenReturn(responseNode);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(responseNode));
        
        when(responseNode.has("Header")).thenReturn(true);
        when(responseNode.get("Body")).thenReturn(bodyNode);
        when(serializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn("test result");

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.postRequest(typeRef, "/test");
        
        StepVerifier.create(result)
            .expectNext("test result")
            .verifyComplete();
    }

    @Test
    void testGetRequest() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("param1", "value1");
        
        JsonNode responseNode = mock(JsonNode.class);
        JsonNode bodyNode = mock(JsonNode.class);
        JsonNode serializedNode = mock(JsonNode.class);
        
        when(serializer.serializeRequest(queryParams)).thenReturn(serializedNode);
        when(serializedNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        when(serializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn(queryParams);
        
        when(webClient.get()).thenReturn(mock(WebClient.RequestHeadersUriSpec.class));
        WebClient.RequestHeadersUriSpec getSpec = webClient.get();
        when(getSpec.uri(any(java.util.function.Function.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(responseNode));
        
        when(responseNode.has("Header")).thenReturn(true);
        when(responseNode.get("Body")).thenReturn(bodyNode);

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.getRequest(queryParams, typeRef, "/test");
        
        assertNotNull(result);
    }

    @Test
    void testErrorHandlingMissingHeader() {
        JsonNode responseNode = mock(JsonNode.class);
        
        when(serializer.serializeRequest(any())).thenReturn(responseNode);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(responseNode));
        
        when(responseNode.has("Header")).thenReturn(false);

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.postRequest(typeRef, "/test");
        
        StepVerifier.create(result)
            .expectError(Trade360Exception.class)
            .verify();
    }

    @Test
    void testErrorHandlingMissingBody() {
        JsonNode responseNode = mock(JsonNode.class);
        
        when(serializer.serializeRequest(any())).thenReturn(responseNode);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(responseNode));
        
        when(responseNode.has("Header")).thenReturn(true);
        when(responseNode.get("Body")).thenReturn(null);

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.postRequest(typeRef, "/test");
        
        StepVerifier.create(result)
            .expectError(Trade360Exception.class)
            .verify();
    }

    @Test
    void testErrorHandlingNullResponse() {
        when(serializer.serializeRequest(any())).thenReturn(mock(JsonNode.class));
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just((JsonNode) null));

        TypeReference<String> typeRef = new TypeReference<String>() {};
        Mono<String> result = client.postRequest(typeRef, "/test");
        
        StepVerifier.create(result)
            .expectError(Trade360Exception.class)
            .verify();
    }
}
