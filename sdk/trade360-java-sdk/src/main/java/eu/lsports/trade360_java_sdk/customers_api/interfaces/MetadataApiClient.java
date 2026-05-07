package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.*;
import reactor.core.publisher.Mono;

/**
 * The Metadata API client.
 */
public interface MetadataApiClient {

    /**
     * Retrieves the list of sports.
     *
     * @return a {@link Mono} emitting the response containing the list of sports
     * @see GetSportsResponse
     */
    Mono<BaseResponse<GetSportsResponse>> getSports();

    /**
     * Retrieves the list of sports based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of sports
     * @return a {@link Mono} emitting the response containing the list of sports
     * @see GetSportsResponse
     */
    Mono<BaseResponse<GetSportsResponse>> getSports(GetSportsRequest request);

    /**
     * Retrieves the list of locations.
     *
     * @return a {@link Mono} emitting the response containing the list of locations
     * @see GetLocationsResponse
     */
    Mono<BaseResponse<GetLocationsResponse>> getLocations();

    /**
     * Retrieves the list of locations based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of locations
     * @return a {@link Mono} emitting the response containing the list of locations
     * @see GetLocationsResponse
     */
    Mono<BaseResponse<GetLocationsResponse>> getLocations(GetLocationsRequest request);

    /**
     * Retrieves the list of leagues based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of leagues
     * @return a {@link Mono} emitting the response containing the list of leagues
     * @see GetLeaguesResponse
     */
    Mono<BaseResponse<GetLeaguesResponse>> getLeagues(GetLeaguesRequest request);

    /**
     * Retrieves the list of markets based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of markets
     * @return a {@link Mono} emitting the response containing the list of markets
     * @see GetMarketsResponse
     */
    Mono<BaseResponse<GetMarketsResponse>> getMarkets(GetMarketsRequest request);

    /**
     * Retrieves the list of translations based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of translations
     * @return a {@link Mono} emitting the response containing the list of translations
     * @see GetTranslationsResponse
     */
    Mono<BaseResponse<GetTranslationsResponse>> getTranslations(GetTranslationsRequest request);

    /**
     * Retrieves the list of competitions based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of competitions
     * @return a {@link Mono} emitting the response containing the list of competitions
     * @see GetCompetitionsResponse
     */
    Mono<BaseResponse<GetCompetitionsResponse>> getCompetitions(GetCompetitionsRequest request);

    /**
     * Retrieves the list of subscribed fixtures based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of subscribed fixtures
     * @return a {@link Mono} emitting the response containing the list of subscribed fixtures
     * @see GetSubscribedFixturesResponse
     */
    Mono<BaseResponse<GetSubscribedFixturesResponse>> getSubscribedFixtures(GetSubscribedFixturesRequest request);

    /**
     * Retrieves the metadata of subscribed fixtures based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the metadata of subscribed fixtures
     * @return a {@link Mono} emitting the response containing the metadata of subscribed fixtures
     * @see GetSubscribedFixturesMetadataResponse
     */
    Mono<BaseResponse<GetSubscribedFixturesMetadataResponse>> getSubscribedFixturesMetadata(GetSubscribedFixturesMetadataRequest request);

    /**
     * Retrieves a list of incidents based on the specified request.
     *
     * @param request A request containing filter parameters for retrieving incidents data
     * @return a {@link Mono} emitting the response containing the data of selected incidents
     * @see GetIncidentsResponse
     */
    Mono<BaseResponse<GetIncidentsResponse>> getIncidents(GetIncidentsRequest request);

    /**
     * Retrieves the list of venues based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of venues
     * @return a {@link Mono} emitting the response containing the list of venues
     * @see GetVenuesResponse
     */
    Mono<BaseResponse<GetVenuesResponse>> getVenues(GetVenuesRequest request);

    /**
     * Retrieves the list of cities based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of cities
     * @return a {@link Mono} emitting the response containing the list of cities
     * @see GetCitiesResponse
     */
    Mono<BaseResponse<GetCitiesResponse>> getCities(GetCitiesRequest request);

    /**
     * Retrieves the list of states based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of states
     * @return a {@link Mono} emitting the response containing the list of states
     * @see GetStatesResponse
     */
    Mono<BaseResponse<GetStatesResponse>> getStates(GetStatesRequest request);

    /**
     * Retrieves the list of participants based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of participants
     * @return a {@link Mono} emitting the response containing the list of participants
     * @see GetParticipantsResponse
     */
    Mono<BaseResponse<GetParticipantsResponse>> getParticipants(GetParticipantsRequest request);

    /**
     * Retrieves the list of seasons.
     *
     * @return a {@link Mono} emitting the response containing the list of seasons
     * @see GetSeasonsResponse
     */
    Mono<BaseResponse<GetSeasonsResponse>> getSeasons();

    /**
     * Retrieves the list of seasons based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of seasons
     * @return a {@link Mono} emitting the response containing the list of seasons
     * @see GetSeasonsResponse
     */
    Mono<BaseResponse<GetSeasonsResponse>> getSeasons(GetSeasonsRequest request);

    /**
     * Retrieves the list of tours.
     *
     * @return a {@link Mono} emitting the response containing the list of tours
     * @see GetToursResponse
     */
    Mono<BaseResponse<GetToursResponse>> getTours();

    /**
     * Retrieves the list of tours based on the specified request.
     *
     * @param request the request containing the parameters for retrieving the list of tours
     * @return a {@link Mono} emitting the response containing the list of tours
     * @see GetToursResponse
     */
    Mono<BaseResponse<GetToursResponse>> getTours(GetToursRequest request);
}