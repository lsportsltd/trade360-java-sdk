package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response for changing manual suspensions.
 */
public class ChangeManualSuspensionResponse {

    /**
     * The suspensions that were changed.
     *
     * @see SuspensionChangeResponse
     */
    @Nullable public Iterable<SuspensionChangeResponse> suspensions;
}