package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightScoreUpdate {

    public final int entityKey = 39;

    public Iterable<OutrightCompetition<OutrightScoreEvent>> competitions;
}
