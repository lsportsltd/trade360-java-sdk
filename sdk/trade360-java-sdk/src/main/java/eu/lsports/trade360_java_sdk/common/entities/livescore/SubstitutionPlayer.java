package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code SubstitutionPlayer} class represents a player involved in a substitution.
 */
public class SubstitutionPlayer {

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

