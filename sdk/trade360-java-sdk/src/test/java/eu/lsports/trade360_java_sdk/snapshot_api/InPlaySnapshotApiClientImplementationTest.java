package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class InPlaySnapshotApiClientImplementationTest {

    @Mock
    private SnapshotApiRestClient snapshotApiRestClient;

    private InPlaySnapshotApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new InPlaySnapshotApiClientImplementation(snapshotApiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetFixtures() {
        Iterable<GetFixturesResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetFixtureRequest.class), any(TypeReference.class), eq("/Inplay/GetFixtures")))
                .thenReturn(Mono.just(expectedResponse));

        GetFixtureRequest request = new GetFixtureRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetFixturesResultElement>> result = client.getFixtures(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetLivescore() {
        Iterable<GetLivescoreResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetLivescoreRequest.class), any(TypeReference.class), eq("/Inplay/GetScores")))
                .thenReturn(Mono.just(expectedResponse));

        GetLivescoreRequest request = new GetLivescoreRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetLivescoreResultElement>> result = client.getLivescore(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetFixtureMarkets() {
        Iterable<GetFixtureMarketsResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetMarketRequest.class), any(TypeReference.class), eq("/Inplay/GetFixtureMarkets")))
                .thenReturn(Mono.just(expectedResponse));

        GetMarketRequest request = new GetMarketRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetFixtureMarketsResultElement>> result = client.getFixtureMarkets(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetEvents() {
        Iterable<GetEventsResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetInPlayEventRequest.class), any(TypeReference.class), eq("/Inplay/GetEvents")))
                .thenReturn(Mono.just(expectedResponse));

        GetInPlayEventRequest request = new GetInPlayEventRequest(null, null, null, null, null, null, null, null);
        Mono<Iterable<GetEventsResultElement>> result = client.getEvents(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetOutrightLeagueEvents() {
        Iterable<GetOutrightLeagueEventsResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetOutrightLeagueEventsRequest.class), any(TypeReference.class), eq("/Prematch/GetOutrightLeagueEvents")))
                .thenReturn(Mono.just(expectedResponse));

        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(null, null, null, null, null, null, null, null);
        Mono<Iterable<GetOutrightLeagueEventsResultElement>> result = client.getOutrightLeagueEvents(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
