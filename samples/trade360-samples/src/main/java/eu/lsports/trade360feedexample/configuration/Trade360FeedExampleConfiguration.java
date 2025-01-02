package eu.lsports.trade360feedexample.configuration;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {


    // Register properties configuration for InPlay
    @Bean
    @ConfigurationProperties("rabbitmq.inplay")
    public RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }

    // Register properties configuration for Prematch
    @Bean
    @ConfigurationProperties("rabbitmq.prematch")
    public RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }
}


