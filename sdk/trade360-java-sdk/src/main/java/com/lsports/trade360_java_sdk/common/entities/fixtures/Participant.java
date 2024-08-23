package com.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

public class Participant {

    public int id;

    @Nullable public String name;

    @Nullable public String position;

    @Nullable public Integer rotationId;

    public int isActive = -1;
}
