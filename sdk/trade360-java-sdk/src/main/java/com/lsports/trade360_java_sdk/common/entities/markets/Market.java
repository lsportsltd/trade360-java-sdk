package com.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

public class Market {

    public int id;

    @Nullable public String name;

    @Nullable public Iterable<Bet> bets;

    @Nullable public String mainLine;
}
