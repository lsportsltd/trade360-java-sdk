package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import jakarta.annotation.Nullable;

/**
 * Represents a base request for the subscription API.
 */
public class BaseRequest {
    /**
     * The ID of the customer package.
     */
    public int packageId;

    /**
     * The username for authentication.
     */
    @Nullable
    public String userName;

    /**
     * The password for authentication.
     */
    @Nullable public String password;
}
