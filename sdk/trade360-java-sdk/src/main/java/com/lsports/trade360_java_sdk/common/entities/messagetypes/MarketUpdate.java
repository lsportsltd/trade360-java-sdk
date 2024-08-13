package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MarketUpdate  {
    @JsonIgnore
    public final static int entityKey = 3;

    @Nullable
    public Iterable<MarketEvent> events;
}
