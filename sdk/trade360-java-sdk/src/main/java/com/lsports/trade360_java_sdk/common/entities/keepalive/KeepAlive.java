package com.lsports.trade360_java_sdk.common.entities.keepalive;

import com.lsports.trade360_java_sdk.common.entities.shared.*;
import jakarta.annotation.Nullable;

/**
 * The {@code KeepAlive} class represents a keep-alive message.
 */
public class KeepAlive {

    /**
     * Event IDs that are currently active.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Integer> activeEvents;

    /**
     * Extra data associated with the keep-alive message.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<NameValuePair> extraData;

    /**
     * The provider ID associated with the keep-alive message.
     * This can be {@code null} if not set.
     */
    @Nullable public Integer providerId;
}
