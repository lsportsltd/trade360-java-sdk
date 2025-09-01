package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import eu.lsports.trade360_java_sdk.common.entities.message_types.*;

import java.text.MessageFormat;

/**
 * The {@code MessageType} enum represents the various types of messages.
 */
public enum MessageType {
    /**
     * Type indicating a fixture metadata update message.
     */
    FixtureMetadataUpdate(1, FixtureMetadataUpdate.class),

    /**
     * Type indicating a livescore update message.
     */
    LivescoreUpdate(2, LivescoreUpdate.class),

    /**
     * Type indicating a market update message for trade360 customer type.
     */
    MarketUpdate(3, MarketUpdate.class),

    /**
     * Type indicating a keep-alive update message.
     */
    KeepAliveUpdate(31, KeepAliveUpdate.class),

    /**
     * Type indicating a heartbeat update message.
     */
    HeartbeatUpdate(32, HeartbeatUpdate.class, false),

    /**
     * Type indicating a settlement update message for trade360 customer type.
     */
    SettlementUpdate(35, SettlementUpdate.class),
    /**
     * Type indicating an outright fixture update message.
     */
    OutrightFixtureUpdate(37, OutrightFixtureUpdate.class),

    /**
     * Type indicating an outright league update message for trade360 customer type.
     */
    OutrightLeagueUpdate(38, OutrightLeagueUpdate.class),
    /**
     * Type indicating an outright score update message.
     */
    OutrightScoreUpdate(39, OutrightScoreUpdate.class),
    /**
     * Type indicating an outright league market update message for trade360 customer type.
     */
    OutrightLeagueMarketUpdate(40, OutrightLeagueMarketUpdate.class),
    /**
     * Type indicating an outright fixture market update message for trade360 customer type.
     */
    OutrightFixtureMarketUpdate(41, OutrightFixtureMarketUpdate.class),
    /**
     * Type indicating an outright settlements update message for trade360 customer type.
     */
    OutrightSettlementsUpdate(42, OutrightSettlementsUpdate.class),
    /**
     * Type indicating an outright league settlements update message for trade360 customer type.
     */
    OutrightLeagueSettlementsUpdate(43, OutrightLeagueSettlementUpdate.class);

    private int value;
    private final Class<?> clazz;
    private final boolean hasBody;

    MessageType(int value, Class<?> clazz) {
        this.value = value;
        this.clazz = clazz;
        this.hasBody = true;
    }

    MessageType(int value, Class<?> clazz, boolean hasBody) {
        this.value = value;
        this.clazz = clazz;
        this.hasBody = hasBody;
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
    @JsonValue
    public int getValue() {
        return this.value;
    }

    /**
     *
     * @return the boolean value indicating if the entity has a body
     */
    @JsonValue
    public boolean hasBody() {
        return this.hasBody;
    }

    public Class<?> getMessageClass() {
        return clazz;
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
        throw new ClassNotFoundException(MessageFormat.format("Requested class for typeId {0}", typeId)) ;
    }
}
