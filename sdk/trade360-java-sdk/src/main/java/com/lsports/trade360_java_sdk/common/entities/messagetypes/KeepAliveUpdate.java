package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;

public class KeepAliveUpdate {

    @JsonIgnore
    public final static int entityKey = 31;

    public KeepAlive keepAlive;
}
