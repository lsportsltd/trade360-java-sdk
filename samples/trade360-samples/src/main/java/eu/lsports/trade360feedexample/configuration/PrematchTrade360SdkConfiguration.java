package eu.lsports.trade360feedexample.configuration;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.DynamicRabbitMQDefinitionRegistrar;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers.AmqpMessageHandler;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegistry;
import eu.lsports.trade360feedexample.handlers.prematch.errors.PrematchErrorMessageHandler;
import eu.lsports.trade360feedexample.handlers.prematch.errors.PrematchRecoveryMessageResolver;
import eu.lsports.trade360feedexample.handlers.prematch.messages.*;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

// Configuration class Rabbit Connection
@Configuration
public class PrematchTrade360SdkConfiguration {
    // Configure the settings for the "Prematch" feed using the "rabbitmq.prematch" section of the configuration file
    public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";

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

    // Register amqp message handler for Prematch Rabbit
    @Bean
    public AmqpMessageHandler preMatchMessageHandler() throws RabbitMQFeedException {
        AmqpMessageHandler amqpMessageHandler = new AmqpMessageHandler(preMachEentityRegister());
        return amqpMessageHandler;
    }

    @Bean
    public MessageRecoverer prematchMessageRecoverer() {
        return new PrematchRecoveryMessageResolver();
    }

    @Bean
    public PrematchErrorMessageHandler prematchErrorMessageHandler() {
        return new PrematchErrorMessageHandler();
    }

    @Bean
    public DynamicRabbitMQDefinitionRegistrar preMatchbeanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, RABBITMQ_PREMATCH_PREFIX, prematchMessageRecoverer());
    }
}
