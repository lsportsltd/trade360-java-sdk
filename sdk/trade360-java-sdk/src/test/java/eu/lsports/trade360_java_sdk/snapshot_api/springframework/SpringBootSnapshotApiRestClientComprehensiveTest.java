package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SpringBootSnapshotApiRestClientComprehensiveTest {

    @Test
    void testConstructorWithValidParameters() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
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
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(null, mockSerializer, baseUrl);
        });
    }

    @Test
    void testConstructorWithNullSerializer() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(mockBuilder, null, baseUrl);
        });
    }

    @Test
    void testConstructorWithNullBaseUrl() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        assertThrows(NullPointerException.class, () -> {
            new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, null);
        });
    }

    @Test
    void testPostRequestWithRequestBodySuccess() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestBodyUriSpec mockRequestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec mockRequestBodySpec = mock(WebClient.RequestBodySpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        JsonNode mockRequestNode = mock(JsonNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.post()).thenReturn(mockRequestBodyUriSpec);
        when(mockRequestBodyUriSpec.uri(anyString())).thenReturn(mockRequestBodySpec);
        when(mockRequestBodySpec.body(any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(mockBodyNode);
        when(mockBodyNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        when(mockSerializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn("test response");
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        Mono<String> result = client.postRequest("test request", new TypeReference<String>() {}, "/test");
        
        StepVerifier.create(result)
            .expectNext("test response")
            .verifyComplete();
    }

    @Test
    void testPostRequestWithoutRequestBodySuccess() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestBodyUriSpec mockRequestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec mockRequestBodySpec = mock(WebClient.RequestBodySpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        JsonNode mockRequestNode = mock(JsonNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.post()).thenReturn(mockRequestBodyUriSpec);
        when(mockRequestBodyUriSpec.uri(anyString())).thenReturn(mockRequestBodySpec);
        when(mockRequestBodySpec.body(any())).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(mockBodyNode);
        when(mockBodyNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        when(mockSerializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn("test response");
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        Mono<String> result = client.postRequest(new TypeReference<String>() {}, "/test");
        
        StepVerifier.create(result)
            .expectNext("test response")
            .verifyComplete();
    }

    @Test
    void testGetRequestSuccess() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        WebClient.RequestHeadersUriSpec mockRequestHeadersUriSpec = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec mockRequestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec mockResponseSpec = mock(WebClient.ResponseSpec.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        JsonNode mockRequestNode = mock(JsonNode.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockWebClient.get()).thenReturn(mockRequestHeadersUriSpec);
        when(mockRequestHeadersUriSpec.uri(any(java.util.function.Function.class))).thenReturn(mockRequestHeadersSpec);
        when(mockRequestHeadersSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.onStatus(any(), any())).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockResponseNode));
        when(mockSerializer.serializeRequest(any())).thenReturn(mockRequestNode);
        when(mockRequestNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        when(mockSerializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn(java.util.Map.of("param1", "value1"));
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(mockBodyNode);
        when(mockBodyNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        Mono<String> result = client.getRequest(new Object(), new TypeReference<String>() {}, "/test");
        
        StepVerifier.create(result)
            .expectNext("test response")
            .verifyComplete();
    }

    @Test
    void testHandleResponseWithMissingHeader() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockResponseNode.has("Header")).thenReturn(false);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertThrows(Trade360Exception.class, () -> {
            try {
                java.lang.reflect.Method method = SpringBootSnapshotApiRestClient.class.getDeclaredMethod("handleResponse", TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
                method.setAccessible(true);
                reactor.core.publisher.SynchronousSink<String> mockSink = mock(reactor.core.publisher.SynchronousSink.class);
                method.invoke(client, new TypeReference<String>() {}, mockResponseNode, mockSink);
            } catch (Exception e) {
                if (e.getCause() instanceof Trade360Exception) {
                    throw (Trade360Exception) e.getCause();
                }
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testHandleResponseWithMissingBody() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        JsonNode mockResponseNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockResponseNode.has("Header")).thenReturn(true);
        when(mockResponseNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockResponseNode.get("Body")).thenReturn(null);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertThrows(Trade360Exception.class, () -> {
            try {
                java.lang.reflect.Method method = SpringBootSnapshotApiRestClient.class.getDeclaredMethod("handleResponse", TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
                method.setAccessible(true);
                reactor.core.publisher.SynchronousSink<String> mockSink = mock(reactor.core.publisher.SynchronousSink.class);
                method.invoke(client, new TypeReference<String>() {}, mockResponseNode, mockSink);
            } catch (Exception e) {
                if (e.getCause() instanceof Trade360Exception) {
                    throw (Trade360Exception) e.getCause();
                }
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testHandleResponseWithNullResponse() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertThrows(Trade360Exception.class, () -> {
            try {
                java.lang.reflect.Method method = SpringBootSnapshotApiRestClient.class.getDeclaredMethod("handleResponse", TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
                method.setAccessible(true);
                reactor.core.publisher.SynchronousSink<String> mockSink = mock(reactor.core.publisher.SynchronousSink.class);
                method.invoke(client, new TypeReference<String>() {}, null, mockSink);
            } catch (Exception e) {
                if (e.getCause() instanceof Trade360Exception) {
                    throw (Trade360Exception) e.getCause();
                }
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testCreateErrorMonoWithEmptyContent() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        ClientResponse mockResponse = mock(ClientResponse.class);
        ClientResponse.Headers mockHeaders = mock(ClientResponse.Headers.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockResponse.statusCode()).thenReturn(HttpStatus.BAD_REQUEST);
        when(mockResponse.headers()).thenReturn(mockHeaders);
        when(mockHeaders.contentLength()).thenReturn(java.util.OptionalLong.of(0L));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        try {
            java.lang.reflect.Method method = SpringBootSnapshotApiRestClient.class.getDeclaredMethod("createErrorMono", ClientResponse.class);
            method.setAccessible(true);
            Mono<Throwable> result = (Mono<Throwable>) method.invoke(client, mockResponse);
            
            StepVerifier.create(result)
                .expectErrorMatches(throwable -> throwable instanceof Trade360Exception && 
                    throwable.getMessage().contains("400 BAD_REQUEST"))
                .verify();
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testExtractErrorMessageWithValidContent() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        ClientResponse mockResponse = mock(ClientResponse.class);
        ClientResponse.Headers mockHeaders = mock(ClientResponse.Headers.class);
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockResponse.headers()).thenReturn(mockHeaders);
        when(mockHeaders.contentLength()).thenReturn(java.util.OptionalLong.of(100L));
        when(mockResponse.bodyToMono(JsonNode.class)).thenReturn(Mono.just(mockBodyNode));
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mock(com.fasterxml.jackson.core.JsonParser.class));
        when(mockSerializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn(List.of(new eu.lsports.trade360_java_sdk.common.entities.base.Error("Test error")));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        try {
            java.lang.reflect.Method method = SpringBootSnapshotApiRestClient.class.getDeclaredMethod("extractErrorMessage", ClientResponse.class);
            method.setAccessible(true);
            Mono<Iterable<String>> result = (Mono<Iterable<String>>) method.invoke(client, mockResponse);
            
            StepVerifier.create(result)
                .expectNextMatches(errors -> {
                    java.util.Iterator<String> iterator = errors.iterator();
                    return iterator.hasNext() && "Test error".equals(iterator.next());
                })
                .verifyComplete();
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
