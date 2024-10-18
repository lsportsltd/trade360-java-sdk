package com.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link PreMatchSnapshotApiClient} interface.
 */
public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final ApiRestClient client;

    /**
     * Constructs a new PreMatchSnapshotApiClientImplementation with the given API client.
     *
     * @param client The API client
     */
    public PreMatchSnapshotApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest) {
        return this.client.postRequest(
            getFixturesRequest,
            new TypeReference<Iterable<GetFixturesResultElement>>() {},
            "/Prematch/GetFixtures");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequest) {
        return this.client.postRequest(
            getLivescoreRequest,
            new TypeReference<Iterable<GetLivescoreResultElement>>() {},
            "/Prematch/GetScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getMarketRequest) {
        return this.client.postRequest(
            getMarketRequest,
            new TypeReference<Iterable<GetFixtureMarketsResultElement>>() {},
            "/Prematch/GetFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest) {
        return this.client.postRequest(
            getEventsRequest,
            new TypeReference<Iterable<GetEventsResultElement>>() {},
            "/Prematch/GetEvents");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetSnapshotRequest getOutrightEventsRequest) {
        return this.client.postRequest(
            getOutrightEventsRequest,
            new TypeReference<Iterable<GetOutrightEventsResultElement>>() {},
            "/Prematch/GetOutrightEvents");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetSnapshotRequest getOutrightFixtureRequest) {
        return this.client.postRequest(
            getOutrightFixtureRequest,
            new TypeReference<Iterable<GetOutrightFixtureResultElement>>() {},
            "/Prematch/GetOutrightFixture");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetSnapshotRequest getOutrightScoresRequest) {
        return this.client.postRequest(
            getOutrightScoresRequest,
            new TypeReference<Iterable<GetOutrightScoresResultElement>>() {},
            "/Prematch/GetOutrightScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetSnapshotRequest getOutrightFixtureMarketsRequest) {
        return this.client.postRequest(
            getOutrightFixtureMarketsRequest,
            new TypeReference<Iterable<GetOutrightFixtureMarketsResultElement>>() {},
            "/Prematch/GetOutrightFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetSnapshotRequest getOutrightLeaguesRequest) {
        return this.client.postRequest(
            getOutrightLeaguesRequest,
            new TypeReference<Iterable<GetOutrightLeaguesResultElement>>() {},
            "/Prematch/GetOutrightLeagues");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetSnapshotRequest getOutrightLeagueMarketsRequest) {
        return this.client.postRequest(
            getOutrightLeagueMarketsRequest,
            new TypeReference<Iterable<GetOutrightLeagueMarketsResultElement>>() {},
            "/Prematch/GetOutrightLeagueMarkets");
    }
}