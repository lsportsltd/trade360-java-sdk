package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

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
     * Type indicating a market update message for trade360 customer type.
     */
    MarketUpdate(3),
    /**
     * Type indicating a market update message for both customer types.
     */
    MarketUpdateBoth(3),
    /**
     * Type indicating a market update message for provider odds type.
     */
    MarketUpdateProviderOdds(3),

    /**
     * Type indicating a keep-alive update message.
     */
    KeepAliveUpdate(31),

    /**
     * Type indicating a heartbeat update message.
     */
    HeartbeatUpdate(32),

    /**
     * Type indicating a settlement update message for trade360 customer type.
     */
    SettlementUpdate(35),
    /**
     * Type indicating a settlement update message for both customer types.
     */
    SettlementUpdateBoth(35),

    /**
     * Type indicating a settlement update message for provider odds type.
     */
    SettlementUpdateProviderOdds(35),

    /**
     * Type indicating an outright fixture market update message for trade360 customer type.
     */
    OutrightFixtureMarketUpdate(41),
    /**
     * Type indicating an outright fixture market update message for both customer types.
     */
    OutrightFixtureMarketUpdateBoth(41),
    /**
     * Type indicating an outright fixture market update message for provider odds type.
     */
    OutrightFixtureMarketUpdateProviderOdds(41),

    /**
     * Type indicating an outright fixture update message.
     */
    OutrightFixtureUpdate(37),

    /**
     * Type indicating an outright league market update message for trade360 customer type.
     */
    OutrightLeagueMarketUpdate(40),
    /**
     * Type indicating an outright league market update message for both customer types.
     */
    OutrightLeagueMarketUpdateBoth(40),
    /**
     * Type indicating an outright league market update message for provider odds type.
     */
    OutrightLeagueMarketUpdateProviderOdds(40),

    /**
     * Type indicating an outright league update message for trade360 customer type.
     */
    OutrightLeagueUpdate(38),
    /**
     * Type indicating an outright league update message for both customer types.
     */
    OutrightLeagueUpdateBoth(38),
    /**
     * Type indicating an outright league update message for provider odds type.
     */
    OutrightLeagueUpdateProviderOdds(38),

    /**
     * Type indicating an outright score update message.
     */
    OutrightScoreUpdate(39),

    /**
     * Type indicating an outright settlements update message for trade360 customer type.
     */
    OutrightSettlementsUpdate(42),
    /**
     * Type indicating an outright settlements update message for provider odds type.
     */
    OutrightSettlementsUpdateProviderOdds(42),

    /**
     * Type indicating an outright settlements update message for both customer types.
     */
    OutrightSettlementsUpdateBoth(42);

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
    @JsonValue
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

    /**
     * Finds the {@code MessageType} corresponding to the given type ID.
     *
     * @param typeId the integer value representing the message type
     * @return the {@code MessageType} corresponding to the given type ID, or {@code null} if not found
     * @throws ClassNotFoundException if the message type is not found
     */
    public static MessageType findMessageTypeByProviderOddsType(int typeId, ProviderOddsType providerOddsType) throws ClassNotFoundException {
        switch (typeId) {
            case 3:
                return getMarketUpdateMessageType(providerOddsType);
            case 35:
                return getSettlementUpdateMessageType(providerOddsType);
            case 40:
                return getOutrightLeagueMarketUpdateMessageType(providerOddsType);
            case 41:
                return getOutrightFixtureMarketUpdateMessageType(providerOddsType);
            case 42:
                return getOutrightSettlementsUpdateMessageType(providerOddsType);
            default:
                return findMessageType(typeId);
        }
    }

    private static MessageType getMarketUpdateMessageType(ProviderOddsType providerOddsType) {
        switch (providerOddsType) {
            case AVERAGE:
                return MessageType.MarketUpdate;
            case PROVIDER_ODDS:
                return MessageType.MarketUpdateProviderOdds;
            case BOTH:
                return MessageType.MarketUpdateBoth;
            default:
                return null;
        }
    }

    private static MessageType getSettlementUpdateMessageType(ProviderOddsType providerOddsType) {
        switch (providerOddsType) {
            case AVERAGE:
                return MessageType.SettlementUpdate;
            case PROVIDER_ODDS:
                return MessageType.SettlementUpdateProviderOdds;
            case BOTH:
                return MessageType.SettlementUpdateBoth;
            default:
                return null;
        }
    }

    private static MessageType getOutrightLeagueMarketUpdateMessageType(ProviderOddsType providerOddsType) {
        switch (providerOddsType) {
            case AVERAGE:
                return MessageType.OutrightLeagueMarketUpdate;
            case PROVIDER_ODDS:
                return MessageType.OutrightLeagueMarketUpdateProviderOdds;
            case BOTH:
                return MessageType.OutrightLeagueMarketUpdateBoth;
            default:
                return null;
        }
    }

    private static MessageType getOutrightFixtureMarketUpdateMessageType(ProviderOddsType providerOddsType) {
        switch (providerOddsType) {
            case AVERAGE:
                return MessageType.OutrightFixtureMarketUpdate;
            case PROVIDER_ODDS:
                return MessageType.OutrightFixtureMarketUpdateProviderOdds;
            case BOTH:
                return MessageType.OutrightFixtureMarketUpdateBoth;
            default:
                return null;
        }
    }

    private static MessageType getOutrightSettlementsUpdateMessageType(ProviderOddsType providerOddsType) {
        switch (providerOddsType) {
            case AVERAGE:
                return MessageType.OutrightSettlementsUpdate;
            case PROVIDER_ODDS:
                return MessageType.OutrightSettlementsUpdateProviderOdds;
            case BOTH:
                return MessageType.OutrightSettlementsUpdateBoth;
            default:
                return null;
        }
    }
}
