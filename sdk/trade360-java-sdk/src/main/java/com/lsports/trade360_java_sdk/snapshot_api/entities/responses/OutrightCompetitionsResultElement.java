package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class OutrightCompetitionsResultElement {
    public int id;
    @Nullable public String Name;
    public int Type;
    @Nullable public Iterable<OutrightCompetition> events;
}