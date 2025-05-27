package eu.lsports.trade360_java_sdk.common.entities.incidents;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * Represents an incident in the system.
 */
public class Incident {
    /** The sport ID associated with the incident. */
    public Integer sportId;
    /** The sport name associated with the incident. */
    public String sportName;
    /** The unique incident ID. */
    public Integer incidentId;
    /** The name of the incident. */
    public String incidentName;
    /** The description of the incident, if available. */
    @Nullable public String description;
    /** The last update timestamp for the incident. */
    public LocalDateTime lastUpdate;
    /** The creation date of the incident. */
    public LocalDateTime creationDate;
}
