package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StopDistributionResponse;
import reactor.core.publisher.Mono;

public interface PackageDistributionApiClient {
    Mono<GetDistributionStatusResponse> getDistributionStatusAsync();

    Mono<StartDistributionResponse> startDistribution();

    Mono<StopDistributionResponse> stopDistribution();
}
