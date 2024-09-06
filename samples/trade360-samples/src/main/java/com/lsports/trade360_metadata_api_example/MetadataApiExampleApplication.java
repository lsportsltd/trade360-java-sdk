package com.lsports.trade360_metadata_api_example;

import java.net.URI;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClientFactory;
import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MetadataApiExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetadataApiExampleApplication.class, args);
    }

    @Bean
    public static CustomersApiClientFactory configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClientFactory(webClientBuilder);
    }

    private final CustomersApiClientFactory apiClientFactory;

    public MetadataApiExampleApplication(CustomersApiClientFactory factory) {
        apiClientFactory = factory;
    }

    @PostConstruct
    public void run() {
        var packageSettings = new PackageCredentials(0, "userName", "passworc");

        this.synchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
        this.asynchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
    }

    private void synchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS METADATA API EXAMPLES: ====");

        this.executeSynchronous("Sync GetSports without parameters",
            () -> client.getSports());
        this.executeSynchronous("Sync GetSports with parameters",
            () -> client.getSports(new GetSportsRequest(6)));
    }

    private void asynchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== ASYNCHRONOUS METADATA API EXAMPLES: =====");
        this.executeAsynchronous("Async GetSports without parameters",
            () -> client.getSports());
        this.executeAsynchronous("Async GetSports with parameters",
            () -> client.getSports(new GetSportsRequest(6)));
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
