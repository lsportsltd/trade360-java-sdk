package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;

public interface InPlaySnapshotApiClient {
    Iterable<GetFixturesResultElement> getFixtures(GetSnapshotRequest getFixturesRequest) throws Trade360Exception;
    
    Iterable<GetLivescoreResultElement> getLivescore(GetSnapshotRequest getLivescoreRequestDto) throws Trade360Exception;

    Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetSnapshotRequest getFixtureMarketsRequest) throws Trade360Exception;

    Iterable<GetEventsResultElement> getEvents(GetSnapshotRequest getEventsRequest) throws Trade360Exception;
}
