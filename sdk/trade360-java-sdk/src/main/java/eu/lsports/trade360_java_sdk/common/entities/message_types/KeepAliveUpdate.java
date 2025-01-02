package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;
import jakarta.annotation.Nullable;

/**
 * The {@code KeepAliveUpdate} class represents a keep-alive update message.
 */
public class KeepAliveUpdate {

    /**
     * The entity key for the keep-alive update.
     */
    @JsonIgnore
    public final static int entityKey = 31;

    /**
     * The keep-alive information associated with the update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public KeepAlive keepAlive;
}