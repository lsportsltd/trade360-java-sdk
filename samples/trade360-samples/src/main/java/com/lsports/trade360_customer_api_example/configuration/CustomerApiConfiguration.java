package com.lsports.trade360_customer_api_example.configuration;

import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClient;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomerApiConfiguration {
    @Bean
    public static CustomersApiClient configureCustomerApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClient(webClientBuilder);
    }
}
