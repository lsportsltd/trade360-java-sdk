package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SubscriptionApiClientTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements SubscriptionApiClient {
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse>> getPackageQuota() { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.FixtureScheduleCollectionResponse>> getInPlayFixtureSchedule(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.GetFixtureScheduleRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.FixtureSubscriptionCollectionResponse>> subscribeByFixture(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.FixtureSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.FixtureSubscriptionCollectionResponse>> unSubscribeByFixture(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.FixtureSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.LeagueSubscriptionCollectionResponse>> subscribeByLeague(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.LeagueSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.LeagueSubscriptionCollectionResponse>> unSubscribeByLeague(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.LeagueSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetSubscriptionResponse>> getSubscriptions(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.GetSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.CompetitionSubscriptionCollectionResponse>> subscribeByCompetition(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.CompetitionSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.CompetitionSubscriptionCollectionResponse>> unSubscribeByCompetition(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.CompetitionSubscriptionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetManualSuspensionResponse>> getAllManualSuspensions() { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.ChangeManualSuspensionResponse>> addManualSuspension(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.ChangeManualSuspensionRequest request) { return null; }
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.ChangeManualSuspensionResponse>> removeManualSuspension(eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.ChangeManualSuspensionRequest request) { return null; }
            }
        });
    }
}
 