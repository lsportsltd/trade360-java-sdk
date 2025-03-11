package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code Incident} class represents an incident during a livescore.
 */
public class CurrentIncident {
    /**
     * The ID of the current incident.
     */
    public long id;

    /**
     * The name of the current incident.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The last update time of the current incident in UTC.
     */
    public LocalDateTime lastUpdate;

}
