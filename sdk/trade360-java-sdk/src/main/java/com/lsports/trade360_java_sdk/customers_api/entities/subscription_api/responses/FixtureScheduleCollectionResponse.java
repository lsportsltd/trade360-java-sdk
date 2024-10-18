package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.FixtureSchedule;
import jakarta.annotation.Nullable;

/**
 * Represents a collection response for fixture schedules.
 */
public class FixtureScheduleCollectionResponse {
    
    /**
     * The fixture schedules.
     *
     * @see FixtureSchedule
     */
    @Nullable public Iterable<FixtureSchedule> fixtures;
}