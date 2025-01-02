package eu.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;
import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.SettlementType;
import jakarta.annotation.Nullable;

/**
 * The {@code Bet} class represents a bet in a market.
 */
public class Bet {

    /**
     * The ID of the bet.
     */
    public long id;

    /**
     * The name of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The line of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String line;

    /**
     * The base line of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String baseLine;

    /**
     * The status of the bet.
     */
    public BetStatus status;

    /**
     * The start price of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String startPrice;

    /**
     * The current price of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String price;

    /**
     * The price volume of the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceVolume;

    /**
     * The settlement type of the bet.
     */
    public SettlementType settlement;

    /**
     * The provider bet ID.
     * This can be {@code null} if not set.
     */
    @Nullable public String providerBetId;

    /**
     * The last update time of the bet in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The price in Indonesian format.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceIN;

    /**
     * The price in American format.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceUS;

    /**
     * The price in Fractional format.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceUK;

    /**
     * The price in Malay format.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceMA;

    /**
     * The price in Hong Kong format.
     * This can be {@code null} if not set.
     */
    @Nullable public String priceHK;

    /**
     * Indicates whether the bet has changed.
     * Default value is -1.
     */
    public int isChanged = -1;

    /**
     * The probability of the bet.
     */
    public double probability;

    /**
     * The participant ID associated with the bet.
     */
    public int participantId;

    /**
     * The name of the player associated with the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String playerName;
}