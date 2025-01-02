package eu.lsports.trade360feedexample.configuration;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.DynamicRabbitMQDefinitionRegistrar;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers.AmqpMessageHandler;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegistry;
import eu.lsports.trade360feedexample.handlers.inplay.errors.InplayErrorMessageHandler;
import eu.lsports.trade360feedexample.handlers.inplay.errors.InplayRecoveryMessageResolver;
import eu.lsports.trade360feedexample.handlers.inplay.messages.*;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

// Configuration class for Rabbit Connection
@Configuration
public class InplayTrade360SdkConfiguration {
    // Configure the settings for the "Inplay" feed using the "rabbitmq.inplay" section of the configuration file
    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";

    //Register entity handlers for inPlay
    @Bean
    public EntityRegistry inPlayEentityRegister() throws RabbitMQFeedException {
        EntityRegistry entityRegistry = new EntityRegistry();
        entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new LivescoreUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new HeartbeatHandlerInplay());
        entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new KeepAliveUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new SettlementUpdateHandlerInplay());
        return entityRegistry;
    }

    // Register amqp message handler for Inplay Rabbit
    @Bean
    public AmqpMessageHandler inPlayMessageHandler() throws RabbitMQFeedException {
        AmqpMessageHandler amqpMessageHandler = new AmqpMessageHandler(inPlayEentityRegister());
        return amqpMessageHandler;
    }

    @Bean
    public MessageRecoverer inplayMessageRecoverer() {
        return new InplayRecoveryMessageResolver();
    }

    @Bean
    public InplayErrorMessageHandler inplayErrorMessageHandler() {
        return new InplayErrorMessageHandler();
    }

    @Bean
    public DynamicRabbitMQDefinitionRegistrar InPlaybeanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, RABBITMQ_INPLAY_PREFIX, inplayMessageRecoverer());
    }
}
