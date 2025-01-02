package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetProviderOddsTypeResponse;
import reactor.core.publisher.Mono;

/**
 * The Package Query API client.
 */
public interface PackageQueryApiClient {
    /**
     * Gets the distribution status.
     *
     * @return A {@link Mono} emitting the {@link GetProviderOddsTypeResponse}
     */
    Mono<BaseResponse<GetProviderOddsTypeResponse>> getProviderOddsType();

}