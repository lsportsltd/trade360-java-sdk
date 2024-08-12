package com.lsports.trade360feedexample.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "rabbit")
    public RabbitConfiguration item() {
        return new RabbitConfiguration();
    }
}
