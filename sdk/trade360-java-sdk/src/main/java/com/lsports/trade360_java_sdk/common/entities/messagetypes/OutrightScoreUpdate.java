package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightScoreUpdate {
    @JsonIgnore
    public final static int entityKey = 39;

    public Iterable<OutrightCompetition<OutrightScoreEvent>> competitions;
}
