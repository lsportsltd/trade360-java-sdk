package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code SettlementType} enum represents the various types of settlement statuses.
 */
public enum SettlementType {
    /**
     * Status indicating that the settlement is cancelled.
     */
    CANCELLED(-1),

    /**
     * Status indicating that the settlement is not settled.
     */
    NOT_SETTLED(0),

    /**
     * Status indicating that the settlement is a loss.
     */
    LOSER(1),

    /**
     * Status indicating that the settlement is a win.
     */
    WINNER(2),

    /**
     * Status indicating that the settlement is a refund.
     */
    REFUND(3),

    /**
     * Status indicating that the settlement is half lost.
     */
    HALF_LOST(4),

    /**
     * Status indicating that the settlement is half won.
     */
    HALF_WON(5);

    private int value;

    SettlementType(int value) { this.value = value;}

    /**
     * Returns the integer value representing the settlement type.
     *
     * @return the integer value representing the settlement type
     */
    @JsonValue
    public int getValue() {return this.value; }
}
