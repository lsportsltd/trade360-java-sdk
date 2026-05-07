package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code League} class represents a sports league.
 */
public class League {

    /**
     * The ID of the league.
     */
    public int id;

    /**
     * The name of the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String name;

    /**
     * The tour associated with the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair tour;

    /**
     * The age category of the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer ageCategory;

    /**
     * The gender category of the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer gender;

    /**
     * The type of the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer type;

    /**
     * The number of periods in the league's fixtures.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Integer numberOfPeriods;

    /**
     * The sport category associated with the league.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair sportCategory;
}
