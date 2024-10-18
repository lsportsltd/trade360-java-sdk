package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
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
    Mono<PackageQuotaResponse> getPackageQuota();

    /**
     * Gets the in-play fixture schedule.
     *
     * @param request The request containing the parameters
     * @return A {@link Mono} emitting the {@link FixtureScheduleCollectionResponse}
     */
    Mono<FixtureScheduleCollectionResponse> getInPlayFixtureSchedule(GetFixtureScheduleRequest request);

    /**
     * Subscribes to fixtures.
     *
     * @param request The request containing the fixture IDs
     * @return A {@link Mono} emitting the {@link FixtureSubscriptionCollectionResponse}
     */
    Mono<FixtureSubscriptionCollectionResponse> subscribeByFixture(FixtureSubscriptionRequest request);

    /**
     * Unsubscribes from fixtures.
     *
     * @param request The request containing the fixture IDs
     * @return A {@link Mono} emitting the {@link FixtureSubscriptionCollectionResponse}
     */
    Mono<FixtureSubscriptionCollectionResponse> unSubscribeByFixture(FixtureSubscriptionRequest request);

    /**
     * Subscribes to leagues.
     *
     * @param request The request containing the league subscriptions
     * @return A {@link Mono} emitting the {@link LeagueSubscriptionCollectionResponse}
     */
    Mono<LeagueSubscriptionCollectionResponse> subscribeByLeague(LeagueSubscriptionRequest request);

    /**
     * Unsubscribes from leagues.
     *
     * @param request The request containing the league subscriptions
     * @return A {@link Mono} emitting the {@link LeagueSubscriptionCollectionResponse}
     */
    Mono<LeagueSubscriptionCollectionResponse> unSubscribeByLeague(LeagueSubscriptionRequest request);

    /**
     * Gets the current subscriptions.
     *
     * @param request The request containing the parameters
     * @return A {@link Mono} emitting the {@link GetSubscriptionResponse}
     */
    Mono<GetSubscriptionResponse> getSubscriptions(GetSubscriptionRequest request);

    /**
     * Subscribes to competitions.
     *
     * @param request The request containing the competition subscriptions
     * @return A {@link Mono} emitting the {@link CompetitionSubscriptionCollectionResponse}
     */
    Mono<CompetitionSubscriptionCollectionResponse> subscribeByCompetition(CompetitionSubscriptionRequest request);

    /**
     * Unsubscribes from competitions.
     *
     * @param request The request containing the competition subscriptions
     * @return A {@link Mono} emitting the {@link CompetitionSubscriptionCollectionResponse}
     */
    Mono<CompetitionSubscriptionCollectionResponse> unSubscribeByCompetition(CompetitionSubscriptionRequest request);

    /**
     * Gets all manual suspensions.
     *
     * @return A {@link Mono} emitting the {@link GetManualSuspensionResponse}
     */
    Mono<GetManualSuspensionResponse> getAllManualSuspensions();

    /**
     * Adds a manual suspension.
     *
     * @param request The request containing the suspensions to be added
     * @return A {@link Mono} emitting the {@link ChangeManualSuspensionResponse}
     */
    Mono<ChangeManualSuspensionResponse> addManualSuspension(ChangeManualSuspensionRequest request);

    /**
     * Removes a manual suspension.
     *
     * @param request The request containing the suspensions to be removed
     * @return A {@link Mono} emitting the {@link ChangeManualSuspensionResponse}
     */
    Mono<ChangeManualSuspensionResponse> removeManualSuspension(ChangeManualSuspensionRequest request);
}