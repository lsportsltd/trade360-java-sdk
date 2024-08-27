package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.EntityRegisterImplementation;
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
    public EntityRegisterImplementation inPlayEentityRegister() throws RabbitMQFeedException {
        EntityRegisterImplementation entityRegisterImplementation = new EntityRegisterImplementation();
        entityRegisterImplementation.registerEntityHandler(new FixtureMarketUpdateHandlerInplay());
        entityRegisterImplementation.registerEntityHandler(new LivescoreUpdateHandlerInplay());
        entityRegisterImplementation.registerEntityHandler(new HeartbeatHandlerInplay());
        entityRegisterImplementation.registerEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        return entityRegisterImplementation;
    }

    @Bean
    public EntityRegisterImplementation preMachEentityRegister() throws RabbitMQFeedException {
        EntityRegisterImplementation entityRegisterImplementation = new EntityRegisterImplementation();
        entityRegisterImplementation.registerEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new HeartbeatHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new KeepAliveUpdateHandlerPrematchPrematch());
        entityRegisterImplementation.registerEntityHandler(new LivescoreUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        entityRegisterImplementation.registerEntityHandler(new SettlementUpdateHandlerPrematch());
        return entityRegisterImplementation;
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


