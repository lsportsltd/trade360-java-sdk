package com.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code League} class represents a sports league.
 */
public class League {

    /**
     * The ID of the league.
     */
    public int id;

    /**
     * The name of the league.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;
}
