package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents the response for getting the distribution status.
 */
public class GetDistributionStatusResponse {
    /**
     * Indicates whether the distribution is on.
     */
    public Boolean isDistributionOn;

    /**
     * The consumers of the distribution.
     */
    @Nullable public Iterable<String> consumers;

    /**
     * The number of messages in the queue.
     */
    public int numberMessagesInQueue;

    /**
     * The rate of messages per second.
     */
    public double messagesPerSecond;
}