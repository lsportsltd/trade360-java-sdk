package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;

import reactor.core.publisher.Mono;

public interface InPlaySnapshotApiClient {
    Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest);
    
    Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequestDto);

    Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getFixtureMarketsRequest);

    Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest);
}
