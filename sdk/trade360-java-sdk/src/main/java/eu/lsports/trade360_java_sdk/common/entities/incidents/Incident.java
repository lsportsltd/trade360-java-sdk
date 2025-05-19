package eu.lsports.trade360_java_sdk.common.entities.incidents;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class Incident {
    public Integer sportId;
    public String sportName;
    public Integer incidentId;
    public String incidentName;
    @Nullable public String description;
    public LocalDateTime lastUpdate;
    public LocalDateTime creationDate;
}
