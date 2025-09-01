package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.*;
import reactor.core.publisher.Mono;

/**
 * Interface for the Pre-Match Snapshot API client.
 */
public interface PreMatchSnapshotApiClient {

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
    Mono<Iterable<GetEventsResultElement>> getEvents(GetEventRequest getEventsRequest);

    /**
     * Gets the outright events based on the provided request.
     *
     * @param getOutrightEventsRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright events
     * @see GetOutrightEventsResultElement
     */
    Mono<Iterable<GetOutrightEventsResultElement>> getOutrightEvents(GetOutrightEventRequest getOutrightEventsRequest);

    /**
     * Gets the outright fixture based on the provided request.
     *
     * @param getOutrightFixtureRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright fixture
     * @see GetOutrightFixtureResultElement
     */
    Mono<Iterable<GetOutrightFixtureResultElement>> getOutrightFixture(GetOutrightFixtureRequest getOutrightFixtureRequest);

    /**
     * Gets the outright scores based on the provided request.
     *
     * @param getOutrightScoresRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright scores
     * @see GetOutrightScoresResultElement
     */
    Mono<Iterable<GetOutrightScoresResultElement>> getOutrightScores(GetOutrightLivescoreRequest getOutrightScoresRequest);

    /**
     * Gets the outright fixture markets based on the provided request.
     *
     * @param getOutrightFixtureMarketsRequest The request containing the parameters
     * @return A {@link Mono} emitting the outright fixture markets
     * @see GetOutrightFixtureMarketsResultElement
     */
    Mono<Iterable<GetOutrightFixtureMarketsResultElement>> getOutrightFixtureMarkets(GetOutrightMarketRequest getOutrightFixtureMarketsRequest);

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