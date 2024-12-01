package com.lsports.trade360_customer_api_example.configuration;

import com.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import com.lsports.trade360_java_sdk.customers_api.springframework.SpringBootCustomersApiClientFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "customersapi")
@EnableConfigurationProperties({CustomersApiInPlayConfiguration.class, CustomersApiPreMatchConfiguration.class})
public class CustomerApiConfiguration {
    public String base_customers_api;

    public CustomersApiInPlayConfiguration inplay;

    public CustomersApiPreMatchConfiguration prematch;
    @Bean
    public static CustomersApiClientFactory configureCustomerApiClientFactory(WebClient.Builder webClientBuilder) {
        return new SpringBootCustomersApiClientFactory(webClientBuilder);
    }
}
