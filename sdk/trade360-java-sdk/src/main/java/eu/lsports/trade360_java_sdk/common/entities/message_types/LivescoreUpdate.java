package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code LivescoreUpdate} class represents a live score update message.
 */
public class LivescoreUpdate {

    /**
     * The entity key for the live score update.
     */
    @JsonIgnore
    public final static int entityKey = 2;

    /**
     * The live score events associated with the update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<LivescoreEvent> events;
}