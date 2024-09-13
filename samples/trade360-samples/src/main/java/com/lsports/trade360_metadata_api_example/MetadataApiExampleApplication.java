package com.lsports.trade360_metadata_api_example;

import java.net.URI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import com.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetCompetitionsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetMarketsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesMetadataRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetTranslationsRequest;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClientFactory;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MetadataApiExampleApplication {
    private final CustomersApiClientFactory apiClientFactory;
    private JsonApiSerializer jsonApiSerializer;

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
        this.jsonApiSerializer = new JacksonApiSerializer(null);

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
        this.executeSynchronous("Sync GetLeagues with parameters",
            new GetLeaguesRequest(List.of(6046, 48242), List.of(22, 161), SubscriptionState.ALL, 6),
            request -> client.getLeagues(request));
        this.executeSynchronous("Sync GetMarkets with parameters",
            new GetMarketsRequest(List.of(6046, 48242), List.of(22, 161), null, null, false, MarketType.STANDARD, null),
            request -> client.getMarkets(request));
        this.executeSynchronous("Sync GetTranslations with parameters",
            new GetTranslationsRequest(List.of(6, 38), List.of(6046, 48242), List.of(22, 161), null, null, null),
            request -> client.getTranslations(request));
        this.executeSynchronous("Sync GetCompetitions with parameters",
            new GetCompetitionsRequest(List.of(), List.of(22, 161), null, SubscriptionState.ALL),
            request -> client.getCompetitions(request));
        this.executeSynchronous("Sync GetSubscribedFixtures with parameters",
            new GetSubscribedFixturesRequest(List.of(6046, 48242), List.of(22, 161), null),
            request -> client.getSubscribedFixtures(request));
        this.executeSynchronous("Sync GetSubscribedFixturesMetadata with parameters",
            new GetSubscribedFixturesMetadataRequest(LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))),
            request -> client.getSubscribedFixturesMetadata(request));
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
        this.executeAsynchronous("Async GetLocations without parameters",
            () -> client.getLocations());
        this.executeAsynchronous("Async GetLocations with parameters",
            new GetLocationsRequest(6),
            request -> client.getLocations(request));
        this.executeAsynchronous("Async GetLeagues with parameters",
            new GetLeaguesRequest(List.of(6046, 48242), List.of(22, 161), SubscriptionState.ALL, 6),
            request -> client.getLeagues(request));
        this.executeAsynchronous("Async GetMarkets with parameters",
            new GetMarketsRequest(List.of(6046, 48242), List.of(22, 161), null, null, false, MarketType.STANDARD, null),
            request -> client.getMarkets(request));
        this.executeAsynchronous("Async GetTranslations with parameters",
            new GetTranslationsRequest(List.of(6, 38), List.of(6046, 48242), List.of(22, 161), null, null, null),
            request -> client.getTranslations(request));
        this.executeAsynchronous("Async GetCompetitions with parameters",
            new GetCompetitionsRequest(List.of(), List.of(22, 161), null, SubscriptionState.ALL),
            request -> client.getCompetitions(request));
        this.executeAsynchronous("Async GetSubscribedFixtures with parameters",
            new GetSubscribedFixturesRequest(List.of(6046, 48242), List.of(22, 161), null),
            request -> client.getSubscribedFixtures(request));
        this.executeAsynchronous("Async GetSubscribedFixturesMetadata with parameters",
            new GetSubscribedFixturesMetadataRequest(LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))),
            request -> client.getSubscribedFixturesMetadata(request));
    }

    private <R> void executeSynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeSynchronous(exampleName, null, request -> executeFunction.get());
    }

    private <T, R> void executeSynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        System.out.println("--------------------------------");
        try {
            if (request == null) {
                System.out.println("[" + exampleName + "] - Executing request");
            } else {
                System.out.println("[" + exampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serialize(request));
            }
            var responseMono = executeFunction.apply(request);
            var response = responseMono.block();
            System.out.println("Response received: " + this.jsonApiSerializer.serialize(response));
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
        System.out.println("--------------------------------");
        if (request == null) {
            System.out.println("[" + exampleName + "] - Executing request");
        } else {
            System.out.println("[" + exampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serialize(request));
        }
        var responseMono = executeFunction.apply(request);
        responseMono
            .subscribe(
                response -> {
                    System.out.println("--------------------------------");
                    System.out.println("[" + exampleName + "] - Got response: " + this.jsonApiSerializer.serialize(response));
                },
                exception -> System.err.println("Failed: " + exception.getMessage()));
    }
}
