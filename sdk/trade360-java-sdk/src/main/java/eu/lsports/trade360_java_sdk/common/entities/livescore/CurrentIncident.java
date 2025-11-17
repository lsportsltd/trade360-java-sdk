package eu.lsports.trade360_java_sdk.common.entities.livescore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentConfirmation;
import eu.lsports.trade360_java_sdk.common.entities.enums.IncidentType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code Incident} class represents an incident during a livescore.
 */
public class CurrentIncident {
    /**
     * The ID of the current incident.
     */
    public IncidentType id;

    /**
     * The name of the current incident.
     */
    @Nullable public String name;

    /**
     * The last update time of the current incident in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The confirmation status of current incident
     */
    public IncidentConfirmation confirmation;
}
