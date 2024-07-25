package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;

public class FixtureMetadataUpdate {

    public final int EntityKey = 1;

    public Iterable<FixtureEvent> Events;
}
