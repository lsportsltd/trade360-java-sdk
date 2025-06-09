package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiRestClientAdvancedTest {
    
    static class TestRequest {
        public String param1;
        public String param2;
    }

    @Test
    void testConstructorWithValidParameters() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
        verify(mockBuilder).baseUrl(baseUrl.toString());
        verify(mockBuilder).build();
    }

    @Test
    void testConstructorWithNullBuilder() {
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(null, mockSerializer, baseUrl);
        });
    }

    @Test
    void testConstructorWithNullSerializer() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, null, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithNullBaseUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        WebClient mockWebClient = mock(WebClient.class);
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, null);
        });
    }

    @Test
    void testPostWithValidRequest() throws Exception {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestBodyUriSpec mockRequestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec mockRequestBodySpec = mock(WebClient.RequestBodySpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        ObjectNode mockRequestNode = mock(ObjectNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.post()).thenReturn(mockRequestBodyUriSpec);
        when(mockRequestBodyUriSpec.uri("/test")).thenReturn(mockRequestBodySpec);
        when(mockRequestBodySpec.body(any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(mockBodyNode);
        when(mockBodyNode.traverse()).thenReturn(mockParser);
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn("test response");
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        Mono<String> result = client.postRequest("test request", new TypeReference<String>() {}, "/test");
        
        assertNotNull(result);
        assertEquals("test response", result.block());
    }

    @Test
    void testPostWithMissingHeader() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestBodyUriSpec mockRequestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec mockRequestBodySpec = mock(WebClient.RequestBodySpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        ObjectNode mockRequestNode = mock(ObjectNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.post()).thenReturn(mockRequestBodyUriSpec);
        when(mockRequestBodyUriSpec.uri("/test")).thenReturn(mockRequestBodySpec);
        when(mockRequestBodySpec.body(any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockResponseNode.has("Header")).thenReturn(false);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertThrows(RuntimeException.class, () -> {
            client.postRequest("test request", new TypeReference<String>() {}, "/test").block();
        });
    }

    @Test
    void testGetRequestMethodExists() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testGetWithMissingBody() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestHeadersUriSpec mockRequestHeadersUriSpec = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
        when(mockRequestHeadersUriSpec.uri("/test")).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(null);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertThrows(RuntimeException.class, () -> {
            client.getRequest("test request", new TypeReference<String>() {}, "/test").block();
        });
    }

    @Test
    void testPostWithEmptyPath() throws Exception {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestBodyUriSpec mockRequestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec mockRequestBodySpec = mock(WebClient.RequestBodySpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        ObjectNode mockRequestNode = mock(ObjectNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.post()).thenReturn(mockRequestBodyUriSpec);
        when(mockRequestBodyUriSpec.uri("")).thenReturn(mockRequestBodySpec);
        when(mockRequestBodySpec.body(any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(mockBodyNode);
        when(mockBodyNode.traverse()).thenReturn(mockParser);
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn("test response");
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        Mono<String> result = client.postRequest("test request", new TypeReference<String>() {}, "");
        
        assertNotNull(result);
        assertEquals("test response", result.block());
    }

    @Test
    void testClientInstantiation() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(baseUrl.toString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }
}
