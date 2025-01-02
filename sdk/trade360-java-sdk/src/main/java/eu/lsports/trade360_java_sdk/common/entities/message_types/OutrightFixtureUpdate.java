package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightFixtureEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightFixtureUpdate} class represents an update to the outright fixtures.
 */
public class OutrightFixtureUpdate {

    /**
     * The entity key for the outright fixture update.
     */
    @JsonIgnore
    public final static int entityKey = 37;

    /**
     * The competition associated with the outright fixture update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightCompetition<OutrightFixtureEvent> competition;
}