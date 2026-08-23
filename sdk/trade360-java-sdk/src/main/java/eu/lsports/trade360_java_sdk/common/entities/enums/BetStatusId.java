package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Customer bet status including Closed.
 * Distinct from legacy {@link BetStatus} (0–3, no Closed).
 */
public enum BetStatusId {
    OPEN(1),
    SUSPENDED(2),
    SETTLED(3),
    CLOSED(4);

    private final int value;

    BetStatusId(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static BetStatusId fromValue(int value) {
        for (BetStatusId status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown BetStatusId: " + value);
    }
}
