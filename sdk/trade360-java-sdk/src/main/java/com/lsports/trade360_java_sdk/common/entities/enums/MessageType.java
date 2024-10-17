package com.lsports.trade360_java_sdk.common.entities.enums;

/**
 * The {@code MessageType} enum represents the various types of messages.
 */
public enum MessageType {
    /**
     * Type indicating a fixture metadata update message.
     */
    FixtureMetadataUpdate(1),

    /**
     * Type indicating a livescore update message.
     */
    LivescoreUpdate(2),

    /**
     * Type indicating a market update message.
     */
    MarketUpdate(3),

    /**
     * Type indicating a keep-alive update message.
     */
    KeepAliveUpdate(31),

    /**
     * Type indicating a heartbeat update message.
     */
    HeartbeatUpdate(32),

    /**
     * Type indicating a settlement update message.
     */
    SettlementUpdate(35),

    /**
     * Type indicating an outright fixture market update message.
     */
    OutrightFixtureMarketUpdate(41),

    /**
     * Type indicating an outright fixture update message.
     */
    OutrightFixtureUpdate(37),

    /**
     * Type indicating an outright league market update message.
     */
    OutrightLeagueMarketUpdate(40),

    /**
     * Type indicating an outright league update message.
     */
    OutrightLeagueUpdate(38),

    /**
     * Type indicating an outright score update message.
     */
    OutrightScoreUpdate(39),

    /**
     * Type indicating an outright settlements update message.
     */
    OutrightSettlementsUpdate(42);

    private int value;

    MessageType(int value) {
        this.value = value;
    }

    /**
     * Sets the integer value representing the message type.
     *
     * @param value the integer value representing the message type
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the message type.
     *
     * @return the integer value representing the message type
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Finds the {@code MessageType} corresponding to the given type ID.
     *
     * @param typeId the integer value representing the message type
     * @return the {@code MessageType} corresponding to the given type ID, or {@code null} if not found
     * @throws ClassNotFoundException if the message type is not found
     */
    public static MessageType findMessageType(int typeId) throws ClassNotFoundException {
        for (MessageType v : values()) {
            if (v.value == typeId) {
                return v;
            }
        }
        return null;
    }
}
