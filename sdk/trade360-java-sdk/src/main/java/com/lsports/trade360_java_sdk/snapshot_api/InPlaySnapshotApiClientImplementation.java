package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

public class InPlaySnapshotApiClientImplementation implements InPlaySnapshotApiClient {
    private final SnapshotApiRestClient client;

    public InPlaySnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    @Override
    public Iterable<GetFixturesResultElement> getFixtures(GetSnapshotRequest getFixturesRequest) throws Trade360Exception {
        return this.client.postRequest(getFixturesRequest, "/Inplay/GetFixtures");
    }

    @Override
    public Iterable<GetLivescoreResultElement> getLivescore(GetSnapshotRequest getLivescoreRequest) throws Trade360Exception {
        return this.client.postRequest(getLivescoreRequest, "/Inplay/GetScores");
    }

    @Override
    public Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetSnapshotRequest getMarketRequest) throws Trade360Exception {
        return this.client.postRequest(getMarketRequest, "/Inplay/GetFixtureMarkets");
    }

    @Override
    public Iterable<GetEventsResultElement> getEvents(GetSnapshotRequest getEventsRequest) throws Trade360Exception {
        return this.client.postRequest(getEventsRequest, "/Inplay/GetEvents");
    }
}
