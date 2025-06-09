package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequest;
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

class SpringBootSnapshotApiRestClientExpandedTest {

    @Mock
    private WebClient webClient;

    @Mock
    private JsonApiSerializer serializer;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private SpringBootSnapshotApiRestClient client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new SpringBootSnapshotApiRestClient(webClient, serializer);
    }

    @Test
    void testGetLivescoreWithValidRequest() {
        GetLivescoreRequest request = new GetLivescoreRequest();
        request.setFixtureId(123);
        
        BaseResponse expectedResponse = new BaseResponse();
        String responseJson = "{\"success\":true}";
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(responseJson));
        when(serializer.deserialize(responseJson, BaseResponse.class)).thenReturn(expectedResponse);
        
        Mono<BaseResponse> result = client.getLivescore(request);
        
        BaseResponse actualResponse = result.block();
        assertEquals(expectedResponse, actualResponse);
        
        verify(webClient).get();
        verify(serializer).deserialize(responseJson, BaseResponse.class);
    }

    @Test
    void testGetLivescoreWithNullRequest() {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just("{}"));
        when(serializer.deserialize(anyString(), any())).thenReturn(new BaseResponse());
        
        Mono<BaseResponse> result = client.getLivescore(null);
        
        BaseResponse actualResponse = result.block();
        assertNotNull(actualResponse);
        
        verify(webClient).get();
    }

    @Test
    void testGetLivescoreWithWebClientError() {
        GetLivescoreRequest request = new GetLivescoreRequest();
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.error(new RuntimeException("Network error")));
        
        Mono<BaseResponse> result = client.getLivescore(request);
        
        assertThrows(RuntimeException.class, () -> result.block());
        
        verify(webClient).get();
    }

    @Test
    void testGetLivescoreWithSerializationError() {
        GetLivescoreRequest request = new GetLivescoreRequest();
        String responseJson = "{\"success\":true}";
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(responseJson));
        when(serializer.deserialize(responseJson, BaseResponse.class))
            .thenThrow(new RuntimeException("Serialization error"));
        
        Mono<BaseResponse> result = client.getLivescore(request);
        
        assertThrows(RuntimeException.class, () -> result.block());
        
        verify(serializer).deserialize(responseJson, BaseResponse.class);
    }
}
