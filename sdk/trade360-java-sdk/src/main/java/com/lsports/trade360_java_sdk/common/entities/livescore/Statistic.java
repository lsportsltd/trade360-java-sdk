package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.StatisticType;

public class Statistic {
    
    public StatisticType type;

    public Iterable<Result> results;

    public Iterable<Incident> incidents;
}
