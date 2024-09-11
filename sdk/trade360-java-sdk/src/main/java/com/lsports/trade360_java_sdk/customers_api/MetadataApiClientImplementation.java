package com.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetLeaguesResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetLocationsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSportsResponse;
import com.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import reactor.core.publisher.Mono;

public class MetadataApiClientImplementation implements MetadataApiClient {
    private final ApiRestClient client;

    public MetadataApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    @Override
    public Mono<GetSportsResponse> getSports() {
        return this.getSports(new GetSportsRequest());
    }

    @Override
    public Mono<GetSportsResponse> getSports(GetSportsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetSportsResponse>() {},
            "Sports/Get"
        );
    }

    @Override
    public Mono<GetLocationsResponse> getLocations() {
        return this.getLocations(new GetLocationsRequest());
    }

    @Override
    public Mono<GetLocationsResponse> getLocations(GetLocationsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetLocationsResponse>() {},
            "Locations/Get"
        );
    }

    @Override
    public Mono<GetLeaguesResponse> getLeagues(GetLeaguesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<GetLeaguesResponse>() {},
            "Leagues/Get"
        );
    }
}
