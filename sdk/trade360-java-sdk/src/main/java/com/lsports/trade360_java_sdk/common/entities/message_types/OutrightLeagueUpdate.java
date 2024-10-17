package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueUpdate} class represents an update to the outright leagues.
 */
public class OutrightLeagueUpdate {

    /**
     * The entity key for the outright league update.
     */
    @JsonIgnore
    public final static int entityKey = 38;

    /**
     * The competitions associated with the outright league update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<OutrightCompetition<OutrightLeagueEvent>> competitions;
}