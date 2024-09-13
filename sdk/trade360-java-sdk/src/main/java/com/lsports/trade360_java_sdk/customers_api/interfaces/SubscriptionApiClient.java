package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
import reactor.core.publisher.Mono;

public interface SubscriptionApiClient {

    Mono<PackageQuotaResponse> getPackageQuota();

    Mono<FixtureScheduleCollectionResponse> getInPlayFixtureSchedule(GetFixtureScheduleRequest request);

    Mono<FixtureSubscriptionCollectionResponse> subscribeByFixture(FixtureSubscriptionRequest request);

    Mono<FixtureSubscriptionCollectionResponse> unSubscribeByFixture(FixtureSubscriptionRequest request);

    Mono<LeagueSubscriptionCollectionResponse> subscribeByLeague(LeagueSubscriptionRequest request);

    Mono<LeagueSubscriptionCollectionResponse> unSubscribeByLeague(LeagueSubscriptionRequest request);

    Mono<GetSubscriptionResponse> getSubscriptions(GetSubscriptionRequest request);

    Mono<CompetitionSubscriptionCollectionResponse> subscribeByCompetition(CompetitionSubscriptionRequest requestDt);

    Mono<CompetitionSubscriptionCollectionResponse> unSubscribeByCompetition(CompetitionSubscriptionRequest request);

    Mono<GetManualSuspensionResponse> getAllManualSuspensions();

    Mono<ChangeManualSuspensionResponse> addManualSuspension(ChangeManualSuspensionRequest request);

    Mono<ChangeManualSuspensionResponse> removeManualSuspension(ChangeManualSuspensionRequest request);
}
