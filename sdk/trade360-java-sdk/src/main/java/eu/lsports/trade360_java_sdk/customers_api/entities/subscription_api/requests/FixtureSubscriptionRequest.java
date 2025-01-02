package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

/**
 * Represents a request to subscribe to specific fixtures.
 *
 * @param fixtures The IDs of the fixtures to be subscribed to
 */
public record FixtureSubscriptionRequest(Iterable<Integer> fixtures) {
}