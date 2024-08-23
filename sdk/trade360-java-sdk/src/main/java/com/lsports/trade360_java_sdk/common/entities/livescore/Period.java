package com.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

public class Period {

    public int type;

    public boolean isFinished;

    public boolean isConfirmed;

    @Nullable public Iterable<Result> results;

    @Nullable public Iterable<Incident> incidents;

    @Nullable public Iterable<Period> subPeriods;

    public int sequenceNumber;
}
