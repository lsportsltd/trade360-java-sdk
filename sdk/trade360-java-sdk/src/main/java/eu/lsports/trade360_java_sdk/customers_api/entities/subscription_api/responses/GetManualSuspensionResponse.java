package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;

/**
 * Represents the response for getting manual suspensions.
 */
public class GetManualSuspensionResponse {

    /**
     * Indicates whether the request was successful.
     */
    public Boolean succeeded;

    /**
     * The suspensions retrieved.
     *
     * @see Suspension
     */
    public Iterable<Suspension> suspensions;
}