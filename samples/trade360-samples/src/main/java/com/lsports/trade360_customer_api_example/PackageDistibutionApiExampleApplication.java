package com.lsports.trade360_customer_api_example;

import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class PackageDistibutionApiExampleApplication {
    private final CustomersApiClientFactory apiClientFactory;
    private JsonApiSerializer jsonApiSerializer;

    public PackageDistibutionApiExampleApplication(CustomersApiClientFactory factory) {
        apiClientFactory = factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(PackageDistibutionApiExampleApplication.class, args);
    }

    @PostConstruct
    public void run() {
        var packageSettings = new PackageCredentials(0, "UserName", "Password");
        this.jsonApiSerializer = new JacksonApiSerializer(packageSettings);

        this.synchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
    //    this.asynchronousExample(URI.create("https://stm-api.lsports.eu"), packageSettings);
    }

    private void synchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("============================================");
        System.out.println("==== SYNCHRONOUS PACKAGE DISTRIBUTION API EXAMPLES: ====");

        this.executeSynchronous("Sync getDistributionStatusAsync without parameters",
                () -> client.getDistributionStatusAsync());
        this.executeSynchronous("Sync startDistribution without parameters",
                () -> client.startDistribution());
        this.executeSynchronous("Sync stopDistribution without parameters",
                () -> client.stopDistribution());
    }

    private void asynchronousExample(URI baseUri, PackageCredentials credentials) {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, credentials);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("===== PACKAGE DISTRIBUTION API EXAMPLES: =====");

        this.executeAsynchronous("Sync getDistributionStatusAsync without parameters",
                () -> client.getDistributionStatusAsync());
        this.executeAsynchronous("Sync startDistribution without parameters",
                () -> client.startDistribution());
        this.executeAsynchronous("Sync stopDistribution without parameters",
                () -> client.stopDistribution());
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
