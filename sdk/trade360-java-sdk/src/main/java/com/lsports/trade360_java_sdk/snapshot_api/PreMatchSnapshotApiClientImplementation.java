package com.lsports.trade360_java_sdk.snapshot_api;

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

public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final SnapshotApiRestClient client;

    public PreMatchSnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    @Override
    public Iterable<GetFixturesResultElement> getFixtures(GetSnapshotRequest getFixturesRequest) throws Trade360Exception {
        return this.client.postRequest(getFixturesRequest, "/Prematch/GetFixtures");
    }

    @Override
    public Iterable<GetLivescoreResultElement> getLivescore(GetSnapshotRequest getLivescoreRequest) throws Trade360Exception {
        return this.client.postRequest(getLivescoreRequest, "/Prematch/GetScores");
    }

    @Override
    public Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetSnapshotRequest getMarketRequest) throws Trade360Exception {
        return this.client.postRequest(getMarketRequest, "/Prematch/GetFixtureMarkets");
    }

    @Override
    public Iterable<GetEventsResultElement> getEvents(GetSnapshotRequest getEventsRequest) throws Trade360Exception {
        return this.client.postRequest(getEventsRequest, "/Prematch/GetEvents");
    }

    @Override
    public Iterable<GetOutrightEventsResultElement> getOutrightEvents(GetSnapshotRequest getOutrightEventsRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightEventsRequest, "/Prematch/GetOutrightEvents");
    }

    @Override
    public Iterable<GetOutrightFixtureResultElement> getOutrightFixture(GetSnapshotRequest getOutrightFixtureRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightFixtureRequest, "/Prematch/GetOutrightFixture");
    }

    @Override
    public Iterable<GetOutrightScoresResultElement> getOutrightScores(GetSnapshotRequest getOutrightScoresRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightScoresRequest, "/Prematch/GetOutrightScores");
    }

    @Override
    public Iterable<GetOutrightFixtureMarketsResultElement> getOutrightFixtureMarkets(GetSnapshotRequest getOutrightFixtureMarketsRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightFixtureMarketsRequest, "/Prematch/GetOutrightFixtureMarkets");
    }

    @Override
    public Iterable<GetOutrightLeaguesResultElement> getOutrightLeagues(GetSnapshotRequest getOutrightLeaguesRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightLeaguesRequest, "/Prematch/GetOutrightLeagues");
    }

    @Override
    public Iterable<GetOutrightLeagueMarketsResultElement> getOutrightLeagueMarkets(GetSnapshotRequest getOutrightLeagueMarketsRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightLeagueMarketsRequest, "/Prematch/GetOutrightLeagueMarkets");
    }
}
