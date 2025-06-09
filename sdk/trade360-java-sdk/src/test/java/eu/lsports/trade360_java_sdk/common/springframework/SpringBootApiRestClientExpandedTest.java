package eu.lsports.trade360_java_sdk.common.springframework;

import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class SpringBootApiRestClientExpandedTest {

    @Mock
    private WebClient webClient;

    @Mock
    private JsonApiSerializer serializer;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;

    @Mock
    private WebClient.RequestBodySpec requestBodySpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private SpringBootApiRestClient client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new SpringBootApiRestClient(webClient, serializer);
    }

    @Test
    void testPostWithValidRequest() {
        BaseRequest request = new BaseRequest();
        BaseResponse expectedResponse = new BaseResponse();
        String requestJson = "{\"test\":\"data\"}";
        String responseJson = "{\"success\":true}";
        
        when(serializer.serialize(request)).thenReturn(requestJson);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(requestJson)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(responseJson));
        when(serializer.deserialize(responseJson, BaseResponse.class)).thenReturn(expectedResponse);
        
        Mono<BaseResponse> result = client.post("/test", request, BaseResponse.class);
        
        BaseResponse actualResponse = result.block();
        assertEquals(expectedResponse, actualResponse);
        
        verify(serializer).serialize(request);
        verify(serializer).deserialize(responseJson, BaseResponse.class);
        verify(webClient).post();
    }

    @Test
    void testPostWithNullRequest() {
        BaseResponse expectedResponse = new BaseResponse();
        String responseJson = "{\"success\":true}";
        
        when(serializer.serialize(null)).thenReturn("null");
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue("null")).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(responseJson));
        when(serializer.deserialize(responseJson, BaseResponse.class)).thenReturn(expectedResponse);
        
        Mono<BaseResponse> result = client.post("/test", null, BaseResponse.class);
        
        BaseResponse actualResponse = result.block();
        assertEquals(expectedResponse, actualResponse);
        
        verify(serializer).serialize(null);
    }

    @Test
    void testPostWithWebClientError() {
        BaseRequest request = new BaseRequest();
        
        when(serializer.serialize(request)).thenReturn("{}");
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.error(new RuntimeException("Network error")));
        
        Mono<BaseResponse> result = client.post("/test", request, BaseResponse.class);
        
        assertThrows(RuntimeException.class, () -> result.block());
    }

    @Test
    void testGetWithValidEndpoint() {
        BaseResponse expectedResponse = new BaseResponse();
        String responseJson = "{\"success\":true}";
        
        when(webClient.get()).thenReturn(mock(WebClient.RequestHeadersUriSpec.class));
        when(webClient.get().uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(responseJson));
        when(serializer.deserialize(responseJson, BaseResponse.class)).thenReturn(expectedResponse);
        
        Mono<BaseResponse> result = client.get("/test", BaseResponse.class);
        
        BaseResponse actualResponse = result.block();
        assertEquals(expectedResponse, actualResponse);
        
        verify(serializer).deserialize(responseJson, BaseResponse.class);
    }
}
