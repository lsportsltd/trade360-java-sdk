package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

import java.time.Instant;

/**
 * DI prediction metadata for bets.
 */
public class BetPredictionData {

    @Nullable public Double volume;

    @Nullable public Double liquidity;

    @Nullable public Instant startDate;

    @Nullable public Instant endDate;
}
