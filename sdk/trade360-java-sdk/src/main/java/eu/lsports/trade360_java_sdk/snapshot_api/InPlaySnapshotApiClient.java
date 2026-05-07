package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;

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
    Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest getFixturesRequest);
    
    /**
     * Gets the live scores based on the provided request.
     *
     * @param getLivescoreRequestDto The request containing the parameters
     * @return A {@link Mono} emitting the live scores
     * @see GetLivescoreResultElement
     */
    Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest getLivescoreRequestDto);

    /**
     * Gets the fixture markets based on the provided request.
     *
     * @param getFixtureMarketsRequest The request containing the parameters
     * @return A {@link Mono} emitting the fixture markets
     * @see GetFixtureMarketsResultElement
     */
    Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest getFixtureMarketsRequest);

    /**
     * Gets the events based on the provided request.
     *
     * @param getEventsRequest The request containing the parameters
     * @return A {@link Mono} emitting the events
     * @see GetEventsResultElement
     */
    Mono<Iterable<GetEventsResultElement>> getEvents(GetInPlayEventRequest getEventsRequest);
    /**
     * Gets the outright leagues based on the provided request.
     *
     * @param getOutrightLeaguesRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright leagues
     * @see GetOutrightLeaguesResultElement
     */
    Mono<Iterable<GetOutrightLeaguesResultElement>> getOutrightLeagues(GetOutrightLeaguesRequest getOutrightLeaguesRequest);

    /**
     * Gets the outright league markets based on the provided request.
     *
     * @param getOutrightLeaguesMarketsRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright league markets
     * @see GetOutrightLeagueMarketsResultElement
     */
    Mono<Iterable<GetOutrightLeagueMarketsResultElement>> getOutrightLeagueMarkets(GetOutrightLeagueMarketRequest getOutrightLeaguesMarketsRequest);

    /**
     * Gets the outright league events based on the provided request.
     *
     * @param getOutrightLeagueEventsRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright league markets
     * @see GetOutrightLeagueEventsResultElement
     */
    Mono<Iterable<GetOutrightLeagueEventsResultElement>> getOutrightLeagueEvents(GetOutrightLeagueEventsRequest getOutrightLeagueEventsRequest);
}