package com.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
import com.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import reactor.core.publisher.Mono;

public class SubscriptionApiClientImplementation implements SubscriptionApiClient {

    private final ApiRestClient client;

    public SubscriptionApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    @Override
    public Mono<PackageQuotaResponse> getPackageQuota() {
        return this.client
                .postRequest(
                        new TypeReference<PackageQuotaResponse>() {},
                        "/package/GetPackageQuota");
    }

    @Override
    public Mono<FixtureScheduleCollectionResponse> getInPlayFixtureSchedule(GetFixtureScheduleRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<FixtureScheduleCollectionResponse>() {},
                        "Fixtures/InPlaySchedule"
                );
    }

    @Override
    public Mono<FixtureSubscriptionCollectionResponse> subscribeByFixture(FixtureSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<FixtureSubscriptionCollectionResponse>() {},
                        "Fixtures/Subscribe"
                );
    }

    @Override
    public Mono<FixtureSubscriptionCollectionResponse> unSubscribeByFixture(FixtureSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<FixtureSubscriptionCollectionResponse>() {},
                        "Fixtures/UnSubscribe"
                );
    }

    @Override
    public Mono<LeagueSubscriptionCollectionResponse> subscribeByLeague(LeagueSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<LeagueSubscriptionCollectionResponse>() {},
                        "Leagues/Subscribe"
                );
    }

    @Override
    public Mono<LeagueSubscriptionCollectionResponse> unSubscribeByLeague(LeagueSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<LeagueSubscriptionCollectionResponse>() {},
                        "Leagues/UnSubscribe"
                );
    }

    @Override
    public Mono<GetSubscriptionResponse> getSubscriptions(GetSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<GetSubscriptionResponse>() {},
                        "Fixtures/Get"
                );
    }

    @Override
    public Mono<CompetitionSubscriptionCollectionResponse> subscribeByCompetition(CompetitionSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<CompetitionSubscriptionCollectionResponse>() {},
                        "Outright/Subscribe"
                );
    }

    @Override
    public Mono<CompetitionSubscriptionCollectionResponse> unSubscribeByCompetition(CompetitionSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<CompetitionSubscriptionCollectionResponse>() {},
                        "Outright/UnSubscribe"
                );
    }

    @Override
    public Mono<GetManualSuspensionResponse> getAllManualSuspensions() {
        return this.client
                .postRequest(
                        new TypeReference<GetManualSuspensionResponse>() {},
                        "Markets/ManualSuspension/GetAll"
                );
    }

    @Override
    public Mono<ChangeManualSuspensionResponse> addManualSuspension(ChangeManualSuspensionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<ChangeManualSuspensionResponse>() {},
                        "Markets/ManualSuspension/Activate"
                );
    }

    @Override
    public Mono<ChangeManualSuspensionResponse> removeManualSuspension(ChangeManualSuspensionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<ChangeManualSuspensionResponse>() {},
                        "Markets/ManualSuspension/Deactivate"
                );
    }
}
