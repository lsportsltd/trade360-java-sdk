package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegistry;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.MessageHandlerImplementation;
import com.lsports.trade360feedexample.handlers.inplay.FixtureMarketUpdateHandlerInplay;
import com.lsports.trade360feedexample.handlers.inplay.FixtureMetadataUpdateHandlerInplay;
import com.lsports.trade360feedexample.handlers.inplay.HeartbeatHandlerInplay;
import com.lsports.trade360feedexample.handlers.inplay.LivescoreUpdateHandlerInplay;
import com.lsports.trade360feedexample.handlers.prematch.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {

    @Bean
    public EntityRegistry inPlayEentityRegister() throws RabbitMQFeedException {
        EntityRegistry entityRegistry = new EntityRegistry();
        entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new LivescoreUpdateHandlerInplay());
        entityRegistry.setEntityHandler(new HeartbeatHandlerInplay());
        entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        return entityRegistry;
    }

    @Bean
    public EntityRegistry preMachEentityRegister() throws RabbitMQFeedException {
        EntityRegistry entityRegistry = new EntityRegistry();
        entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new HeartbeatHandlerPrematch());
        entityRegistry.setEntityHandler(new KeepAliveUpdateHandlerPrematchPrematch());
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

    @Bean
    public MessageHandlerImplementation inPlayMessageHandler() throws RabbitMQFeedException {
        MessageHandlerImplementation messageHandlerImplementation = new MessageHandlerImplementation(inPlayEentityRegister());
        return messageHandlerImplementation;
    }

    @Bean
    public MessageHandlerImplementation preMatchMessageHandler() throws RabbitMQFeedException {
        MessageHandlerImplementation messageHandlerImplementation = new MessageHandlerImplementation(preMachEentityRegister());
        return messageHandlerImplementation;
    }

    @Bean
    @ConfigurationProperties("rabbitmq.inplay")
    public RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }

    @Bean
    @ConfigurationProperties("rabbitmq.prematch")
    public RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration() {
        return new RabbitConnectionConfiguration();
    }
}


