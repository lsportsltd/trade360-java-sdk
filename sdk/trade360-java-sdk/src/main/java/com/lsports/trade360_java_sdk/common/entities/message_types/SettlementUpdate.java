package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;

public class SettlementUpdate {

    @JsonIgnore
    public final static int entityKey = 35;

    @Nullable
    public Iterable<MarketEvent> events;
}
