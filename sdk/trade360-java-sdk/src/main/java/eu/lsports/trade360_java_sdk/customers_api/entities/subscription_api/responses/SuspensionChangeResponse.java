package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.SuspendedMarket;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * Represents the response for a suspension change.
 */
public class SuspensionChangeResponse {

    /**
     * Indicates whether the suspension change was successful.
     */
    public Boolean succeeded;

    /**
     * The reason for the suspension change, if any.
     */
    @Nullable public String reason;

    /**
     * The ID of the fixture, if applicable.
     */
    @Nullable public Integer fixtureId;

    /**
     * The ID of the sport, if applicable.
     */
    @Nullable public Integer sportId;

    /**
     * The ID of the Location, if applicable.
     */
    @Nullable public Integer locationId;
    /**
     * The ID of the Competition, if applicable.
     */
    @Nullable public Integer competitionId;


    /**
     * The markets associated with the suspension change.
     *
     * @see SuspendedMarket
     */
    @Nullable public Iterable<SuspendedMarket> markets;

    @Nullable public LocalDateTime creationDate;


}