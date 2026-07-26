package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The {@code HeartbeatUpdate} class represents a heartbeat update message.
 */
public class HeartbeatUpdate {

    /**
     * The entity key for the heartbeat update.
     */
    @JsonIgnore
    public final static int entityKey = 32;

    /**
     * Feed health signal. {@code 0} means no problem (default), non-zero indicates a
     * problem detected upstream. Signal only — does not trigger auto-suspend or recovery.
     */
    public int problem;
}