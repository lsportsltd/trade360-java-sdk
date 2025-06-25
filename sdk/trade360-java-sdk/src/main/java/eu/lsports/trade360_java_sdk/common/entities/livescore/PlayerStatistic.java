package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code PlayerStatistic} class represents statistics for a player in a live score event.
 */
public class PlayerStatistic {

    /**
     * The ID of the player.
     */
    public int playerId;

    /**
     * The statistics associated with the player.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<StatisticValue> statistics;

    /**
     * The name of the player.
     * This can be {@code null} if not set.
     */
    @Nullable public String playerName;

    /**
     * The ID of the team the player belongs to.
     */
    public int teamId;

    /**
     * Indicates whether the player has played in the event.
     */
    public boolean hasPlayed;
}
