package com.lsports.trade360_java_sdk.snapshot_api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.LivescoreElement;

@Service
class InPlaySnapshotApiClientImplementation implements InPlaySnapshotApiClient {
    private final SnapshotApiRestClient client;

    public InPlaySnapshotApiClientImplementation(
        SnapshotApiRestClientFactory clientFactory,
        RestClient.Builder restBuilder,
        @Qualifier(SnapshotApiBeanNames.INPLAY_API_SETTINGS) SnapshotApiSettings settings) {
        this.client = clientFactory.getService(restBuilder, settings);
    }
    
    @Override
    public Iterable<FixtureEvent> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception {
        return this.client.postRequest(getFixturesRequest, "/Inplay/GetFixtures");
    }

    @Override
    public Iterable<LivescoreElement> getLivescore(GetLivescoreRequestDto getLivescoreRequest) throws Trade360Exception {
        return this.client.postRequest(getLivescoreRequest, "/Inplay/GetScores");
    }
}
