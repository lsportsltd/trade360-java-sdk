package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.MessageHandler;
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
    public MessageHandler inPlayMessageHandler() {
        MessageHandler messageHandler =  new MessageHandler();
        messageHandler.registerEntityHandler(new FixtureMarketUpdateHandlerInplay());
        messageHandler.registerEntityHandler(new LivescoreUpdateHandlerInplay());
        messageHandler.registerEntityHandler(new HeartbeatHandlerInplay());
        messageHandler.registerEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        return messageHandler;
    }

    @Bean
    public MessageHandler preMatchMessageHandler() {
        MessageHandler messageHandler =  new MessageHandler();
        messageHandler.registerEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new HeartbeatHandlerPrematch());
        messageHandler.registerEntityHandler(new KeepAliveUpdateHandlerPrematchPrematch());
        messageHandler.registerEntityHandler(new LivescoreUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        messageHandler.registerEntityHandler(new SettlementUpdateHandlerPrematch());

        return messageHandler;
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
