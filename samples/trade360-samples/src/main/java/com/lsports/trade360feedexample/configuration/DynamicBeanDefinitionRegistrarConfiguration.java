package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.DynamicRabbitMQDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import java.util.Arrays;

// Configuration class for dynamic register Rabbit Connection based on application properties
@Configuration
public class DynamicBeanDefinitionRegistrarConfiguration {
    // Configure the settings for the "Inplay" feed using the "rabbitmq.inplay" section of the configuration file
    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";
    // Configure the settings for the "Prematch" feed using the "rabbitmq.prematch" section of the configuration file
    public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";

    @Bean
    public static DynamicRabbitMQDefinitionRegistrar beanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, Arrays.asList(RABBITMQ_INPLAY_PREFIX,RABBITMQ_PREMATCH_PREFIX));
    }
}
