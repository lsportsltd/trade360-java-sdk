package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StopDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.interfaces.PackageDistributionApiClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The {@code PackageDistributionApiClientImplementation} class implements the {@link PackageDistributionApiClient} interface to interact with the package distribution API.
 */
public class PackageDistributionApiClientImplementation implements PackageDistributionApiClient {

    private final ApiRestClient client;

    /**
     * Constructs a new {@code PackageDistributionApiClientImplementation} with the specified API REST client.
     *
     * @param client the API REST client
     */
    public PackageDistributionApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<GetDistributionStatusResponse> getDistributionStatus() {
        return this.client
                .postRequest(
                        new TypeReference<GetDistributionStatusResponse>() {},
                        "Package/GetDistributionStatus");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<StartDistributionResponse> startDistribution() {
        return this.client
                .postRequest(
                        new TypeReference<StartDistributionResponse>() {},
                        "Distribution/Start");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<StopDistributionResponse> stopDistribution() {
        return this.client
                .postRequest(
                        new TypeReference<StopDistributionResponse>() {},
                        "Distribution/Stop");
    }
}