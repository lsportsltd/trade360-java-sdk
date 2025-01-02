package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code FixtureMetadataUpdate} class represents an update to the metadata of a fixture.
 */
public class FixtureMetadataUpdate {

    /**
     * The entity key for the fixture metadata update.
     */
    @JsonIgnore
    public final static int entityKey = 1;

    /**
     * The events associated with the fixture metadata update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<FixtureEvent> events;
}