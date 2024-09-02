package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class GetOutrightLeaguesResultElement {
    public int id;
    @Nullable public String name;
    public int type;
    @Nullable public Iterable<OutrightCompetitionsResultElement> competitions;
}