package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import com.fasterxml.jackson.annotation.JsonInclude;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;

/**
 * Nested market event for OutrightLeagueMarketUpdate (type 40) and
 * OutrightLeagueSettlementUpdate (type 43).
 */
public class OutrightLeagueMarketEvent extends MarketEvent {

    /**
     * Optional fixture name when provided by the feed; omitted when absent.
     * This can be {@code null} if not set.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String fixtureName;
}
