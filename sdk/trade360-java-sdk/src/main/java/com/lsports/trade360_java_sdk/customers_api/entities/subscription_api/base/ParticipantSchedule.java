package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

/**
 * Represents a participant in a fixture schedule.
 */
public class ParticipantSchedule {
    /**
     * The ID of the participant.
     */
    public int id;

    /**
     * The position of the participant.
     */
    public int position;

    /**
     * The name of the participant.
     */
    @Nullable public String name;
}