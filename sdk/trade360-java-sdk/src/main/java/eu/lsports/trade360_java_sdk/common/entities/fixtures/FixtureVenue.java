package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.CourtSurface;
import eu.lsports.trade360_java_sdk.common.entities.enums.VenueAssignment;
import eu.lsports.trade360_java_sdk.common.entities.enums.VenueEnvironment;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code FixtureVenue} class represents a venue where a fixture takes place.
 */
public class FixtureVenue {

    /**
     * The ID of the venue.
     */
    public int id;

    /**
     * The name of the venue.
     */
    public String name;

    /**
     * The city where the venue is located.
     * This can be {@code null} if not set.
     */
    @Nullable public IdNamePair city;

    /**
     * The state where the venue is located.
     * This can be {@code null} if not set.
     */
    @Nullable public IdNamePair state;

    /**
     * The country where the venue is located.
     * This can be {@code null} if not set.
     */
    @Nullable public IdNamePair country;

    /**
     * The capacity of the venue.
     * This can be {@code null} if not set.
     */
    @Nullable public Integer capacity;

    /**
     * The attendance for the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Integer attendance;

    /**
     * The court surface type of the venue.
     * This can be {@code null} if not set.
     */
    @Nullable public CourtSurface courtSurfaceType;

    /**
     * The environment type of the venue (indoors/outdoors).
     * This can be {@code null} if not set.
     */
    @Nullable public VenueEnvironment environment;

    /**
     * The assignment type of the venue (home/away/neutral).
     * This can be {@code null} if not set.
     */
    @Nullable public VenueAssignment assignment;
}
