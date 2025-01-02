package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import jakarta.annotation.Nullable;

/**
 * Represents a request to change manual suspensions.
 *
 * @param suspensions The suspensions to be changed
 * @see Suspension
 */
public record ChangeManualSuspensionRequest(@Nullable Iterable<Suspension> suspensions) {
}