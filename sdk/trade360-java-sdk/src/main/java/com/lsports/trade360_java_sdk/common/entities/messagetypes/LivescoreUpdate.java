package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.Entity;

public class LivescoreUpdate  {
    @JsonIgnore
    public final static int entityKey = 2;

    public Iterable<LivescoreEvent> events;
}
