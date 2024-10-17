package com.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link InPlaySnapshotApiClient} interface.
 */
public class InPlaySnapshotApiClientImplementation implements InPlaySnapshotApiClient {
    private final ApiRestClient client;

    /**
     * Constructs a new InPlaySnapshotApiClientImplementation with the given API client.
     *
     * @param client The API client
     */
    public InPlaySnapshotApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest) {
        return this.client.postRequest(
            getFixturesRequest,
            new TypeReference<Iterable<GetFixturesResultElement>>(){},
            "/Inplay/GetFixtures");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequest) {
        return this.client.postRequest(
            getLivescoreRequest,
            new TypeReference<Iterable<GetLivescoreResultElement>>(){},
            "/Inplay/GetScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getMarketRequest) {
        return this.client.postRequest(
            getMarketRequest,
            new TypeReference<Iterable<GetFixtureMarketsResultElement>>(){},
            "/Inplay/GetFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest) {
        return this.client.postRequest(
            getEventsRequest,
            new TypeReference<Iterable<GetEventsResultElement>>(){},
            "/Inplay/GetEvents");
    }
}