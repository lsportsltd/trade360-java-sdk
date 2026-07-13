package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.MarketStatus;
import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import eu.lsports.trade360_java_sdk.common.entities.markets.ProviderMarket;
import jakarta.annotation.Nullable;

/**
 * Represents an outright market element.
 */
public final class OutrightMarketElement {
    /**
     * The unique identifier of the outright market element.
     */
    public int id;

    /**
     * The name of the outright market element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /** Trade360 market status: 1=Open, 2=Suspended, 3=Settled. */
    @Nullable public MarketStatus marketStatus;

    /**
     * The collection of bets associated with the outright market element.
     * Can be {@code null}.
     * 
     * @see Bet
     */
    @Nullable public Iterable<Bet> bets;

    /**
     * The collection of provider markets associated with the outright market element.
     * Can be {@code null}.
     * 
     * @see ProviderMarket
     */
    @Nullable public Iterable<ProviderMarket> providerMarkets;
}