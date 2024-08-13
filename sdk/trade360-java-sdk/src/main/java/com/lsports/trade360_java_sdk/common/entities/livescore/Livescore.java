package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.shared.*;
import jakarta.annotation.Nullable;

public class Livescore {

    @Nullable public Scoreboard scoreboard;

    @Nullable public Iterable<Period> periods;

    @Nullable public Iterable<Statistic> statistics;

    @Nullable public Iterable<NameValuePair> livescoreExtraData;
}
