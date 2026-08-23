package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import jakarta.annotation.Nullable;

/**
 * Request to retrieve markets based on various criteria.
 * Filter IDs serialize to {@code SportsId}, {@code LocationsId},
 * {@code LeaguesId}, and {@code MarketsId} for {@code POST /Markets/Get}.
 *
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param leaguesIds the IDs of the leagues to filter by
 * @param marketsIds the IDs of the markets to filter by
 * @param isSettleable whether the market is settleable
 * @param marketType the type of the market
 * @param languageId the ID of the language to filter by
 * @see MarketType
 */
public final record GetMarketsRequest(
    @JsonProperty("SportsId") @Nullable Iterable<Integer> sportIds,
    @JsonProperty("LocationsId") @Nullable Iterable<Integer> locationIds,
    @JsonProperty("LeaguesId") @Nullable Iterable<Integer> leaguesIds,
    @JsonProperty("MarketsId") @Nullable Iterable<Integer> marketsIds,
    @Nullable Boolean isSettleable,
    MarketType marketType,
    @Nullable Integer languageId) {
}