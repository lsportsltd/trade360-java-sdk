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

import reactor.core.publisher.Mono;

public interface PreMatchSnapshotApiClient {
    Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest);

    Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequestDto);
    
    Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getFixtureMarketsRequest);

    Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest);

    Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetSnapshotRequest getOutrightEventsRequest);

    Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetSnapshotRequest getOutrightFixtureRequest);

    Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetSnapshotRequest getOutrightScoresRequest);

    Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetSnapshotRequest getOutrightFixtureMarketsRequest);

    Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetSnapshotRequest getOutrightLeaguesRequest);

    Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetSnapshotRequest getOutrightLeaguesMarketsRequest);
}
