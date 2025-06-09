package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
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

class PreMatchSnapshotApiClientImplementationTest {

    @Mock
    private SnapshotApiRestClient snapshotApiRestClient;

    private PreMatchSnapshotApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new PreMatchSnapshotApiClientImplementation(snapshotApiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetFixtures() {
        Iterable<GetFixturesResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetFixtureRequest.class), any(TypeReference.class), eq("/Prematch/GetFixtures")))
                .thenReturn(Mono.just(expectedResponse));

        GetFixtureRequest request = new GetFixtureRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetFixturesResultElement>> result = client.getFixtures(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetFixtureMarkets() {
        Iterable<GetFixtureMarketsResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetMarketRequest.class), any(TypeReference.class), eq("/Prematch/GetFixtureMarkets")))
                .thenReturn(Mono.just(expectedResponse));

        GetMarketRequest request = new GetMarketRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetFixtureMarketsResultElement>> result = client.getFixtureMarkets(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetEvents() {
        Iterable<GetEventsResultElement> expectedResponse = List.of();
        when(snapshotApiRestClient.postRequest(any(GetEventRequest.class), any(TypeReference.class), eq("/Prematch/GetEvents")))
                .thenReturn(Mono.just(expectedResponse));

        GetEventRequest request = new GetEventRequest(null, null, null, null, null, null, null);
        Mono<Iterable<GetEventsResultElement>> result = client.getEvents(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
