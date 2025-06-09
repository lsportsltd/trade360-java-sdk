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


import java.net.URI;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

class SpringBootSnapshotApiRestClientExpandedTest {

    @Test
    void testConstructor() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockSerializer.getObjectMapper()).thenReturn(mockMapper);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testPostRequestWithRequestBody() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockSerializer.getObjectMapper()).thenReturn(mockMapper);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testPostRequestWithoutRequestBody() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockSerializer.getObjectMapper()).thenReturn(mockMapper);
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testGetRequestWithMockedSerialization() {
        WebClient.Builder mockBuilder = mock(WebClient.Builder.class);
        WebClient mockWebClient = mock(WebClient.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectMapper mockMapper = mock(ObjectMapper.class);
        URI baseUrl = URI.create("https://api.example.com");
        
        when(mockBuilder.baseUrl(anyString())).thenReturn(mockBuilder);
        when(mockBuilder.codecs(any())).thenReturn(mockBuilder);
        when(mockBuilder.defaultHeaders(any())).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(mockWebClient);
        when(mockSerializer.getObjectMapper()).thenReturn(mockMapper);
        
        ObjectMapper realMapper = new ObjectMapper();
        when(mockSerializer.serializeRequest(any())).thenReturn(realMapper.createObjectNode().put("test", "value"));
        
        SpringBootSnapshotApiRestClient client = new SpringBootSnapshotApiRestClient(mockBuilder, mockSerializer, baseUrl);
        
        assertNotNull(client);
    }

    private static class TestRequest {
        public String field1 = "value1";
        public int field2 = 42;
    }

    private static class TestResponse {
        public String result;
        public int status;
    }
}
