package com.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

public class OutrightLeagueCompetitionWrapper<T> {

    public int id;

    @Nullable public String name;

    public int type;
    @Nullable public Iterable<OutrightLeagueEventsWrapper<T>> competitions;
}
