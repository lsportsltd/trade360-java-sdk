package eu.lsports.trade360_customer_api_example;

import eu.lsports.base.ApiExampleApplicationBase;
import eu.lsports.trade360_customer_api_example.configuration.CustomerApiConfiguration;
import eu.lsports.trade360_java_sdk.common.serialization.JacksonApiSerializer;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
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
import java.util.function.Consumer;
import java.util.Arrays;

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

    private enum MenuOption {
        GET_SUBSCRIBED_FIXTURES_METADATA("Metadata API - Get Fixture Metadata", (app) -> app.getSubscribedFixturesMetadata(app.baseUri, app.preMatchPackageCredentials)),
        GET_COMPETITIONS("Metadata API - Get Competitions", (app) -> app.getCompetitions(app.baseUri, app.preMatchPackageCredentials)),
        GET_TRANSLATIONS("Metadata API - Get Translations", (app) -> app.getTranslations(app.baseUri, app.preMatchPackageCredentials)),
        GET_MARKETS("Metadata API - Get Markets", (app) -> app.getMarkets(app.baseUri, app.preMatchPackageCredentials)),
        GET_SPORTS("Metadata API - Get Sports", (app) -> app.getSports(app.baseUri, app.preMatchPackageCredentials)),
        GET_LOCATIONS("Metadata API - Get Locations", (app) -> app.getLocations(app.baseUri, app.preMatchPackageCredentials)),
        GET_LEAGUES("Metadata API - Get Leagues", (app) -> app.getLeagues(app.baseUri, app.preMatchPackageCredentials)),
        GET_VENUES("Metadata API - Get Venues", (app) -> app.getVenues(app.baseUri, app.preMatchPackageCredentials)),
        GET_CITIES("Metadata API - Get Cities", (app) -> app.getCities(app.baseUri, app.preMatchPackageCredentials)),
        GET_STATES("Metadata API - Get States", (app) -> app.getStates(app.baseUri, app.preMatchPackageCredentials)),
        Get_INCIDENTS("Metadata API - Get Incidents", (app) -> app.getIncidents(app.baseUri, app.preMatchPackageCredentials)),
        SUBSCRIBE_FIXTURE("Subscription API - Subscribe to Fixture", (app) -> app.subscribeByFixture(app.baseUri, app.preMatchPackageCredentials)),
        UNSUBSCRIBE_FIXTURE("Subscription API - Unsubscribe from Fixture", (app) -> app.unSubscribeByFixture(app.baseUri, app.preMatchPackageCredentials)),
        SUBSCRIBE_LEAGUE("Subscription API - Subscribe to League", (app) -> app.subscribeByLeague(app.baseUri, app.preMatchPackageCredentials)),
        UNSUBSCRIBE_LEAGUE("Subscription API - Unsubscribe from League", (app) -> app.unSubscribeByLeague(app.baseUri, app.preMatchPackageCredentials)),
        GET_SUBSCRIBED_FIXTURES("Subscription API - Get Subscribed Fixtures", (app) -> app.getSubscribedFixtures(app.baseUri, app.preMatchPackageCredentials)),
        GET_SUBSCRIPTIONS("Subscription API - Get Subscriptions", (app) -> app.getSubscriptions(app.baseUri, app.preMatchPackageCredentials)),
        SUBSCRIBE_COMPETITION("Subscription API - Subscribe to Outright Competition", (app) -> app.subscribeByCompetition(app.baseUri, app.preMatchPackageCredentials)),
        UNSUBSCRIBE_COMPETITION("Subscription API - Unsubscribe from Outright Competition", (app) -> app.unSubscribeByCompetition(app.baseUri, app.preMatchPackageCredentials)),
        GET_INPLAY_SCHEDULE("Subscription API - Get Inplay Fixture Schedule", (app) -> app.getInPlayFixtureSchedule(app.baseUri, app.inPlayPackageCredentials)),
        GET_ALL_SUSPENSIONS("Subscription API - Get All Manual Suspensions", (app) -> app.getAllManualSuspensions(app.baseUri, app.preMatchPackageCredentials)),
        ADD_SUSPENSION("Subscription API - Add Manual Suspension", (app) -> app.addManualSuspension(app.baseUri, app.preMatchPackageCredentials)),
        REMOVE_SUSPENSION("Subscription API - Remove Manual Suspension", (app) -> app.removeManualSuspension(app.baseUri, app.preMatchPackageCredentials)),
        GET_QUOTA("Subscription API - Get Package Quota", (app) -> app.getPackageQuota(app.baseUri, app.inPlayPackageCredentials)),
        GET_DISTRIBUTION_STATUS("Package Distribution API - Get Distribution Status", (app) -> app.getDistributionStatus(app.baseUri, app.preMatchPackageCredentials)),
        START_DISTRIBUTION("Package Distribution API - Start Distribution", (app) -> app.startDistribution(app.baseUri, app.preMatchPackageCredentials)),
        STOP_DISTRIBUTION("Package Distribution API - Stop Distribution", (app) -> app.stopDistribution(app.baseUri, app.preMatchPackageCredentials)),
        EXIT("Exit", (app) -> {
            System.out.println("Exiting...");
            System.exit(0);
        }) {
            @Override
            public int getOption() {
                return 0;
            }
        };

        private final String description;
        private final Consumer<CustomerApiExampleApplication> action;

        MenuOption(String description, Consumer<CustomerApiExampleApplication> action) {
            this.description = description;
            this.action = action;
        }

        public int getOption() {
            return this.ordinal() + 1;
        }

        public String getDescription() {
            return getOption() + ". " + description;
        }

        public static MenuOption fromOption(int option) {
            return Arrays.stream(values())
                    .filter(o -> o.getOption() == option)
                    .findFirst()
                    .orElse(null);
        }

        public void execute(CustomerApiExampleApplication app) {
            action.accept(app);
        }
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===============================================");
            System.out.println("Customer API Example Application");
            System.out.println("===============================================");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getDescription());
            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            MenuOption selected = MenuOption.fromOption(choice);
            if (selected != null) {
                selected.execute(this);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            this.waitForAllAsyncFinish();
        }
    }

    // <editor-fold desc="API Methods">
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

    private void getIncidents(URI baseUri, PackageCredentials credentials){
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetIncidents with parameters",
                new GetIncidentsRequest(new GetIncidentsRequest.IncidentsFilter(null, List.of(6046), null, null)),
                request -> client.getIncidents(request));
    }

    private void getVenues(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetVenues with parameters",
                new GetVenuesRequest(new GetVenuesRequest.VenuesFilter(null, null, null, null, null)),
                request -> client.getVenues(request));
    }

    private void getCities(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetCities with parameters",
                new GetCitiesRequest(new GetCitiesRequest.CitiesFilter(null, null)),
                request -> client.getCities(request));
    }

    private void getStates(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);
        this.executeAsynchronous("GetStates with parameters",
                new GetStatesRequest(new GetStatesRequest.CountriesFilter(null)),
                request -> client.getStates(request));
    }
    // </editor-fold>
}
