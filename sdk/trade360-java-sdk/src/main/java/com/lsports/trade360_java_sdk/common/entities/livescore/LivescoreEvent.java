package com.lsports.trade360_java_sdk.common.entities.livescore;

import com.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import jakarta.annotation.Nullable;

public class LivescoreEvent {

    public int fixtureId;

    @Nullable public Fixture fixture;

    @Nullable public Livescore livescore;
}
