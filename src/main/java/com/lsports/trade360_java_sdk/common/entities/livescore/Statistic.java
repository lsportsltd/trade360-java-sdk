package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.StatisticType;

public class Statistic {
    
    public StatisticType Type;

    public Iterable<Result> Results;

    public Iterable<Incident> Incidents;
}
