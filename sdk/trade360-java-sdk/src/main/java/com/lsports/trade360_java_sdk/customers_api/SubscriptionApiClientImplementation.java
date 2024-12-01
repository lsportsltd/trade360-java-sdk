package com.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
import com.lsports.trade360_java_sdk.customers_api.interfaces.SubscriptionApiClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link SubscriptionApiClient} interface.
 */
public class SubscriptionApiClientImplementation implements SubscriptionApiClient {

    private final ApiRestClient client;

    /**
     * Constructs a new {@code SubscriptionApiClientImplementation} with the given {@link ApiRestClient}.
     *
     * @param client the {@link ApiRestClient} to use for making API requests
     */
    public SubscriptionApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<PackageQuotaResponse>> getPackageQuota() {
        return this.client
                .postRequest(
                        new TypeReference<BaseResponse<PackageQuotaResponse>>() {},
                        "/package/GetPackageQuota");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<FixtureScheduleCollectionResponse>> getInPlayFixtureSchedule(GetFixtureScheduleRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<FixtureScheduleCollectionResponse>>() {},
                        "Fixtures/InPlaySchedule"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<FixtureSubscriptionCollectionResponse>> subscribeByFixture(FixtureSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<FixtureSubscriptionCollectionResponse>>() {},
                        "Fixtures/Subscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<FixtureSubscriptionCollectionResponse>> unSubscribeByFixture(FixtureSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<FixtureSubscriptionCollectionResponse>>() {},
                        "Fixtures/UnSubscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<LeagueSubscriptionCollectionResponse>> subscribeByLeague(LeagueSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<LeagueSubscriptionCollectionResponse>>() {},
                        "Leagues/Subscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<LeagueSubscriptionCollectionResponse>> unSubscribeByLeague(LeagueSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<LeagueSubscriptionCollectionResponse>>() {},
                        "Leagues/UnSubscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSubscriptionResponse>> getSubscriptions(GetSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<GetSubscriptionResponse>>() {},
                        "Fixtures/Get"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<CompetitionSubscriptionCollectionResponse>> subscribeByCompetition(CompetitionSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<CompetitionSubscriptionCollectionResponse>>() {},
                        "Outright/Subscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<CompetitionSubscriptionCollectionResponse>> unSubscribeByCompetition(CompetitionSubscriptionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<CompetitionSubscriptionCollectionResponse>>() {},
                        "Outright/UnSubscribe"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetManualSuspensionResponse>> getAllManualSuspensions() {
        return this.client
                .postRequest(
                        new TypeReference<BaseResponse<GetManualSuspensionResponse>>() {},
                        "Markets/ManualSuspension/GetAll"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<ChangeManualSuspensionResponse>> addManualSuspension(ChangeManualSuspensionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<ChangeManualSuspensionResponse>>() {},
                        "Markets/ManualSuspension/Activate"
                );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<ChangeManualSuspensionResponse>> removeManualSuspension(ChangeManualSuspensionRequest request) {
        return this.client
                .postRequest(
                        request,
                        new TypeReference<BaseResponse<ChangeManualSuspensionResponse>>() {},
                        "Markets/ManualSuspension/Deactivate"
                );
    }
}
