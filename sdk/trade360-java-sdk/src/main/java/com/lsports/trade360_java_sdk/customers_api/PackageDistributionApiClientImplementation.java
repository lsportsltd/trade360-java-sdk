package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StopDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.interfaces.PackageDistributionApiClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;

public class PackageDistributionApiClientImplementation implements PackageDistributionApiClient {

    private final ApiRestClient client;

    public PackageDistributionApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    @Override
    public Mono<GetDistributionStatusResponse> getDistributionStatusAsync() {
        return this.client
                .postRequest(
                        new TypeReference<GetDistributionStatusResponse>() {},
                        "Package/GetDistributionStatus");
    }

    @Override
    public Mono<StartDistributionResponse> StartDistribution() {
        return this.client
                .postRequest(
                        new TypeReference<StartDistributionResponse>() {},
                        "Distribution/Start");
    }

    @Override
    public Mono<StopDistributionResponse> StopDistribution() {
        return this.client
                .postRequest(
                        new TypeReference<StopDistributionResponse>() {},
                        "Distribution/Stop");
    }
}
