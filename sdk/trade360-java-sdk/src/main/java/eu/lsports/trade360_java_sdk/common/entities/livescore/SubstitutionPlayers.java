package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code SubstitutionPlayers} class represents the players involved in a substitution incident.
 */
public class SubstitutionPlayers {

    /**
     * The first list of players (typically players going out).
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<SubstitutionPlayer> item1;

    /**
     * The second list of players (typically players coming in).
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<SubstitutionPlayer> item2;
}

