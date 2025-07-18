package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import jakarta.annotation.Nullable;

/**
 * The {@code Livescore} class represents live score information for a fixture.
 */
public class Livescore {

    /**
     * The scoreboard associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Scoreboard scoreboard;

    /**
     * The periods associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Period> periods;

    /**
     * The statistics associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Statistic> statistics;

    /**
     * The player statistics associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<PlayerStatistic> playerStatistics;

    /**
     * Extra data associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<NameValuePair> livescoreExtraData;

    /**
     * The current incident associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public CurrentIncident currentIncident;

    /**
     * The danger triggers associated with the live score.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<DangerIndicator> dangerTriggers;
}
