package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

/**
 * The {@code Bet} class represents a bet in a market.
 */
public class Bet extends BaseBet {
    /**
     * The provider bet ID.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String providerBetId;

    @Nullable
    public float calculatedMargin;
}