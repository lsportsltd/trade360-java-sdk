package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.shared.*;

public class Livescore {
    
    public Scoreboard scoreboard;

    public Iterable<Period> periods;

    public Iterable<Statistic> statistics;

    public Iterable<NameValuePair> livescoreExtraData;
}
