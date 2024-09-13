package com.lsports.trade360_customer_api_example;

import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClient;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClient;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class CustomerApiExampleApplication {
    private final CustomersApiClient apiClientFactory;
    private JsonApiSerializer jsonApiSerializer;

    public CustomerApiExampleApplication(CustomersApiClient factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiExampleApplication.class, args);
    }

    @Bean
    public static CustomersApiClient configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClient(webClientBuilder);
    }

    @PostConstruct
    public void run() {
        var packageSettings = new PackageCredentials(2, "1", "Tests1234");
        this.jsonApiSerializer = new JacksonApiSerializer(packageSettings);

        this.synchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
        this.asynchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
    }

    private void synchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS CUSTOMER API EXAMPLES: ====");

        this.executeSynchronous("Sync GetPackageQuota without parameters",
                () -> client.GetPackageQuota());
        this.executeSynchronous("Sync GetInPlayFixtureSchedule with parameters",
                new GetFixtureScheduleRequest(List.of(1),List.of(1),List.of(1)),
                request -> client.GetInPlayFixtureSchedule(request));
        this.executeSynchronous("Sync SubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request-> client.SubscribeByFixture(request));
        this.executeSynchronous("Sync UnSubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request -> client.UnSubscribeByFixture(request));
        this.executeSynchronous("Sync SubscribeByLeague with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.SubscribeByLeague(request));
        this.executeSynchronous("Sync UnSubscribeByFixture with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.UnSubscribeByLeague(request));
        this.executeSynchronous("Sync GetSubscriptions with parameters",
                new GetSubscriptionRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.GetSubscriptions(request));
        this.executeSynchronous("Sync SubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.SubscribeByCompetition(request));
        this.executeSynchronous("Sync UnSubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.UnSubscribeByCompetition(request));
        this.executeSynchronous("Sync GetAllManualSuspensions without parameters",
                () -> client.GetAllManualSuspensions());
        this.executeSynchronous("Sync AddManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of(new Suspension(true,1,1,1,1,null , null))),
                request -> client.AddManualSuspension(request));
        this.executeSynchronous("Sync RemoveManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1,null , null))),
                request -> client.RemoveManualSuspension(request));
    }

    private void asynchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== ASYNCHRONOUS CUSTOMER API EXAMPLES: =====");

        this.executeAsynchronous("Sync GetPackageQuota without parameters",
                () -> client.GetPackageQuota());
        this.executeAsynchronous("Sync GetInPlayFixtureSchedule with parameters",
                new GetFixtureScheduleRequest(List.of(1),List.of(1),List.of(1)),
                request -> client.GetInPlayFixtureSchedule(request));
        this.executeAsynchronous("Sync SubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request-> client.SubscribeByFixture(request));
        this.executeAsynchronous("Sync UnSubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request -> client.UnSubscribeByFixture(request));
        this.executeAsynchronous("Sync SubscribeByLeague with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.SubscribeByLeague(request));
        this.executeAsynchronous("Sync UnSubscribeByFixture with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.UnSubscribeByLeague(request));
        this.executeAsynchronous("Sync GetSubscriptions with parameters",
                new GetSubscriptionRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.GetSubscriptions(request));
        this.executeAsynchronous("Sync SubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.SubscribeByCompetition(request));
        this.executeAsynchronous("Sync UnSubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.UnSubscribeByCompetition(request));
        this.executeAsynchronous("Sync GetAllManualSuspensions without parameters",
                () -> client.GetAllManualSuspensions());
        this.executeAsynchronous("Sync AddManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.AddManualSuspension(request));
        this.executeAsynchronous("Sync RemoveManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.RemoveManualSuspension(request));
    }

    private <R> void executeSynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeSynchronous(exampleName, null, request -> executeFunction.get());
    }

    private <T, R> void executeSynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        System.out.println("--------------------------------");
        try {
            if (request == null) {
                System.out.println("[" + exampleName + "] - Executing request");
            } else {
                System.out.println("[" + exampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serialize(request));
            }
            var responseMono = executeFunction.apply(request);
            var response = responseMono.block();
            System.out.println("Response received: " + this.jsonApiSerializer.serialize(response));
        } catch (Trade360Exception ex) {
            System.err.println("Failed: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Unhandled exception: " + ex.getMessage());
        }
    }

    private <R> void executeAsynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeAsynchronous(exampleName, null, request -> executeFunction.get());
    }

    private <T, R> void executeAsynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        System.out.println("--------------------------------");
        if (request == null) {
            System.out.println("[" + exampleName + "] - Executing request");
        } else {
            System.out.println("[" + exampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serialize(request));
        }
        var responseMono = executeFunction.apply(request);
        responseMono
                .subscribe(
                        response -> {
                            System.out.println("--------------------------------");
                            System.out.println("[" + exampleName + "] - Got response: " + this.jsonApiSerializer.serialize(response));
                        },
                        exception -> System.err.println("Failed: " + exception.getMessage()));
    }
}
