package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code Participant} class represents a participant in a fixture.
 */
public class Participant {

    /**
     * The ID of the participant.
     */
    public int id;

    /**
     * The name of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String name;

    /**
     * The position of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String position;

    /**
     * The rotation ID of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer rotationId;

    /**
     * Indicates whether the participant is active.
     * {@code -1} represents unknown value.
     */
    public int isActive = -1;

    /**
     * The recent form of the participant (e.g., "WWDLW").
     * This can be {@code null} if not set.
     */
    @Nullable
    public String form;

    /**
     * The formation used by the participant (e.g., "4-3-3").
     * This can be {@code null} if not set.
     */
    @Nullable
    public String formation;

    /**
     * The players in the fixture for this participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<FixturePlayer> fixturePlayers;

    /**
     * The gender category of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer gender;

    /**
     * The age category of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer ageCategory;

    /**
     * The type of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer type;
}
