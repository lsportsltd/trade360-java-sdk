package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

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
     * Feed interruption domains. Empty or absent = healthy.
     * Phase 1: {@code [1]} = Markets ({@link FeedInterruptedDomainEnum#Markets}).
     * Signal only — does not trigger auto-suspend or recovery.
     */
    public int[] feedInterrupted = new int[0];

    @JsonSetter("FeedInterrupted")
    public void setFeedInterrupted(int[] feedInterrupted) {
        this.feedInterrupted = feedInterrupted == null ? new int[0] : feedInterrupted;
    }
}
