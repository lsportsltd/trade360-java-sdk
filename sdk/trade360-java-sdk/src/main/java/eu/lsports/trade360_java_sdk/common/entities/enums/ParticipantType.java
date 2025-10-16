package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code ParticipantType} enum represents the various types of participants.
 */
public enum ParticipantType {
    /**
     * Type indicating club participants.
     */
    CLUB(1),

    /**
     * Type indicating national participants.
     */
    NATIONAL(2),

    /**
     * Type indicating individual participants.
     */
    INDIVIDUAL(3),

    /**
     * Type indicating virtual participants.
     */
    VIRTUAL(4),

    /**
     * Type indicating esports participants.
     */
    ESPORTS(5),

    /**
     * Type indicating virtureal participants.
     */
    VIRTUREAL(6),

    /**
     * Type indicating doubles participants.
     */
    DOUBLES(7);

    private int value;

    ParticipantType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the participant type.
     *
     * @return the integer value representing the participant type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}

