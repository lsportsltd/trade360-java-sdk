package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StopDistributionResponse;
import reactor.core.publisher.Mono;

/**
 * The Package Distribution API client.
 */
public interface PackageDistributionApiClient {
    /**
     * Gets the distribution status.
     *
     * @return A {@link Mono} emitting the {@link GetDistributionStatusResponse}
     */
    Mono<BaseResponse<GetDistributionStatusResponse>> getDistributionStatus();

    /**
     * Starts the distribution.
     *
     * @return A {@link Mono} emitting the {@link StartDistributionResponse}
     */
    Mono<BaseResponse<StartDistributionResponse>> startDistribution();

    /**
     * Stops the distribution.
     *
     * @return A {@link Mono} emitting the {@link StopDistributionResponse}
     */
    Mono<BaseResponse<StopDistributionResponse>> stopDistribution();
}