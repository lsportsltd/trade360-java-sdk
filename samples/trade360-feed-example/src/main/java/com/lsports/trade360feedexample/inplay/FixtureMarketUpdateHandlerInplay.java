package com.lsports.trade360feedexample.inplay;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.LivescoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;


public class FixtureMarketUpdateHandlerInplay implements EntityHandling {
    @Override
    public void Process() {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }
}