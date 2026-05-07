package eu.lsports.trade360_snapshot_api_example;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SpringBootSnapshotApiClientFactory;
import eu.lsports.trade360_snapshot_api_example.configuration.SnapshotApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import eu.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import eu.lsports.base.ApiExampleApplicationBase;
import eu.lsports.trade360_java_sdk.common.serialization.JacksonApiSerializer;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableConfigurationProperties(SnapshotApiConfiguration.class)
public class SnapshotApiExampleApplication extends ApiExampleApplicationBase{
    private URI baseUri;
    private final SnapshotApiClientFactory apiClientFactory;
    private PackageCredentials inPlayPackageCredentials;

    private PackageCredentials preMatchPackageCredentials;

    @Autowired
    private SnapshotApiConfiguration snapshotApiConfiguration;
    public SnapshotApiExampleApplication(SnapshotApiClientFactory factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(SnapshotApiExampleApplication.class, args);
    }

    @Bean
    public static SnapshotApiClientFactory configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootSnapshotApiClientFactory(webClientBuilder);
    }

    @PostConstruct
    public void run() {
        this.baseUri = URI.create(snapshotApiConfiguration.base_snapshot_api);
        this.inPlayPackageCredentials = new PackageCredentials(snapshotApiConfiguration.inplay.package_id, snapshotApiConfiguration.inplay.user_name, snapshotApiConfiguration.inplay.password);
        this.setJsonApiSerializerForExampleOutputs(new JacksonApiSerializer(inPlayPackageCredentials));
        this.preMatchPackageCredentials = new PackageCredentials(snapshotApiConfiguration.prematch.package_id, snapshotApiConfiguration.prematch.user_name, snapshotApiConfiguration.prematch.password);
        this.setJsonApiSerializerForExampleOutputs(new JacksonApiSerializer(preMatchPackageCredentials));
        displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===============================================");
            System.out.println("Customer API Example Application");
            System.out.println("===============================================");
            System.out.println("1. Snapshot API - Get Fixtures");
            System.out.println("2. Snapshot API - Get Events");
            System.out.println("3. Snapshot API - Get Fixture Markets");
            System.out.println("4. Snapshot API - Get Livescore");
            System.out.println("5. Snapshot API - Get Outright Fixtures");
            System.out.println("6. Snapshot API - Get Outright Livescore");
            System.out.println("7. Snapshot API - Get Outright Markets");
            System.out.println("8. Snapshot API - Get Outright Events");
            System.out.println("9. Snapshot API - Get Outright Leagues Fixtures");
            System.out.println("10. Snapshot API - Get Outright Leagues Markets");
            System.out.println("11. Snapshot API - Get Outright Leagues Events");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getFixtures(baseUri, preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 2:
                    getEvents(baseUri, preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 3:
                    getFixtureMarkets(baseUri, preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 4:
                    getLivescore(baseUri,preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 5:
                    getOutrightFixture(baseUri,preMatchPackageCredentials);
                    break;
                case 6:
                    getOutrightScores(baseUri,preMatchPackageCredentials);
                    break;
                case 7:
                    getOutrightFixtureMarkets(baseUri,preMatchPackageCredentials);
                    break;
                case 8:
                    getOutrightEvents(baseUri,preMatchPackageCredentials);
                    break;
                case 9:
                    getOutrightLeagues(baseUri,preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 10:
                    getOutrightLeagueMarkets(baseUri,preMatchPackageCredentials, inPlayPackageCredentials);
                    break;
                case 11:
                    getOutrightLeagueEvents(baseUri,preMatchPackageCredentials, inPlayPackageCredentials);
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


    private void getFixtures(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Fixtures",
                new GetFixtureRequest(null, null, null, List.of(6046), List.of(4), null, null),
                preMatchClient::getFixtures);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Fixtures",
                new GetFixtureRequest(null, null, null, List.of(6046), List.of(171), List.of(170), List.of(13903501)),
                inPlayClient::getFixtures);
    }

    private void getLivescore(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Livescore",
                new GetLivescoreRequest(null, null, null, List.of(35232), List.of(73), null, null),
                preMatchClient::getLivescore);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Livescore",
                new GetLivescoreRequest(null, null, null, List.of(6046), List.of(171), null, null),
                inPlayClient::getLivescore);
        this.waitForAllAsyncFinish();
    }

    private void getFixtureMarkets(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Fixture Markets",
                new GetMarketRequest(null, null, null, List.of(35232), List.of(73), null, null),
                preMatchClient::getFixtureMarkets);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Fixture Markets",
                new GetMarketRequest(null, null, null, List.of(6046), List.of(171), null, null),
                inPlayClient::getFixtureMarkets);
        this.waitForAllAsyncFinish();
    }

    private void getEvents(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Events",
                new GetEventRequest(null, null, null, List.of(35232), List.of(73), null, null),
                preMatchClient::getEvents);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Events",
                new GetInPlayEventRequest(null, null, null,List.of(6046), List.of(171), null, null, null),
                inPlayClient::getEvents);
        this.waitForAllAsyncFinish();
    }

    private void getOutrightEvents(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);
        this.executeAsynchronous("PreMatch Async Get Outright Events",
                new GetOutrightEventRequest(null, null, null, null,null, null, null,null, null ),
                preMatchClient::getOutrightEvents);
    }

    private void getOutrightFixture(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);
        this.executeAsynchronous("PreMatch Async Get Outright Fixture",
                new GetOutrightFixtureRequest(null, null, null, null, null, null,null ),
                preMatchClient::getOutrightFixture);
    }

    private void getOutrightScores(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);
        this.executeAsynchronous("PreMatch Async Get Outright Scores",
                new GetOutrightLivescoreRequest(null, null, null, null, null, null,null ),
                preMatchClient::getOutrightScores);
    }

    private void getOutrightFixtureMarkets(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);
        this.executeAsynchronous("PreMatch Async Get Outright Fixture Markets",
        new GetOutrightMarketRequest(null, null, null, null, null, null, List.of(16670634), null ),
                preMatchClient::getOutrightFixtureMarkets);
    }

    private void getOutrightLeagues(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Outright Leagues",
        new GetOutrightLeaguesRequest(null, null, null, null, null, null, null ),
                preMatchClient::getOutrightLeagues);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Outright Leagues",
                new GetOutrightLeaguesRequest(null, null, null, null, null, null, null),
                inPlayClient::getOutrightLeagues);
        this.waitForAllAsyncFinish();
    }

    private void getOutrightLeagueMarkets(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Outright League Markets",
        new GetOutrightLeagueMarketRequest(null, null, null,null, null, null, null , null),
                preMatchClient::getOutrightLeagueMarkets);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Outright League Markets",
                new GetOutrightLeagueMarketRequest(null, null, null, null, null, null, null, null),
                inPlayClient::getOutrightLeagueMarkets);
        this.waitForAllAsyncFinish();
    }

    private void getOutrightLeagueEvents(URI baseUrl, PackageCredentials preMatchSettings, PackageCredentials inPlaySettings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, preMatchSettings);
        this.executeAsynchronous("PreMatch Async Get Outright League Events",
                new GetOutrightLeagueEventsRequest(null, null, null, null, null, null, null , null),
                preMatchClient::getOutrightLeagueEvents);

        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, inPlaySettings);
        this.executeAsynchronous("InPlay Async Get Outright League Events",
                new GetOutrightLeagueEventsRequest(null, null, null, null, null, null, null, null),
                inPlayClient::getOutrightLeagueEvents);
        this.waitForAllAsyncFinish();
    }
}
