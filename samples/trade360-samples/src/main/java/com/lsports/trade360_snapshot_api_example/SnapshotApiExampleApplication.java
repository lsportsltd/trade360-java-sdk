package com.lsports.trade360_snapshot_api_example;

import java.net.URI;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.springframework.SpringBootSnapshotApiClientFactory;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SnapshotApiExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnapshotApiExampleApplication.class, args);
    }

    @Bean
    public static SnapshotApiClientFactory configureSnapshotApiFactory(RestClient.Builder restBuilder) {
        return new SpringBootSnapshotApiClientFactory(restBuilder);
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
        var preMatchSettings = new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 4, "1", "Tests1234");
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
        this.execute("Get Outrights Events",
            () -> preMatchClient.getOutrightEvents(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
        this.execute("Get Outrights Fixture",
            () -> preMatchClient.getOutrightFixture(new GetSnapshotRequest(null, null, null, null, null, null, null, null, null)));
    }

    private void inPlayApi() {
        var inPlaySettings = new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 0, "xyz", "abc");
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

    private <T> void execute(String exampleName, Supplier<T> c) {
        System.out.println("--------------------------------");
        System.out.print("[" + exampleName + "] - ");
        try {
            var response = c.get();
            System.out.println("Response received: " + response);
        } catch (Trade360Exception ex) {
            System.err.println("Failed: " + ex.getMessage());
        }
    }
}
