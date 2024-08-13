package com.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

public class Incident {

    public int period;

    public int incidentType;

    public int seconds;

    @Nullable public String participantPosition;

    @Nullable public String playerId;

    @Nullable public String playerName;

    @Nullable public Iterable<Result> results;
}
