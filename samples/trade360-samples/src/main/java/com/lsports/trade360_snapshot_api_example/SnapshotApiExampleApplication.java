package com.lsports.trade360_snapshot_api_example;

import java.net.URI;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.ApiSettings;
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
    public SnapshotApiClientFactory configureSnapshotApiFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootSnapshotApiClientFactory(webClientBuilder);
    }

    private final SnapshotApiClientFactory apiClientFactory;

    public SnapshotApiExampleApplication(SnapshotApiClientFactory factory) {
        apiClientFactory = factory;
    }

    @PostConstruct
    public void run() {
        this.preMatchApi();
        this.inPlayApi();
    }

    private void preMatchApi() {
        var preMatchSettings = new ApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 0, "xyz", "abc");
        var preMatchClient = this.apiClientFactory.createPreMatchApiClient(preMatchSettings);

        System.out.println();
        System.out.println("================================");
        System.out.println("==== PREMATCH API EXAMPLES: ====");

        this.execute("Get Fixtures",
            () -> preMatchClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Livescore",
            () -> preMatchClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Fixture Markets",
            () -> preMatchClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Events",
            () -> preMatchClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright Events",
            () -> preMatchClient.getOutrightEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright Fixture",
            () -> preMatchClient.getOutrightFixture(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright Scores",
            () -> preMatchClient.getOutrightScores(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright Fixture Markets",
            () -> preMatchClient.getOutrightFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright Leagues",
            () -> preMatchClient.getOutrightLeagues(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outright League Markets",
            () -> preMatchClient.getOutrightLeagueMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
    }

    private void inPlayApi() {
        var inPlaySettings = new ApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 0, "xyz", "abc");
        var inPlayClient = this.apiClientFactory.createInPlayApiClient(inPlaySettings);

        System.out.println();
        System.out.println("================================");
        System.out.println("===== INPLAY API EXAMPLES: =====");
        this.execute("Get Fixtures",
            () -> inPlayClient.getFixtures(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Livescore",
            () -> inPlayClient.getLivescore(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Fixture Markets",
            () -> inPlayClient.getFixtureMarkets(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Events",
            () -> inPlayClient.getEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
    }

    private <T> void execute(String exampleName, Supplier<Mono<T>> c) {
        System.out.println("--------------------------------");
        System.out.print("[" + exampleName + "] - ");
        try {
            var response = c.get().block();
            System.out.println("Response received: " + response);
        } catch (Trade360Exception ex) {
            System.err.println("Failed: " + ex.getMessage());
        }
    }
}
