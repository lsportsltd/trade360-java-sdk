package eu.lsports.trade360_java_sdk.snapshot_api;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;

class PreMatchSnapshotApiClientTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements PreMatchSnapshotApiClient {
                public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest req) { return null; }
                public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest req) { return null; }
                public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest req) { return null; }
                public Mono<Iterable<GetEventsResultElement>> getEvents(GetEventRequest req) { return null; }
                public Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetOutrightEventRequest req) { return null; }
                public Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetOutrightFixtureRequest req) { return null; }
                public Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetOutrightLivescoreRequest req) { return null; }
                public Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetOutrightMarketRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetOutrightLeaguesRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetOutrightLeagueMarketRequest req) { return null; }
                public Mono<Iterable<GetOutrightLeagueEventsResultElement>> getOutrightLeagueEvents(GetOutrightLeagueEventsRequest getOutrightLeagueEventsRequest) { return null; };
            }
            new Impl();
        });
    }
}