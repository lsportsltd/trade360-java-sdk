package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightLeagueUpdate {

    public final int entityKey = 38;

    public Iterable<OutrightCompetition<OutrightLeagueEvent>> competitions;
}
