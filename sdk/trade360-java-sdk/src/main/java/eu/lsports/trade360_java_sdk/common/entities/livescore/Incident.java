package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Incident} class represents an incident during a fixture.
 */
public class Incident {

    /**
     * The period in which the incident occurred.
     */
    public int period;

    /**
     * The type of the incident.
     */
    public int incidentType;

    /**
     * The time in seconds when the incident occurred.
     */
    public int seconds;

    /**
     * The position of the participant involved in the incident.
     * This can be {@code null} if not set.
     */
    @Nullable public String participantPosition;

    /**
     * The ID of the player involved in the incident.
     * This can be {@code null} if not set.
     */
    @Nullable public String playerId;

    /**
     * The name of the player involved in the incident.
     * This can be {@code null} if not set.
     */
    @Nullable public String playerName;

    /**
     * The results associated with the incident.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Result> results;

    /**
     * The players involved in a substitution incident.
     * This can be {@code null} if not set.
     */
    @Nullable public SubstitutionPlayers players;
}
