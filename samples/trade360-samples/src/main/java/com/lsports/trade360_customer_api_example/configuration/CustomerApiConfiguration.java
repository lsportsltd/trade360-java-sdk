package com.lsports.trade360_customer_api_example.configuration;

import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomerApiConfiguration {
    @Bean
    public static CustomersApiClientFactory configureCustomerApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClientFactory(webClientBuilder);
    }
}
