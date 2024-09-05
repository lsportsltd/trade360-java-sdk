package com.lsports.trade360_snapshot_api_example;

import java.net.URI;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.springframework.SpringBootSnapshotApiClientFactory;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SnapshotApiExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnapshotApiExampleApplication.class, args);
    }

    @Bean
    public static SnapshotApiClientFactory configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootSnapshotApiClientFactory(webClientBuilder);
    }

    private final SnapshotApiClientFactory apiClientFactory;

    public SnapshotApiExampleApplication(SnapshotApiClientFactory factory) {
        apiClientFactory = factory;
    }

    @PostConstruct
    public void run() {
        var preMatchSettings = new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 0, "userName", "password");
        var inPlaySettings = new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 0, "userName", "password");
        this.preMatchSynchronousApi(preMatchSettings);
        this.inPlaySynchronousApi(inPlaySettings);

        this.preMatchAsynchronousApi(preMatchSettings);
        this.inPlayAsynchronousApi(inPlaySettings);
    }

    private void preMatchSynchronousApi(SnapshotApiSettings settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(settings);

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

    private void preMatchAsynchronousApi(SnapshotApiSettings settings) {
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(settings);

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
    }

    private void inPlaySynchronousApi(SnapshotApiSettings settings) {
        var inPlayClient = this.apiClientFactory.createInPlayApiClient(settings);

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

    private void inPlayAsynchronousApi(SnapshotApiSettings settings) {
        var inPlayClient = this.apiClientFactory.createInPlayApiClient(settings);

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
    }

    private <T> void executeSynchronous(String exampleName, Supplier<Mono<T>> c) {
        System.out.println("--------------------------------");
        System.out.print("[" + exampleName + "] - ");
        try {
            var responseMono = c.get();
            var response = responseMono.block();
            System.out.println("Response received: " + response);
        } catch (Trade360Exception ex) {
            System.err.println("Failed: " + ex.getMessage());
        }
    }

    private <T> void executeAsynchronous(String exampleName, Supplier<Mono<T>> c) {
        System.out.println("--------------------------------");
        System.out.println("[" + exampleName + "] - Executing request");
        var responseMono = c.get();
        responseMono
            .subscribe(
                response -> System.out.println("[" + exampleName + "] - Got response: " + response),
                exception -> System.err.println("Failed: " + exception.getMessage()));
    }
}
