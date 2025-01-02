package eu.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetProviderOddsTypeResponse;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link SubscriptionApiClient} interface.
 */
public class PackageQueryApiClientImplementation implements PackageQueryApiClient {

    private final ApiRestClient client;

    /**
     * Constructs a new {@code PackageDistributionApiClientImplementation} with the specified API REST client.
     *
     * @param client the API REST client
     */
    public PackageQueryApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetProviderOddsTypeResponse>> getProviderOddsType() {
        return this.client
                .getRequest(
                        null,
                        new TypeReference<BaseResponse<GetProviderOddsTypeResponse>>() {},
                        "Package/GetProviderOddsType");
    }
}
