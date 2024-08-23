package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.MsgHandler;
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
    public MsgHandler inPlayMessageHandler() throws RabbitMQFeedException {
        MsgHandler msgHandler = new MsgHandler();
        msgHandler.registerEntityHandler(new FixtureMarketUpdateHandlerInplay());
        msgHandler.registerEntityHandler(new LivescoreUpdateHandlerInplay());
        msgHandler.registerEntityHandler(new HeartbeatHandlerInplay());
        msgHandler.registerEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        return msgHandler;
    }

    @Bean
    public MsgHandler preMatchMessageHandler() throws RabbitMQFeedException {
        MsgHandler msgHandler = new MsgHandler();
        msgHandler.registerEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new HeartbeatHandlerPrematch());
        msgHandler.registerEntityHandler(new KeepAliveUpdateHandlerPrematchPrematch());
        msgHandler.registerEntityHandler(new LivescoreUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        msgHandler.registerEntityHandler(new SettlementUpdateHandlerPrematch());

        return msgHandler;
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
