package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.*;

public class Scoreboard {
    
    public FixtureStatus status;

    public StatusDescription description;

    public int currentPeriod;

    public String time;

    public Iterable<Result> results;
}
