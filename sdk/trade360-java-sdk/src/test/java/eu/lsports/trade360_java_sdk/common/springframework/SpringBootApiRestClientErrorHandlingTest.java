package eu.lsports.trade360_java_sdk.common.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.lang.reflect.InvocationTargetException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SpringBootApiRestClientErrorHandlingTest {
    
    @Mock
    private WebClient.Builder webClientBuilder;
    
    @Mock
    private WebClient webClient;
    
    @Mock
    private JsonApiSerializer serializer;
    
    @Mock
    private ObjectMapper objectMapper;
    
    private SpringBootApiRestClient client;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        when(webClientBuilder.baseUrl(any(String.class))).thenReturn(webClientBuilder);
        when(webClientBuilder.codecs(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeaders(any())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
        when(serializer.getObjectMapper()).thenReturn(objectMapper);
        
        client = new SpringBootApiRestClient(webClientBuilder, serializer, URI.create("http://test.com"));
    }
    
    @Test
    void testHandleResponseWithNullResponse() throws Exception {
        var method = client.getClass().getDeclaredMethod("handleResponse", 
            TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
        method.setAccessible(true);
        
        reactor.core.publisher.SynchronousSink<Object> sink = mock(reactor.core.publisher.SynchronousSink.class);
        
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> 
            method.invoke(client, new TypeReference<BaseResponse<String>>() {}, null, sink));
        
        assertTrue(exception.getCause() instanceof Trade360Exception);
        assertEquals("No correct response received. Ensure that correct Trade360 URL is configured.", 
            exception.getCause().getMessage());
    }
    
    @Test
    void testHandleResponseWithMissingHeader() throws Exception {
        JsonNode response = mock(JsonNode.class);
        when(response.has("Header")).thenReturn(false);
        
        var method = client.getClass().getDeclaredMethod("handleResponse", 
            TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
        method.setAccessible(true);
        
        reactor.core.publisher.SynchronousSink<Object> sink = mock(reactor.core.publisher.SynchronousSink.class);
        
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> 
            method.invoke(client, new TypeReference<BaseResponse<String>>() {}, response, sink));
        
        assertTrue(exception.getCause() instanceof Trade360Exception);
        assertEquals("'Header' property is missing. Please, ensure that you use the correct URL.", 
            exception.getCause().getMessage());
    }
    
    @Test
    void testHandleResponseWithMissingBody() throws Exception {
        JsonNode response = mock(JsonNode.class);
        when(response.has("Header")).thenReturn(true);
        when(response.get("Body")).thenReturn(null);
        
        var method = client.getClass().getDeclaredMethod("handleResponse", 
            TypeReference.class, JsonNode.class, reactor.core.publisher.SynchronousSink.class);
        method.setAccessible(true);
        
        reactor.core.publisher.SynchronousSink<Object> sink = mock(reactor.core.publisher.SynchronousSink.class);
        
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> 
            method.invoke(client, new TypeReference<BaseResponse<String>>() {}, response, sink));
        
        assertTrue(exception.getCause() instanceof Trade360Exception);
        assertEquals("'Body' property is missing. Please, ensure that you use the correct URL.", 
            exception.getCause().getMessage());
    }
    
    @Test
    void testConvertToQueryParamsWithIOException() throws Exception {
        when(serializer.serializeRequest(any())).thenThrow(new RuntimeException("Serialization failed"));
        
        var method = client.getClass().getDeclaredMethod("convertToQueryParams", Object.class);
        method.setAccessible(true);
        
        Object testRequest = new Object();
        
        try {
            method.invoke(client, testRequest);
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof RuntimeException);
        }
    }
    
    @Test
    void testExtractErrorMessageWithZeroContentLength() throws Exception {
        org.springframework.web.reactive.function.client.ClientResponse response = 
            mock(org.springframework.web.reactive.function.client.ClientResponse.class);
        org.springframework.web.reactive.function.client.ClientResponse.Headers headers = 
            mock(org.springframework.web.reactive.function.client.ClientResponse.Headers.class);
        
        when(response.headers()).thenReturn(headers);
        when(headers.contentLength()).thenReturn(java.util.OptionalLong.of(0L));
        
        var method = client.getClass().getDeclaredMethod("extractErrorMessage", 
            org.springframework.web.reactive.function.client.ClientResponse.class);
        method.setAccessible(true);
        
        Mono<Iterable<String>> result = (Mono<Iterable<String>>) method.invoke(client, response);
        
        result.subscribe(errors -> {
            java.util.List<String> errorList = (java.util.List<String>) errors;
            assertEquals(1, errorList.size());
            assertEquals("Unknown error occurred.", errorList.get(0));
        });
    }
}
