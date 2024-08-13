package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.*;
import jakarta.annotation.Nullable;

public class Scoreboard {
    
    public FixtureStatus status;

    public StatusDescription description;

    public int currentPeriod;

    @Nullable public String time;

    @Nullable public Iterable<Result> results;
}
