package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.*;

public class Scoreboard {
    
    public FixtureStatus Status;

    public StatusDescription Description;

    public int CurrentPeriod;

    public String Time;

    public Iterable<Result> Results;
}
