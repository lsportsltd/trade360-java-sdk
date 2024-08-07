package com.lsports.trade360_java_sdk.common.entities.livescore;

public class Period {

    public int type;

    public boolean isFinished;

    public boolean isConfirmed;

    public Iterable<Result> results;

    public Iterable<Incident> incidents;

    public Iterable<Period> subPeriods;

    public int sequenceNumber;
}
