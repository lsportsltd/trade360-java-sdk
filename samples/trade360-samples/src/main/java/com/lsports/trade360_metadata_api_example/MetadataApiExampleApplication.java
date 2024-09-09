package com.lsports.trade360_metadata_api_example;

import java.net.URI;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClientFactory;
import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MetadataApiExampleApplication {
    private final CustomersApiClientFactory apiClientFactory;

    public MetadataApiExampleApplication(CustomersApiClientFactory factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(MetadataApiExampleApplication.class, args);
    }

    @Bean
    public static CustomersApiClientFactory configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClientFactory(webClientBuilder);
    }

    @PostConstruct
    public void run() {
        var packageSettings = new PackageCredentials(0, "userName", "password");

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
            new GetSportsRequest(6),
            request -> client.getSports(request));
        this.executeSynchronous("Sync GetLocations without parameters",
            () -> client.getLocations());
        this.executeSynchronous("Sync GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
    }

    private void asynchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createMetadataHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== ASYNCHRONOUS METADATA API EXAMPLES: =====");
        this.executeAsynchronous("Async GetSports without parameters",
            () -> client.getSports());
        this.executeAsynchronous("Async GetSports with parameters",
            new GetSportsRequest(6),
            request -> client.getSports(request));
        this.executeAsynchronous("Sync GetLocations without parameters",
            () -> client.getLocations());
        this.executeAsynchronous("Sync GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
    }

    private <R> void executeSynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeSynchronous(exampleName, null, request -> executeFunction.get());
    }

    private <T, R> void executeSynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        System.out.println("--------------------------------");
        try {
            var jsonMapper = new ObjectMapper();
            if (request == null) {
                System.out.println("[" + exampleName + "] - Executing request");
            } else {
                System.out.println("[" + exampleName + "] - Executing request - Parameters: " + jsonMapper.writeValueAsString(request));
            }
            var responseMono = executeFunction.apply(request);
            var response = responseMono.block();
            System.out.println("Response received: " + jsonMapper.writeValueAsString(response));
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
        var jsonMapper = new ObjectMapper();
        System.out.println("--------------------------------");
        if (request == null) {
            System.out.println("[" + exampleName + "] - Executing request");
        } else {
            try {
                System.out.println("[" + exampleName + "] - Executing request - Parameters: " + jsonMapper.writeValueAsString(request));
            } catch (JsonProcessingException ex) {
                System.err.println("Unhandled exception: " + ex.getMessage());
            }
        }
        var responseMono = executeFunction.apply(request);
        responseMono
            .subscribe(
                response -> {
                    try {
                        System.out.println("[" + exampleName + "] - Got response: " + jsonMapper.writeValueAsString(response));
                    } catch (JsonProcessingException ex) {
                        System.err.println("Unhandled exception: " + ex.getMessage());
                    }
                },
                exception -> System.err.println("Failed: " + exception.getMessage()));
    }
}
