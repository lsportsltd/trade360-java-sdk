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
     * Feed interruption signal. {@code 0} means normal (default), non-zero indicates a
     * feed interruption detected upstream. Signal only — does not trigger auto-suspend or recovery.
     */
    public int feedInterrupted;
}
