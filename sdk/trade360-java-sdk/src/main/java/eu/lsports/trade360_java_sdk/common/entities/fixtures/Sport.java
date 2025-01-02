package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code Sport} class represents a sport associated with a fixture.
 */
public class Sport {

    /**
     * The ID of the sport.
     */
    public int id;

    /**
     * The name of the sport.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;
}
