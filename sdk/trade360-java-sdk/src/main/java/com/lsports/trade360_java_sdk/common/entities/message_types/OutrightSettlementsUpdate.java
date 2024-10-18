package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightSettlementsUpdate} class represents an update to the settlements of outright competitions.
 */
public class OutrightSettlementsUpdate {

    /**
     * The entity key for the outright settlements update.
     */
    @JsonIgnore
    public final static int entityKey = 42;

    /**
     * The competitions associated with the outright settlements update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<OutrightCompetition<MarketEvent>> competitions;
}