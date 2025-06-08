package eu.lsports.trade360_java_sdk.snapshot_api;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixtureRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetInPlayEventRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;

class InPlaySnapshotApiClientTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements InPlaySnapshotApiClient {
                public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest req) { return null; }
                public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest req) { return null; }
                public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest req) { return null; }
                public Mono<Iterable<GetEventsResultElement>> getEvents(GetInPlayEventRequest req) { return null; }
            }
            new Impl();
        });
    }
}