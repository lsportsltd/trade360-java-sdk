package eu.lsports.trade360_java_sdk.common.entities.markets;

import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.SettlementType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code BaseBet} class represents the common properties of a bet in a market.
 */
public abstract class BaseBet {
    /**
     * The ID of the bet.
     */
    public long id;

    /**
     * The name of the bet.
     */
    public String name;

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
    @Nullable public SettlementType settlement;

    /**
     * The Suspension Reason of the bet.
     */
    @Nullable public int SuspensionReason;

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
     * The probability of the bet.
     */
    @Nullable public double probability;

    /**
     * The participant ID associated with the bet.
     */
    @Nullable public int participantId;

    /**
     * The player ID associated with the bet.
     */
    @Nullable public int playerId;

    /**
     * The name of the player associated with the bet.
     * This can be {@code null} if not set.
     */
    @Nullable public String playerName;

    /**
     * The order associated with the bet.
     */
    @Nullable public int order;
}