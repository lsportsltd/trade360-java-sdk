package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Players} class represents the players involved in an incident.
 */
public class Players {

    /**
     * The first list of players.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Player> item1;

    /**
     * The second list of players.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Player> item2;
}
