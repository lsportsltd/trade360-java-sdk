package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightScoreUpdate} class represents an update to the scores of outright competitions.
 */
public class OutrightScoreUpdate {

    /**
     * The entity key for the outright score update.
     */
    @JsonIgnore
    public final static int entityKey = 39;

    /**
     * The competition associated with the outright score update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightCompetition<OutrightScoreEvent> competition;
}