package com.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.*;
import com.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import reactor.core.publisher.Mono;

/**
 * The {@code MetadataApiClientImplementation} class implements the {@link MetadataApiClient} interface to interact with the metadata API.
 */
public class MetadataApiClientImplementation implements MetadataApiClient {
    private final ApiRestClient client;

    /**
     * Constructs a new {@code MetadataApiClientImplementation} with the specified {@link ApiRestClient}.
     *
     * @param client the {@link ApiRestClient}
     */
    public MetadataApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetSportsResponse> getSports() {
        return this.getSports(new GetSportsRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetSportsResponse> getSports(GetSportsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetSportsResponse>() {},
            "Sports/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetLocationsResponse> getLocations() {
        return this.getLocations(new GetLocationsRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetLocationsResponse> getLocations(GetLocationsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetLocationsResponse>() {},
            "Locations/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetLeaguesResponse> getLeagues(GetLeaguesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetLeaguesResponse>() {},
            "Leagues/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetMarketsResponse> getMarkets(GetMarketsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetMarketsResponse>() {},
            "Markets/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetTranslationsResponse> getTranslations(GetTranslationsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetTranslationsResponse>() {},
            "Translation/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetCompetitionsResponse> getCompetitions(GetCompetitionsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetCompetitionsResponse>() {},
            "Outright/GetCompetitions"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetSubscribedFixturesResponse> getSubscribedFixtures(GetSubscribedFixturesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetSubscribedFixturesResponse>() {},
            "Fixtures/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetSubscribedFixturesMetadataResponse> getSubscribedFixturesMetadata(GetSubscribedFixturesMetadataRequest request) {
        return this.client.getRequest(
            request,
            new TypeReference<GetSubscribedFixturesMetadataResponse>() {},
            "Fixtures/GetSubscribedMetaData"
        );
    }
}