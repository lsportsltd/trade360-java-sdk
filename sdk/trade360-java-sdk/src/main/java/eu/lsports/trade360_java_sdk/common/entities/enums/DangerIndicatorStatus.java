package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code DangerIndicatorType} enum represents the various statuses of danger indicators.
 */
public enum DangerIndicatorStatus {
    /**
     * safe status indicator
     */
    SAFE(1),

    /**
     * danger status indicator
     */
    DANGER(2);


    private int value;

    DangerIndicatorStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the danger status
     *
     * @return the integer value representing the danger status
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}