package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class GetOutrightFixtureResultElement {
    public int id;
    public @Nullable String name;
    public int type;
    public Iterable<OutrightFixtureEventElement> events;
}