package com.lsports.trade360_java_sdk.customers_api.interfaces;

import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
import reactor.core.publisher.Mono;

public interface SubscriptionApiClient {

    Mono<PackageQuotaResponse> GetPackageQuota();

    Mono<FixtureScheduleCollectionResponse> GetInPlayFixtureSchedule(GetFixtureScheduleRequest request);

    Mono<FixtureSubscriptionCollectionResponse> SubscribeByFixture(FixtureSubscriptionRequest request);

    Mono<FixtureSubscriptionCollectionResponse> UnSubscribeByFixture(FixtureSubscriptionRequest request);

    Mono<LeagueSubscriptionCollectionResponse> SubscribeByLeague(LeagueSubscriptionRequest request);

    Mono<LeagueSubscriptionCollectionResponse> UnSubscribeByLeague(LeagueSubscriptionRequest request);

    Mono<GetSubscriptionResponse> GetSubscriptions(GetSubscriptionRequest request);

    Mono<CompetitionSubscriptionCollectionResponse> SubscribeByCompetition(CompetitionSubscriptionRequest requestDt);

    Mono<CompetitionSubscriptionCollectionResponse> UnSubscribeByCompetition(CompetitionSubscriptionRequest request);

    Mono<GetManualSuspensionResponse> GetAllManualSuspensions();

    Mono<ChangeManualSuspensionResponse> AddManualSuspension(ChangeManualSuspensionRequest request);

    Mono<ChangeManualSuspensionResponse> RemoveManualSuspension(ChangeManualSuspensionRequest request);
}
