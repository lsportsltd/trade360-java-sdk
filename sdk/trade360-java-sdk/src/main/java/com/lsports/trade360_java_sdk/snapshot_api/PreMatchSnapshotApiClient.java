package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightFixtureResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightLeaguesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetOutrightScoresResultElement;

public interface PreMatchSnapshotApiClient {
    Iterable<GetFixturesResultElement> getFixtures(GetSnapshotRequest getFixturesRequest) throws Trade360Exception;

    Iterable<GetLivescoreResultElement> getLivescore(GetSnapshotRequest getLivescoreRequestDto) throws Trade360Exception;
    
    Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetSnapshotRequest getFixtureMarketsRequest) throws Trade360Exception;

    Iterable<GetEventsResultElement> getEvents(GetSnapshotRequest getEventsRequest) throws Trade360Exception;

    Iterable<GetOutrightEventsResultElement> getOutrightEvents(GetSnapshotRequest getOutrightEventsRequest) throws Trade360Exception;

    Iterable<GetOutrightFixtureResultElement> getOutrightFixture(GetSnapshotRequest getOutrightFixtureRequest) throws Trade360Exception;

    Iterable<GetOutrightScoresResultElement> getOutrightScores(GetSnapshotRequest getOutrightScoresRequest) throws Trade360Exception;

    Iterable<GetOutrightFixtureMarketsResultElement> getOutrightFixtureMarkets(GetSnapshotRequest getOutrightFixtureMarketsRequest) throws Trade360Exception;

    Iterable<GetOutrightLeaguesResultElement> getOutrightLeagues(GetSnapshotRequest getOutrightLeaguesRequest) throws Trade360Exception;
}
