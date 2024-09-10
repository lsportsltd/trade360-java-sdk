package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class Suspension {

    public Boolean succeeded;
    public int sportId;
    @Nullable public Integer locationId; // Nullable to handle missing values
    public int competitionId;
    @Nullable public Integer fixtureId; // Nullable to handle missing values
    public LocalDateTime creationDate;
    @Nullable public Iterable<Market> markets;
}
