package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.PlayerType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code FixturePlayerInfo} class represents detailed information about a player in a fixture.
 */
public class FixturePlayerInfo {

    /**
     * The ID of the player.
     */
    public int id;

    /**
     * The name of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String name;

    /**
     * The ID of the team the player belongs to.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer teamId;

    /**
     * The ID of the player's nationality.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer nationalityId;

    /**
     * The birth date of the player.
     * This can be {@code null} if not set.
     */
    @Nullable
    public LocalDateTime birthDate;

    /**
     * The type of the player (Player, Coach, Other).
     * This can be {@code null} if not set.
     */
    @Nullable
    public PlayerType type;

    /**
     * The ID of the national team the player belongs to.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer nationalTeamId;
}

