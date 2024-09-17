package com.lsports.trade360_snapshot_api_example;

import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.base.ApiExampleApplicationBase;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.springframework.SpringBootSnapshotApiClientFactory;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SnapshotApiExampleApplication extends ApiExampleApplicationBase{
    private final SnapshotApiClientFactory apiClientFactory;

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
        var preMatchSettings = new PackageCredentials(0, "userName", "password");
        var inPlaySettings = new PackageCredentials(0, "userName", "password");
        this.setJsonApiSerializerForExampleOutputs(new JacksonApiSerializer(preMatchSettings));

        this.preMatchSynchronousApi(URI.create("https://stm-snapshot.lsports.eu"), preMatchSettings);
        this.inPlaySynchronousApi(URI.create("https://stm-snapshot.lsports.eu"), inPlaySettings);

        this.preMatchAsynchronousApi(URI.create("https://stm-snapshot.lsports.eu"), preMatchSettings);
        this.inPlayAsynchronousApi(URI.create("https://stm-snapshot.lsports.eu"), inPlaySettings);
    }

    private void preMatchSynchronousApi(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== PREMATCH SYNCHRONOUS API EXAMPLES: ====");

        this.executeSynchronous("Get Fixtures",
            () -> preMatchClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Livescore",
            () -> preMatchClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Fixture Markets",
            () -> preMatchClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Events",
            () -> preMatchClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright Events",
            () -> preMatchClient.getOutrightEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright Fixture",
            () -> preMatchClient.getOutrightFixture(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright Scores",
            () -> preMatchClient.getOutrightScores(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright Fixture Markets",
            () -> preMatchClient.getOutrightFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright Leagues",
            () -> preMatchClient.getOutrightLeagues(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Outright League Markets",
            () -> preMatchClient.getOutrightLeagueMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
    }

    private void preMatchAsynchronousApi(URI baseUrl, PackageCredentials settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(baseUrl, settings);

        System.out.println();
        System.out.println("=============================================");
        System.out.println("==== PREMATCH ASYNCHRONOUS API EXAMPLES: ====");

        this.executeAsynchronous("Async Get Fixtures",
            () -> preMatchClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Livescore",
            () -> preMatchClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Fixture Markets",
            () -> preMatchClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Events",
            () -> preMatchClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright Events",
            () -> preMatchClient.getOutrightEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright Fixture",
            () -> preMatchClient.getOutrightFixture(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright Scores",
            () -> preMatchClient.getOutrightScores(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright Fixture Markets",
            () -> preMatchClient.getOutrightFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright Leagues",
            () -> preMatchClient.getOutrightLeagues(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Outright League Markets",
            () -> preMatchClient.getOutrightLeagueMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.waitForAllAsyncFinish();
    }

    private void inPlaySynchronousApi(URI baseUrl, PackageCredentials settings) {
        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, settings);

        System.out.println();
        System.out.println("============================================");
        System.out.println("===== INPLAY SYNCHRONOUS API EXAMPLES: =====");
        this.executeSynchronous("Get Fixtures",
            () -> inPlayClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Livescore",
            () -> inPlayClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Fixture Markets",
            () -> inPlayClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeSynchronous("Get Events",
            () -> inPlayClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
    }

    private void inPlayAsynchronousApi(URI baseUrl, PackageCredentials settings) {
        var inPlayClient = this.apiClientFactory.createInPlayApiClient(baseUrl, settings);

        System.out.println();
        System.out.println("=============================================");
        System.out.println("===== INPLAY ASYNCHRONOUS API EXAMPLES: =====");
        this.executeAsynchronous("Async Get Fixtures",
            () -> inPlayClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Livescore",
            () -> inPlayClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Fixture Markets",
            () -> inPlayClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.executeAsynchronous("Async Get Events",
            () -> inPlayClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.waitForAllAsyncFinish();
    }
}
