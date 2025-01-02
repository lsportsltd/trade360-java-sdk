package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code Location} class represents a location associated with a fixture.
 */
public class Location {

    /**
     * The ID of the location.
     */
    public int id;

    /**
     * The name of the location.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;
}
