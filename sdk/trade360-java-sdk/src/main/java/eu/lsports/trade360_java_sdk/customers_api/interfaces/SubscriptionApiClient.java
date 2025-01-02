package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
import reactor.core.publisher.Mono;

/**
 * The Subscription API client.
 */
public interface SubscriptionApiClient {

    /**
     * Gets the package quota.
     *
     * @return A {@link Mono} emitting the {@link PackageQuotaResponse}
     */
    Mono<BaseResponse<PackageQuotaResponse>> getPackageQuota();

    /**
     * Gets the in-play fixture schedule.
     *
     * @param request The request containing the parameters
     * @return A {@link Mono} emitting the {@link FixtureScheduleCollectionResponse}
     */
    Mono<BaseResponse<FixtureScheduleCollectionResponse>> getInPlayFixtureSchedule(GetFixtureScheduleRequest request);

    /**
     * Subscribes to fixtures.
     *
     * @param request The request containing the fixture IDs
     * @return A {@link Mono} emitting the {@link FixtureSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<FixtureSubscriptionCollectionResponse>> subscribeByFixture(FixtureSubscriptionRequest request);

    /**
     * Unsubscribes from fixtures.
     *
     * @param request The request containing the fixture IDs
     * @return A {@link Mono} emitting the {@link FixtureSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<FixtureSubscriptionCollectionResponse>> unSubscribeByFixture(FixtureSubscriptionRequest request);

    /**
     * Subscribes to leagues.
     *
     * @param request The request containing the league subscriptions
     * @return A {@link Mono} emitting the {@link LeagueSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<LeagueSubscriptionCollectionResponse>> subscribeByLeague(LeagueSubscriptionRequest request);

    /**
     * Unsubscribes from leagues.
     *
     * @param request The request containing the league subscriptions
     * @return A {@link Mono} emitting the {@link LeagueSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<LeagueSubscriptionCollectionResponse>> unSubscribeByLeague(LeagueSubscriptionRequest request);

    /**
     * Gets the current subscriptions.
     *
     * @param request The request containing the parameters
     * @return A {@link Mono} emitting the {@link GetSubscriptionResponse}
     */
    Mono<BaseResponse<GetSubscriptionResponse>> getSubscriptions(GetSubscriptionRequest request);

    /**
     * Subscribes to competitions.
     *
     * @param request The request containing the competition subscriptions
     * @return A {@link Mono} emitting the {@link CompetitionSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<CompetitionSubscriptionCollectionResponse>> subscribeByCompetition(CompetitionSubscriptionRequest request);

    /**
     * Unsubscribes from competitions.
     *
     * @param request The request containing the competition subscriptions
     * @return A {@link Mono} emitting the {@link CompetitionSubscriptionCollectionResponse}
     */
    Mono<BaseResponse<CompetitionSubscriptionCollectionResponse>> unSubscribeByCompetition(CompetitionSubscriptionRequest request);

    /**
     * Gets all manual suspensions.
     *
     * @return A {@link Mono} emitting the {@link GetManualSuspensionResponse}
     */
    Mono<BaseResponse<GetManualSuspensionResponse>> getAllManualSuspensions();

    /**
     * Adds a manual suspension.
     *
     * @param request The request containing the suspensions to be added
     * @return A {@link Mono} emitting the {@link ChangeManualSuspensionResponse}
     */
    Mono<BaseResponse<ChangeManualSuspensionResponse>> addManualSuspension(ChangeManualSuspensionRequest request);

    /**
     * Removes a manual suspension.
     *
     * @param request The request containing the suspensions to be removed
     * @return A {@link Mono} emitting the {@link ChangeManualSuspensionResponse}
     */
    Mono<BaseResponse<ChangeManualSuspensionResponse>> removeManualSuspension(ChangeManualSuspensionRequest request);
}