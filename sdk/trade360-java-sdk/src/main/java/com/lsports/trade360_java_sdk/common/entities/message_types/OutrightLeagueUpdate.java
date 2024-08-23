package com.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

public class OutrightLeagueUpdate {

    @JsonIgnore
    public final static int entityKey = 38;

    @Nullable
    public Iterable<OutrightCompetition<OutrightLeagueEvent>> competitions;
}
