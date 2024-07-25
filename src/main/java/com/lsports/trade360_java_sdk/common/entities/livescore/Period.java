package com.lsports.trade360_java_sdk.common.entities.livescore;

public class Period {

    public int Type;

    public boolean IsFinished;

    public boolean IsConfirmed;

    public Iterable<Result> Results;

    public Iterable<Incident> Incidents;

    public Iterable<Period> SubPeriods;

    public int SequenceNumber;
}
