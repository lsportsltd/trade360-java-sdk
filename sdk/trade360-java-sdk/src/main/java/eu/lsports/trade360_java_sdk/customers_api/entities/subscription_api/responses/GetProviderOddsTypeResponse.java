package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.ProviderOddsType;
import jakarta.annotation.Nullable;

/**
 * Represents the response for provider odds type
 */
public class GetProviderOddsTypeResponse {
    /**
     * The provider odds type
     */
    @Nullable public ProviderOddsType providerOddsType;
}