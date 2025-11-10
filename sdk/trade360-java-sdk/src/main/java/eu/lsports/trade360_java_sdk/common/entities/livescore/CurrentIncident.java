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
     * This is automatically derived from the incident type and cannot be set directly from JSON.
     * It will be included in JSON output but ignored during deserialization.
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Nullable public String name;

    /**
     * Sets the incident type ID and automatically updates the name field.
     * This method is called automatically during JSON deserialization.
     *
     * @param id the incident type
     */
    @JsonSetter("id")
    public void setId(IncidentType id) {
        this.id = id;
        this.name = id != null ? id.getIncidentName() : null;
    }

    /**
     * The last update time of the current incident in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The confirmation status of current incident
     */
    public IncidentConfirmation confirmation;
}
