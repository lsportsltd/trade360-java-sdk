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

    @Test
    void testGetVenues() {
        BaseResponse<GetVenuesResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetVenuesRequest.class), any(TypeReference.class), eq("Venues/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetVenuesRequest.VenuesFilter filter = new GetVenuesRequest.VenuesFilter(
            List.of(1, 2), List.of(10), List.of(100), List.of(1000), List.of(10000)
        );
        GetVenuesRequest request = new GetVenuesRequest(filter);
        Mono<BaseResponse<GetVenuesResponse>> result = client.getVenues(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetCities() {
        BaseResponse<GetCitiesResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetCitiesRequest.class), any(TypeReference.class), eq("Cities/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetCitiesRequest.CitiesFilter filter = new GetCitiesRequest.CitiesFilter(List.of(1, 2), List.of(100));
        GetCitiesRequest request = new GetCitiesRequest(filter);
        Mono<BaseResponse<GetCitiesResponse>> result = client.getCities(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetStates() {
        BaseResponse<GetStatesResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetStatesRequest.class), any(TypeReference.class), eq("States/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetStatesRequest.CountriesFilter filter = new GetStatesRequest.CountriesFilter(List.of(1, 2, 3));
        GetStatesRequest request = new GetStatesRequest(filter);
        Mono<BaseResponse<GetStatesResponse>> result = client.getStates(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetParticipants() {
        BaseResponse<GetParticipantsResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetParticipantsRequest.class), any(TypeReference.class), eq("Participants/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            List.of(1, 2, 3), List.of(10, 20), List.of(100, 200), "Team", null, null, null
        );
        GetParticipantsRequest request = new GetParticipantsRequest(filter, 1, 50);
        Mono<BaseResponse<GetParticipantsResponse>> result = client.getParticipants(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
