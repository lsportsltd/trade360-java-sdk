package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.DynamicRabbitMQDefinitionRegistrar;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.AmqpMessageHandler;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegistry;
import com.lsports.trade360feedexample.handlers.inplay.errors.InplayErrorMessageHandler;
import com.lsports.trade360feedexample.handlers.inplay.errors.InplayRecoveryMessageResolver;
import com.lsports.trade360feedexample.handlers.inplay.messages.*;
import com.lsports.trade360feedexample.handlers.prematch.errors.PrematchErrorMessageHandler;
import com.lsports.trade360feedexample.handlers.prematch.errors.PrematchRecoveryMessageResolver;
import com.lsports.trade360feedexample.handlers.prematch.messages.*;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

// Configuration class for dynamic register Rabbit Connection based on application properties
@Configuration
public class Trade360SdkConfiguration {
    // Configure the settings for the "Inplay" feed using the "rabbitmq.inplay" section of the configuration file
    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";
    // Configure the settings for the "Prematch" feed using the "rabbitmq.prematch" section of the configuration file
    public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";

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

    //Register entity handlers for preMatch
    @Bean
    public EntityRegistry preMachEentityRegister() throws RabbitMQFeedException {
        EntityRegistry entityRegistry = new EntityRegistry();
        entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new HeartbeatHandlerPrematch());
        entityRegistry.setEntityHandler(new KeepAliveUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new LivescoreUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new SettlementUpdateHandlerPrematch());
        return entityRegistry;
    }

    // Register amqp message handler for Inplay Rabbit
    @Bean
    public AmqpMessageHandler inPlayMessageHandler() throws RabbitMQFeedException {
        AmqpMessageHandler amqpMessageHandler = new AmqpMessageHandler(inPlayEentityRegister());
        return amqpMessageHandler;
    }

    // Register amqp message handler for Prematch Rabbit
    @Bean
    public AmqpMessageHandler preMatchMessageHandler() throws RabbitMQFeedException {
        AmqpMessageHandler amqpMessageHandler = new AmqpMessageHandler(preMachEentityRegister());
        return amqpMessageHandler;
    }

    @Bean
    public MessageRecoverer inplayMessageRecoverer() {
        return new InplayRecoveryMessageResolver();
    }

    @Bean
    public MessageRecoverer prematchMessageRecoverer() {
        return new PrematchRecoveryMessageResolver();
    }

    @Bean
    public InplayErrorMessageHandler inplayErrorMessageHandler() {
        return new InplayErrorMessageHandler();
    }

    @Bean
    public PrematchErrorMessageHandler prematchErrorMessageHandler() {
        return new PrematchErrorMessageHandler();
    }

    @Bean
    public DynamicRabbitMQDefinitionRegistrar InPlaybeanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, RABBITMQ_INPLAY_PREFIX, inplayMessageRecoverer());
    }

    @Bean
    public DynamicRabbitMQDefinitionRegistrar preMatchbeanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, RABBITMQ_PREMATCH_PREFIX, prematchMessageRecoverer());
    }
}
