package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.Entity;

public class FixtureMetadataUpdate  {
   @JsonIgnore
   public final static int entityKey = 1;

   public Iterable<FixtureEvent> events;
}
