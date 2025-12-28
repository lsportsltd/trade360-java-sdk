package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code FixturePlayer} class represents a player in a fixture's lineup.
 */
public class FixturePlayer {

    /**
     * The ID of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer playerId;

    /**
     * The shirt number of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String shirtNumber;

    /**
     * Indicates whether the player is the captain.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Boolean isCaptain;

    /**
     * Indicates whether the player is in the starting lineup.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Boolean isStartingLineup;

    /**
     * The position of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair position;

    /**
     * The state of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair state;

    /**
     * Detailed information about the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public FixturePlayerInfo player;
}

