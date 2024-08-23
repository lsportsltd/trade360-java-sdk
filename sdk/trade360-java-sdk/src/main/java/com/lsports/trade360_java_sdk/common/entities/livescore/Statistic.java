package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.enums.StatisticType;
import jakarta.annotation.Nullable;

public class Statistic {
    
    @Nullable public StatisticType type;

    @Nullable public Iterable<Result> results;

    @Nullable public Iterable<Incident> incidents;
}
