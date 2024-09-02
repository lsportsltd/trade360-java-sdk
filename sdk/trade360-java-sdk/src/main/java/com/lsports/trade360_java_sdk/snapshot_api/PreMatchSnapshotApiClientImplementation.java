package com.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightFixtureResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightLeagueMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightLeaguesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightScoresResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

import reactor.core.publisher.Mono;

public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final SnapshotApiRestClient client;

    public PreMatchSnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    @Override
    public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest) {
        return this.client.postRequest(
            getFixturesRequest,
            new TypeReference<Iterable<GetFixturesResultElement>>() {},
        "/Prematch/GetFixtures");
    }

    @Override
    public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequest) {
        return this.client.postRequest(
            getLivescoreRequest,
            new TypeReference<Iterable<GetLivescoreResultElement>>() {},
            "/Prematch/GetScores");
    }

    @Override
    public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getMarketRequest) {
        return this.client.postRequest(
            getMarketRequest,
            new TypeReference<Iterable<GetFixtureMarketsResultElement>>() {},
            "/Prematch/GetFixtureMarkets");
    }

    @Override
    public Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest) {
        return this.client.postRequest(
            getEventsRequest,
            new TypeReference<Iterable<GetEventsResultElement>>() {},
            "/Prematch/GetEvents");
    }

    @Override
    public Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetSnapshotRequest getOutrightEventsRequest) {
        return this.client.postRequest(
            getOutrightEventsRequest,
            new TypeReference<Iterable<GetOutrightEventsResultElement>>() {},
            "/Prematch/GetOutrightEvents");
    }

    @Override
    public Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetSnapshotRequest getOutrightFixtureRequest) {
        return this.client.postRequest(
            getOutrightFixtureRequest,
            new TypeReference<Iterable<GetOutrightFixtureResultElement>>() {},
            "/Prematch/GetOutrightFixture");
    }

    @Override
    public Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetSnapshotRequest getOutrightScoresRequest) {
        return this.client.postRequest(
            getOutrightScoresRequest,
            new TypeReference<Iterable<GetOutrightScoresResultElement>>() {},
            "/Prematch/GetOutrightScores");
    }

    @Override
    public Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetSnapshotRequest getOutrightFixtureMarketsRequest) {
        return this.client.postRequest(
            getOutrightFixtureMarketsRequest,
            new TypeReference<Iterable<GetOutrightFixtureMarketsResultElement>>() {},
            "/Prematch/GetOutrightFixtureMarkets");
    }

    @Override
    public Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetSnapshotRequest getOutrightLeaguesRequest) {
        return this.client.postRequest(
            getOutrightLeaguesRequest,
            new TypeReference<Iterable<GetOutrightLeaguesResultElement>>() {},
            "/Prematch/GetOutrightLeagues");
    }

    @Override
    public Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetSnapshotRequest getOutrightLeagueMarketsRequest) {
        return this.client.postRequest(
            getOutrightLeagueMarketsRequest,
            new TypeReference<Iterable<GetOutrightLeagueMarketsResultElement>>() {},
            "/Prematch/GetOutrightLeagueMarkets");
    }
}
