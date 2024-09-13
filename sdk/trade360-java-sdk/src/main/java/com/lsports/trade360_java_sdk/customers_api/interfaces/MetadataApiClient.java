package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetCompetitionsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetMarketsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesMetadataRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetTranslationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetCompetitionsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetLeaguesResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetLocationsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetMarketsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSportsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSubscribedFixturesMetadataResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSubscribedFixturesResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetTranslationsResponse;

import reactor.core.publisher.Mono;

public interface MetadataApiClient {
    Mono<GetSportsResponse> getSports();

    Mono<GetSportsResponse> getSports(GetSportsRequest request);

    Mono<GetLocationsResponse> getLocations();

    Mono<GetLocationsResponse> getLocations(GetLocationsRequest request);

    Mono<GetLeaguesResponse> getLeagues(GetLeaguesRequest request);
    
    Mono<GetMarketsResponse> getMarkets(GetMarketsRequest request);

    Mono<GetTranslationsResponse> getTranslations(GetTranslationsRequest request);

    Mono<GetCompetitionsResponse> getCompetitions(GetCompetitionsRequest request);

    Mono<GetSubscribedFixturesResponse> getSubscribedFixtures(GetSubscribedFixturesRequest request);

    Mono<GetSubscribedFixturesMetadataResponse> getSubscribedFixturesMetadata(GetSubscribedFixturesMetadataRequest request);
}