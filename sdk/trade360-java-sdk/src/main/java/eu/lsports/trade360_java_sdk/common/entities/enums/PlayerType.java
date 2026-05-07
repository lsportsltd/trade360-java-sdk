package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code PlayerType} enum represents the various types of players.
 */
public enum PlayerType {
    /**
     * Type indicating a regular player.
     */
    PLAYER(0),

    /**
     * Type indicating other personnel.
     */
    OTHER(1),

    /**
     * Type indicating a coach.
     */
    COACH(2);

    private final int value;

    PlayerType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the player type.
     *
     * @return the integer value representing the player type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}

