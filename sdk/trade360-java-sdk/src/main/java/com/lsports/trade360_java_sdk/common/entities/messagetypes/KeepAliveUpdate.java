package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;
import jakarta.annotation.Nullable;

public class KeepAliveUpdate {

    @JsonIgnore
    public final static int entityKey = 31;

    @Nullable
    public KeepAlive keepAlive;
}
