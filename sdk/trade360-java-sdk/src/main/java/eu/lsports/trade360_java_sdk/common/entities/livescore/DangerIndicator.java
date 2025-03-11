package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.DangerIndicatorType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code Incident} class represents an danger indicator during a livescore.
 */
public class DangerIndicator {
    /**
     * The type of the danger
     */
    @Nullable public DangerIndicatorType type;

    /**
     * The status of the danger
     */
    @Nullable public DangerIndicatorStatus status;

    /**
     * The last update time of the current incident in UTC.
     */
    public LocalDateTime lastUpdate;

}
