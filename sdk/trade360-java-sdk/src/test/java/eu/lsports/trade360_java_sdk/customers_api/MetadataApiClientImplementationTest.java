package eu.lsports.trade360_java_sdk.customers_api;

import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;

class MetadataApiClientImplementationTest {

    @Mock
    private ApiRestClient apiRestClient;

    private MetadataApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new MetadataApiClientImplementation(apiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetSports() {
        BaseResponse<GetSportsResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetSportsRequest.class), any(TypeReference.class), eq("Sports/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetSportsRequest request = new GetSportsRequest();
        Mono<BaseResponse<GetSportsResponse>> result = client.getSports(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetLocations() {
        BaseResponse<GetLocationsResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetLocationsRequest.class), any(TypeReference.class), eq("Locations/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetLocationsRequest request = new GetLocationsRequest();
        Mono<BaseResponse<GetLocationsResponse>> result = client.getLocations(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetLeagues() {
        BaseResponse<GetLeaguesResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetLeaguesRequest.class), any(TypeReference.class), eq("Leagues/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetLeaguesRequest request = new GetLeaguesRequest(List.of(1), List.of(2), SubscriptionState.SUBSCRIBED, 1);
        Mono<BaseResponse<GetLeaguesResponse>> result = client.getLeagues(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
