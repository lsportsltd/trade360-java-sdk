package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class GetOutrightFixtureMarketsResultElement {
    public int id;
    @Nullable public String name;
    public int type;
    public Iterable<OutrightFixtureMarketsElement> events;
}
