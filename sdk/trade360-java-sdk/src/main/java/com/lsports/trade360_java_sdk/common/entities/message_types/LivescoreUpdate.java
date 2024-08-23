package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import jakarta.annotation.Nullable;

public class LivescoreUpdate {

    @JsonIgnore
    public final static int entityKey = 2;

    @Nullable
    public Iterable<LivescoreEvent> events;
}
