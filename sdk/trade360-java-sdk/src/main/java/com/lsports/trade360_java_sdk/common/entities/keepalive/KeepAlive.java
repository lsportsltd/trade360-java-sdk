package com.lsports.trade360_java_sdk.common.entities.keepalive;

import com.lsports.trade360_java_sdk.common.entities.shared.*;
import jakarta.annotation.Nullable;

public class KeepAlive {

    @Nullable public Iterable<Integer> activeEvents;

    @Nullable public Iterable<NameValuePair> extraData;

    @Nullable public Integer providerId;
}
