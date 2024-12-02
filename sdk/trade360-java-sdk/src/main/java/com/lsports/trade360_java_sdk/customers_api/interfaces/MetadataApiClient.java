package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.*;
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
}