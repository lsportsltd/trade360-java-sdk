package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetEventsRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetOutrightEventsDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final SnapshotApiRestClient client;

    public PreMatchSnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    @Override
    public Iterable<GetFixturesResultElement> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception {
        return this.client.postRequest(getFixturesRequest, "/Prematch/GetFixtures");
    }

    @Override
    public Iterable<GetLivescoreResultElement> getLivescore(GetLivescoreRequestDto getLivescoreRequest) throws Trade360Exception {
        return this.client.postRequest(getLivescoreRequest, "/Prematch/GetScores");
    }

    @Override
    public Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetMarketRequestDto getMarketRequest) throws Trade360Exception {
        return this.client.postRequest(getMarketRequest, "/Prematch/GetFixtureMarkets");
    }

    @Override
    public Iterable<GetEventsResultElement> getEvents(GetEventsRequestDto getEventsRequest) throws Trade360Exception {
        return this.client.postRequest(getEventsRequest, "/Prematch/GetEvents");
    }

    @Override
    public Iterable<GetOutrightEventsResultElement> getOutrightEvents(GetOutrightEventsDto getOutrightEventsRequest) throws Trade360Exception {
        return this.client.postRequest(getOutrightEventsRequest, "/Prematch/GetOutrightEvents");
    }
}
