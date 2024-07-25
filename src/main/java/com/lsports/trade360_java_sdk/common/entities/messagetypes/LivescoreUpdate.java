package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;

public class LivescoreUpdate {

    public final int EntityKey = 2;

    public Iterable<LivescoreEvent> Events;
}
