package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.LivescoreElement;

public class PreMatchSnapshotApiClientImplementation implements PreMatchSnapshotApiClient {
    private final SnapshotApiRestClient client;

    public PreMatchSnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    @Override
    public Iterable<FixtureEvent> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception {
        return this.client.postRequest(getFixturesRequest, "/Prematch/GetFixtures");
    }

    @Override
    public Iterable<LivescoreElement> getLivescore(GetLivescoreRequestDto getLivescoreRequest)
            throws Trade360Exception {
        return this.client.postRequest(getLivescoreRequest, "/Prematch/GetScores");
    }
}
