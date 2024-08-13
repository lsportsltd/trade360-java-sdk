package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightLeagueUpdate {
    @JsonIgnore
    public final static int entityKey = 38;

    public Iterable<OutrightCompetition<OutrightLeagueEvent>> competitions;
}
