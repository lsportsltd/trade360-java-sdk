package eu.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link PreMatchSnapshotApiClient} interface.
 */
public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final SnapshotApiRestClient client;

    /**
     * Constructs a new PreMatchSnapshotApiClientImplementation with the given API client.
     *
     * @param client The API client
     */
    public PreMatchSnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest getFixturesRequest) {
        return this.client.postRequest(
            getFixturesRequest,
            new TypeReference<Iterable<GetFixturesResultElement>>() {},
            "/Prematch/GetFixtures");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest getLivescoreRequest) {
        return this.client.postRequest(
            getLivescoreRequest,
            new TypeReference<Iterable<GetLivescoreResultElement>>() {},
            "/Prematch/GetScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest getMarketRequest) {
        return this.client.postRequest(
            getMarketRequest,
            new TypeReference<Iterable<GetFixtureMarketsResultElement>>() {},
            "/Prematch/GetFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetEventsResultElement>> getEvents(GetEventRequest getEventsRequest) {
        return this.client.postRequest(
            getEventsRequest,
            new TypeReference<Iterable<GetEventsResultElement>>() {},
            "/Prematch/GetEvents");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetOutrightEventRequest getOutrightEventsRequest) {
        return this.client.postRequest(
            getOutrightEventsRequest,
            new TypeReference<Iterable<GetOutrightEventsResultElement>>() {},
            "/Prematch/GetOutrightEvents");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetOutrightFixtureRequest getOutrightFixtureRequest) {
        return this.client.postRequest(
            getOutrightFixtureRequest,
            new TypeReference<Iterable<GetOutrightFixtureResultElement>>() {},
            "/Prematch/GetOutrightFixture");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetOutrightLivescoreRequest getOutrightScoresRequest) {
        return this.client.postRequest(
            getOutrightScoresRequest,
            new TypeReference<Iterable<GetOutrightScoresResultElement>>() {},
            "/Prematch/GetOutrightScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetOutrightMarketRequest getOutrightFixtureMarketsRequest) {
        return this.client.postRequest(
            getOutrightFixtureMarketsRequest,
            new TypeReference<Iterable<GetOutrightFixtureMarketsResultElement>>() {},
            "/Prematch/GetOutrightFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetOutrightLeaguesRequest getOutrightLeaguesRequest) {
        return this.client.postRequest(
            getOutrightLeaguesRequest,
            new TypeReference<Iterable<GetOutrightLeaguesResultElement>>() {},
            "/Prematch/GetOutrightLeagues");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetOutrightLeagueMarketRequest getOutrightLeagueMarketsRequest) {
        return this.client.postRequest(
            getOutrightLeagueMarketsRequest,
            new TypeReference<Iterable<GetOutrightLeagueMarketsResultElement>>() {},
            "/Prematch/GetOutrightLeagueMarkets");
    }
}