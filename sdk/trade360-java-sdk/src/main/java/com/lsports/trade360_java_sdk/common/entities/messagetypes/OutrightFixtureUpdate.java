package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

public class OutrightFixtureUpdate {

    @JsonIgnore
    public final static int entityKey = 37;

    @Nullable
    public Iterable<OutrightCompetition<OutrightFixtureEvent>> competitions;
}
