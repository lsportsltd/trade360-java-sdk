package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;

import reactor.core.publisher.Mono;

/**
 * Interface for the In-Play Snapshot API client.
 */
public interface InPlaySnapshotApiClient {

    /**
     * Gets the fixtures based on the provided request.
     *
     * @param getFixturesRequest The request containing the parameters
     * @return A {@link Mono} emitting the fixtures
     * @see GetFixturesResultElement
     */
    Mono<Iterable<GetFixturesResultElement>> getFixtures(GetSnapshotRequest getFixturesRequest);
    
    /**
     * Gets the live scores based on the provided request.
     *
     * @param getLivescoreRequestDto The request containing the parameters
     * @return A {@link Mono} emitting the live scores
     * @see GetLivescoreResultElement
     */
    Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetSnapshotRequest getLivescoreRequestDto);

    /**
     * Gets the fixture markets based on the provided request.
     *
     * @param getFixtureMarketsRequest The request containing the parameters
     * @return A {@link Mono} emitting the fixture markets
     * @see GetFixtureMarketsResultElement
     */
    Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetSnapshotRequest getFixtureMarketsRequest);

    /**
     * Gets the events based on the provided request.
     *
     * @param getEventsRequest The request containing the parameters
     * @return A {@link Mono} emitting the events
     * @see GetEventsResultElement
     */
    Mono<Iterable<GetEventsResultElement>> getEvents(GetSnapshotRequest getEventsRequest);
}