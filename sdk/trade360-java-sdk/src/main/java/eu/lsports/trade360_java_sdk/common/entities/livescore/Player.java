package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Player} class represents a player involved in an incident.
 */
public class Player {

    /**
     * The ID of the player.
     */
    public int id;

    /**
     * The name of the player.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;
}
