package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InPlaySnapshotApiClientTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements InPlaySnapshotApiClient {
                public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest req) { return null; }
                public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest req) { return null; }
                public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest req) { return null; }
                public Mono<Iterable<GetEventsResultElement>> getEvents(GetInPlayEventRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetOutrightLeaguesRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetOutrightLeagueMarketRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeagueEventsResultElement>> getOutrightLeagueEvents(GetOutrightLeagueEventsRequest getOutrightLeagueEventsRequest) { return null; };
            }
            new Impl();
        });
    }
}