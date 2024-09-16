package com.lsports.trade360_customer_api_example;

import com.lsports.base.ApiExampleApplicationBase;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetCompetitionsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetMarketsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesMetadataRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetTranslationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@SpringBootApplication
public class CustomerApiExampleApplication extends ApiExampleApplicationBase{
    private final URI baseUri = URI.create("https://stm-api.lsports.eu");
    private final CustomersApiClientFactory apiClientFactory;

    public CustomerApiExampleApplication(CustomersApiClientFactory factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiExampleApplication.class, args);
    }

    @PostConstruct
    public void run() {
        var packageCredentials = new PackageCredentials(0, "userName", "password");
        this.setExampleJsonApiSerializer(new JacksonApiSerializer(packageCredentials));
        this.subscriptionApiExample(packageCredentials);
        this.metadataApiExample(packageCredentials);
        this.packageDistributionApiExample(packageCredentials);
    }

    private void metadataApiExample(PackageCredentials packageCredentials) {
        this.synchronousMetadataApiExample(this.baseUri, packageCredentials);
        this.asynchronousMetadataApiExample(this.baseUri, packageCredentials);
    }

    private void subscriptionApiExample(PackageCredentials packageCredentials) {
        this.synchronousSubscriptionApiExample(this.baseUri, packageCredentials);
        this.asynchronousSubscriptionApiExample(this.baseUri, packageCredentials);
    }

    private void packageDistributionApiExample(PackageCredentials packageCredentials) {
        this.synchronousPackageDistributionApiExample(this.baseUri, packageCredentials);
        this.asynchronousPackageDistributionApiExample(this.baseUri, packageCredentials);
    }

    private void synchronousPackageDistributionApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS PACKAGE DISTRIBUTION API EXAMPLES: ====");

        this.executeSynchronous("getDistributionStatusAsync without parameters",
            () -> client.getDistributionStatusAsync());
        this.executeSynchronous("startDistribution without parameters",
            () -> client.startDistribution());
        this.executeSynchronous("stopDistribution without parameters",
            () -> client.stopDistribution());
    }

    private void asynchronousPackageDistributionApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== PACKAGE DISTRIBUTION API EXAMPLES: =====");

        this.executeAsynchronous("getDistributionStatusAsync without parameters",
            () -> client.getDistributionStatusAsync());
        this.executeAsynchronous("startDistribution without parameters",
            () -> client.startDistribution());
        this.executeAsynchronous("stopDistribution without parameters",
            () -> client.stopDistribution());
        this.waitForAllAsyncSamples();
    }

    private void synchronousMetadataApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS METADATA API EXAMPLES: ====");

        this.executeSynchronous("GetSports without parameters",
            () -> client.getSports());
        this.executeSynchronous("GetSports with parameters",
            new GetSportsRequest(6),
            request -> client.getSports(request));
        this.executeSynchronous("GetLocations without parameters",
            () -> client.getLocations());
        this.executeSynchronous("GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
        this.executeSynchronous("GetLeagues with parameters",
            new GetLeaguesRequest(List.of(6046, 48242), List.of(22, 161), SubscriptionState.ALL, 6),
            request -> client.getLeagues(request));
        this.executeSynchronous("GetMarkets with parameters",
            new GetMarketsRequest(List.of(6046, 48242), List.of(22, 161), null, null, false, MarketType.STANDARD, null),
            request -> client.getMarkets(request));
        this.executeSynchronous("GetTranslations with parameters",
            new GetTranslationsRequest(List.of(6, 38), List.of(6046, 48242), List.of(22, 161), null, null, null),
            request -> client.getTranslations(request));
        this.executeSynchronous("GetCompetitions with parameters",
            new GetCompetitionsRequest(List.of(), List.of(22, 161), null, SubscriptionState.ALL),
            request -> client.getCompetitions(request));
        this.executeSynchronous("GetSubscribedFixtures with parameters",
            new GetSubscribedFixturesRequest(List.of(6046, 48242), List.of(22, 161), null),
            request -> client.getSubscribedFixtures(request));
        this.executeSynchronous("GetSubscribedFixturesMetadata with parameters",
            new GetSubscribedFixturesMetadataRequest(LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))),
            request -> client.getSubscribedFixturesMetadata(request));
    }

    private void asynchronousMetadataApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== ASYNCHRONOUS METADATA API EXAMPLES: =====");
        this.executeAsynchronous("GetSports without parameters",
            () -> client.getSports());
        this.executeAsynchronous("GetSports with parameters",
            new GetSportsRequest(6),
            request -> client.getSports(request));
        this.executeAsynchronous("GetLocations without parameters",
            () -> client.getLocations());
        this.executeAsynchronous("GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
        this.executeAsynchronous("GetLeagues with parameters",
            new GetLeaguesRequest(List.of(6046, 48242), List.of(22, 161), SubscriptionState.ALL, 6),
            request -> client.getLeagues(request));
        this.executeAsynchronous("GetMarkets with parameters",
            new GetMarketsRequest(List.of(6046, 48242), List.of(22, 161), null, null, false, MarketType.STANDARD, null),
            request -> client.getMarkets(request));
        this.executeAsynchronous("GetTranslations with parameters",
            new GetTranslationsRequest(List.of(6, 38), List.of(6046, 48242), List.of(22, 161), null, null, null),
            request -> client.getTranslations(request));
        this.executeAsynchronous("GetCompetitions with parameters",
            new GetCompetitionsRequest(List.of(), List.of(22, 161), null, SubscriptionState.ALL),
            request -> client.getCompetitions(request));
        this.executeAsynchronous("GetSubscribedFixtures with parameters",
            new GetSubscribedFixturesRequest(List.of(6046, 48242), List.of(22, 161), null),
            request -> client.getSubscribedFixtures(request));
        this.executeAsynchronous("GetSubscribedFixturesMetadata with parameters",
            new GetSubscribedFixturesMetadataRequest(LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))),
            request -> client.getSubscribedFixturesMetadata(request));
        this.waitForAllAsyncSamples();
    }

    private void synchronousSubscriptionApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS SUBSCRIPTION API EXAMPLES: ====");

        this.executeSynchronous("GetPackageQuota without parameters",
                () -> client.getPackageQuota());
        this.executeSynchronous("GetInPlayFixtureSchedule with parameters",
                new GetFixtureScheduleRequest(List.of(1),List.of(1),List.of(1)),
                request -> client.getInPlayFixtureSchedule(request));
        this.executeSynchronous("SubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request-> client.subscribeByFixture(request));
        this.executeSynchronous("UnSubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request -> client.unSubscribeByFixture(request));
        this.executeSynchronous("SubscribeByLeague with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.subscribeByLeague(request));
        this.executeSynchronous("UnSubscribeByFixture with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.unSubscribeByLeague(request));
        this.executeSynchronous("GetSubscriptions with parameters",
                new GetSubscriptionRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.getSubscriptions(request));
        this.executeSynchronous("SubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.subscribeByCompetition(request));
        this.executeSynchronous("UnSubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.unSubscribeByCompetition(request));
        this.executeSynchronous("GetAllManualSuspensions without parameters",
                () -> client.getAllManualSuspensions());
        this.executeSynchronous("AddManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of(new Suspension(true,1,1,1,1,LocalDateTime.now(), null))),
                request -> client.addManualSuspension(request));
        this.executeSynchronous("RemoveManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1,LocalDateTime.now(), null))),
                request -> client.removeManualSuspension(request));
    }

    private void asynchronousSubscriptionApiExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== ASYNCHRONOUS SUBSCRIPTION API EXAMPLES: =====");

        this.executeAsynchronous("GetPackageQuota without parameters",
                () -> client.getPackageQuota());
        this.executeAsynchronous("GetInPlayFixtureSchedule with parameters",
                new GetFixtureScheduleRequest(List.of(1),List.of(1),List.of(1)),
                request -> client.getInPlayFixtureSchedule(request));
        this.executeAsynchronous("SubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request-> client.subscribeByFixture(request));
        this.executeAsynchronous("UnSubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request -> client.unSubscribeByFixture(request));
        this.executeAsynchronous("SubscribeByLeague with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.subscribeByLeague(request));
        this.executeAsynchronous("UnSubscribeByFixture with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.unSubscribeByLeague(request));
        this.executeAsynchronous("GetSubscriptions with parameters",
                new GetSubscriptionRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.getSubscriptions(request));
        this.executeAsynchronous("SubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.subscribeByCompetition(request));
        this.executeAsynchronous("UnSubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.unSubscribeByCompetition(request));
        this.executeAsynchronous("GetAllManualSuspensions without parameters",
                () -> client.getAllManualSuspensions());
        this.executeAsynchronous("AddManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.addManualSuspension(request));
        this.executeAsynchronous("RemoveManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.removeManualSuspension(request));
        this.waitForAllAsyncSamples();
    }
}
