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
    public static MessageType findMessageTypeByProviderOddsType(int typeId ,ProviderOddsType providerOddsType) throws ClassNotFoundException {
        if(typeId == MarketUpdate.value){
            if(providerOddsType == ProviderOddsType.AVERAGE){
                return MarketUpdate;
            }else if(providerOddsType == ProviderOddsType.PROVIDER_ODDS){
                return MarketUpdateProviderOdds;
            }else if(providerOddsType == ProviderOddsType.BOTH) {
                return MarketUpdateBoth;
            }
        } else if(typeId == SettlementUpdate.value){
            if (providerOddsType == ProviderOddsType.AVERAGE) {
                return SettlementUpdate;
            } else if (providerOddsType == ProviderOddsType.PROVIDER_ODDS) {
                return SettlementUpdateProviderOdds;
            } else if (providerOddsType == ProviderOddsType.BOTH) {
                return SettlementUpdateBoth;
            }
        }else if(typeId == OutrightLeagueMarketUpdate.value){
            if(providerOddsType == ProviderOddsType.AVERAGE){
                return OutrightLeagueMarketUpdate;
            }else if(providerOddsType == ProviderOddsType.PROVIDER_ODDS){
                return OutrightLeagueMarketUpdateProviderOdds;
            }else if(providerOddsType == ProviderOddsType.BOTH){
                return OutrightLeagueMarketUpdateBoth;
            }
        } else if(typeId == OutrightFixtureMarketUpdate.value) {
            if (providerOddsType == ProviderOddsType.AVERAGE) {
                return OutrightFixtureMarketUpdate;
            } else if (providerOddsType == ProviderOddsType.PROVIDER_ODDS) {
                return OutrightFixtureMarketUpdateProviderOdds;
            } else if (providerOddsType == ProviderOddsType.BOTH) {
                return OutrightFixtureMarketUpdateBoth;
            }
        }else if(typeId == OutrightSettlementsUpdate.value){
            if(providerOddsType == ProviderOddsType.AVERAGE){
                return OutrightSettlementsUpdate;
            }else if(providerOddsType == ProviderOddsType.PROVIDER_ODDS){
                return OutrightSettlementsUpdateProviderOdds;
            }else if(providerOddsType == ProviderOddsType.BOTH){
                return OutrightSettlementsUpdateBoth;
            }
        }
        return findMessageType(typeId);
    }
}
