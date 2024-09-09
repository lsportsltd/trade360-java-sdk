package com.lsports.trade360_java_sdk.customers_api.interfaces;


import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetLocationsResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSportsResponse;
import reactor.core.publisher.Mono;

public interface MetadataApiClient {
    Mono<GetSportsResponse> getSports();

    Mono<GetSportsResponse> getSports(GetSportsRequest request);

    Mono<GetLocationsResponse> getLocations();

    Mono<GetLocationsResponse> getLocations(GetLocationsRequest request);
}