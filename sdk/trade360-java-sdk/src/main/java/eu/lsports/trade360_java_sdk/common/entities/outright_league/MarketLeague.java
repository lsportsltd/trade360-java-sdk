package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketStatus;
import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import jakarta.annotation.Nullable;

/**
 * The {@code MarketLeague} class represents a market league in a betting context.
 */
public class MarketLeague {

    /**
     * The ID of the market league.
     */
    public int id;

    /**
     * The name of the market league.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The bets associated with the market league.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Bet> bets;

    /**
     * The main line of the market league.
     * This can be {@code null} if not set.
     */
    @Nullable public String mainLine;

    /**
     * Trade360 market status: 1=Open, 2=Suspended, 3=Settled, 4=Closed.
     */
    @Nullable @JsonProperty("Status") public MarketStatus status;
}