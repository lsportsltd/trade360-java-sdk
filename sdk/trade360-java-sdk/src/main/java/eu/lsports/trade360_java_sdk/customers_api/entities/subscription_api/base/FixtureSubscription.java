package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

/**
 * Represents a subscription to a specific fixture.
 */
public class FixtureSubscription {
    /**
     * The ID of the fixture.
     */
    public int fixtureId;

    /**
     * Indicates whether the subscription was successful.
     */
    public Boolean success;
}