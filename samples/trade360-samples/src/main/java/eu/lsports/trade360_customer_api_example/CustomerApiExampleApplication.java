package eu.lsports.trade360_customer_api_example;

import eu.lsports.base.ApiExampleApplicationBase;
import eu.lsports.trade360_customer_api_example.configuration.CustomerApiConfiguration;
import eu.lsports.trade360_java_sdk.common.serialization.JacksonApiSerializer;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetCompetitionsRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetMarketsRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesMetadataRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetTranslationsRequest;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties(CustomerApiConfiguration.class)
public class CustomerApiExampleApplication extends ApiExampleApplicationBase{
    private URI baseUri;
    private final CustomersApiClientFactory apiClientFactory;
    private PackageCredentials inPlayPackageCredentials;

    private PackageCredentials preMatchPackageCredentials;

    @Autowired
    private CustomerApiConfiguration customerApiConfiguration;
    public CustomerApiExampleApplication(CustomersApiClientFactory factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiExampleApplication.class, args);
    }

    @PostConstruct
    public void run() {
        this.baseUri = URI.create(customerApiConfiguration.base_customers_api);
        this.inPlayPackageCredentials = new PackageCredentials(customerApiConfiguration.inplay.package_id, customerApiConfiguration.inplay.user_name, customerApiConfiguration.inplay.password);
        this.setJsonApiSerializerForExampleOutputs(new JacksonApiSerializer(inPlayPackageCredentials));
        this.preMatchPackageCredentials = new PackageCredentials(customerApiConfiguration.prematch.package_id, customerApiConfiguration.prematch.user_name, customerApiConfiguration.prematch.password);
        this.setJsonApiSerializerForExampleOutputs(new JacksonApiSerializer(preMatchPackageCredentials));

        displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===============================================");
            System.out.println("Customer API Example Application");
            System.out.println("===============================================");
            System.out.println("1. Metadata API - Get Fixture Metadata");
            System.out.println("2. Metadata API - Get Competitions");
            System.out.println("3. Metadata API - Get Translations");
            System.out.println("4. Metadata API - Get Markets");
            System.out.println("5. Metadata API - Get Sports");
            System.out.println("6. Metadata API - Get Locations");
            System.out.println("7. Metadata API - Get Leagues");
            System.out.println("8. Subscription API - Subscribe to Fixture");
            System.out.println("9. Subscription API - Unsubscribe from Fixture");
            System.out.println("10. Subscription API - Subscribe to League");
            System.out.println("11. Subscription API - Unsubscribe from League");
            System.out.println("12. Subscription API - Get Subscribed Fixtures");
            System.out.println("13. Subscription API - Subscribe to Outright Competition");
            System.out.println("14. Subscription API - Unsubscribe from Outright Competition");
            System.out.println("15. Subscription API - Get Inplay Fixture Schedule");
            System.out.println("16. Subscription API - Get All Manual Suspensions");
            System.out.println("17. Subscription API - Add Manual Suspension");
            System.out.println("18. Subscription API - Remove Manual Suspension");
            System.out.println("19. Subscription API - Get Package Quota");
            System.out.println("20. Package Distribution API - Get Distribution Status");
            System.out.println("21. Package Distribution API - Start Distribution");
            System.out.println("22. Package Distribution API - Stop Distribution");
            System.out.println("23. Package Information API - Get ProviderOdds type");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getSubscribedFixturesMetadata(baseUri, preMatchPackageCredentials);
                    break;
                case 2:
                    getCompetitions(baseUri, preMatchPackageCredentials);
                    break;
                case 3:
                    getTranslations(baseUri, preMatchPackageCredentials);
                    break;
                case 4:
                    getMarkets(baseUri,preMatchPackageCredentials);
                    break;
                case 5:
                    getSports(baseUri,preMatchPackageCredentials);
                    break;
                case 6:
                    getLocations(baseUri,preMatchPackageCredentials);
                    break;
                case 7:
                    getLeagues(baseUri,preMatchPackageCredentials);
                    break;
                case 8:
                    subscribeByFixture(baseUri,preMatchPackageCredentials);
                    break;
                case 9:
                    unSubscribeByFixture(baseUri,preMatchPackageCredentials);
                    break;
                case 10:
                    subscribeByLeague(baseUri,preMatchPackageCredentials);
                    break;
                case 11:
                    unSubscribeByLeague(baseUri,preMatchPackageCredentials);
                    break;
                case 12:
                    getSubscribedFixtures(baseUri,preMatchPackageCredentials);
                    break;
                case 13:
                    subscribeByCompetition(baseUri,preMatchPackageCredentials);
                    break;
                case 14:
                    unSubscribeByCompetition(baseUri,preMatchPackageCredentials);
                    break;
                case 15:
                    getInPlayFixtureSchedule(baseUri,inPlayPackageCredentials);
                    break;
                case 16:
                    getAllManualSuspensions(baseUri,preMatchPackageCredentials);
                    break;
                case 17:
                    addManualSuspension(baseUri,preMatchPackageCredentials);
                    break;
                case 18:
                    removeManualSuspension(baseUri,preMatchPackageCredentials);
                    break;
                case 19:
                    getPackageQuota(baseUri,inPlayPackageCredentials);
                    break;
                case 20:
                    getDistributionStatus(baseUri,preMatchPackageCredentials);
                    break;
                case 21:
                    startDistribution(baseUri,preMatchPackageCredentials);
                    break;
                case 22:
                    stopDistribution(baseUri,preMatchPackageCredentials);
                    break;
                case 23:
                    getProviderOddsType(baseUri,preMatchPackageCredentials);
                    getProviderOddsType(baseUri,inPlayPackageCredentials);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            this.waitForAllAsyncFinish();
        }
    }

    private void getProviderOddsType(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageQueryApiHttpClient(baseUri, credentials);
       this.executeAsynchronous("getProviderOddsType without parameters",
            () -> client.getProviderOddsType());
    }

    private void getDistributionStatus(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);
        this.executeAsynchronous("getDistributionStatus without parameters",
            () -> client.getDistributionStatus());
    }

    private void startDistribution(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);
        this.executeAsynchronous("startDistribution without parameters",
            () -> client.startDistribution());
    }

    private void stopDistribution(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);
        this.executeAsynchronous("stopDistribution without parameters",
            () -> client.stopDistribution());
    }

    private void getCompetitions(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetCompetitions with parameters",
                new GetCompetitionsRequest(List.of(), List.of(22, 161), null, SubscriptionState.ALL),
                request -> client.getCompetitions(request));
    }

    private void getSports(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetSports with parameters",
            new GetSportsRequest(null),
            request -> client.getSports(request));
    }

    private void getLocations(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
    }

    private void getLeagues(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetLeagues with parameters",
            new GetLeaguesRequest(List.of(6046, 48242), List.of(22, 161), SubscriptionState.ALL, 6),
            request -> client.getLeagues(request));
    }

    private void getMarkets(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetMarkets with parameters",
            new GetMarketsRequest(List.of(6046, 48242), List.of(22, 161), null, null, false, MarketType.STANDARD, null),
            request -> client.getMarkets(request));
    }

    private void getTranslations(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetTranslations with parameters",
            new GetTranslationsRequest(List.of(6, 38), List.of(6046, 48242), List.of(22, 161), null, null, null),
            request -> client.getTranslations(request));
    }

    private void getSubscribedFixtures(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetSubscribedFixtures with parameters",
            new GetSubscribedFixturesRequest(List.of(6046, 48242), List.of(22, 161), null),
            request -> client.getSubscribedFixtures(request));
    }

    private void getSubscribedFixturesMetadata(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetSubscribedFixturesMetadata with parameters",
            new GetSubscribedFixturesMetadataRequest(LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC")),null, null, null),
            request -> client.getSubscribedFixturesMetadata(request));
    }

    private void getPackageQuota(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetPackageQuota without parameters",
                () -> client.getPackageQuota());
    }

    private void getInPlayFixtureSchedule(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetInPlayFixtureSchedule with parameters",
                new GetFixtureScheduleRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.getInPlayFixtureSchedule(request));
    }

    private void subscribeByCompetition(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("SubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.subscribeByCompetition(request));
    }

    private void unSubscribeByCompetition(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("UnSubscribeByCompetition with parameters",
                new CompetitionSubscriptionRequest(List.of( new CompetitionSubscription(1,1,1))),
                request -> client.unSubscribeByCompetition(request));
    }

    private void subscribeByFixture(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("SubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request-> client.subscribeByFixture(request));
    }

    private void unSubscribeByFixture(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("UnSubscribeByFixture with parameters",
                new FixtureSubscriptionRequest(List.of(1)),
                request -> client.unSubscribeByFixture(request));
    }

    private void subscribeByLeague(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("SubscribeByLeague with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.subscribeByLeague(request));
    }

    private void unSubscribeByLeague(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("UnSubscribeByFixture with parameters",
                new LeagueSubscriptionRequest(List.of(new LeagueSubscription(1,1,1))),
                request -> client.unSubscribeByLeague(request));
    }

    private void getSubscriptions(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetSubscriptions with parameters",
                new GetSubscriptionRequest(List.of(1), List.of(1), List.of(1)),
                request -> client.getSubscriptions(request));
    }

    private void getAllManualSuspensions(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetAllManualSuspensions without parameters",
                () -> client.getAllManualSuspensions());
    }

    private void addManualSuspension(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("AddManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.addManualSuspension(request));
    }

    private void removeManualSuspension(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createSubscriptionApiHttpClient(baseUri, credentials);
        this.executeAsynchronous("RemoveManualSuspension with parameters",
                new ChangeManualSuspensionRequest(List.of( new Suspension(true,1,1,1,1, LocalDateTime.now(), null))),
                request -> client.removeManualSuspension(request));
    }
}
