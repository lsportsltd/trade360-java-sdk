package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.MessageHandler;
import com.lsports.trade360feedexample.inplay.FixtureMarketUpdateHandlerInplay;
import com.lsports.trade360feedexample.inplay.FixtureMetadataUpdateHandlerInplay;
import com.lsports.trade360feedexample.inplay.HeartbeatHandlerInplay;
import com.lsports.trade360feedexample.inplay.LivescoreUpdateHandlerInplay;
import com.lsports.trade360feedexample.prematch.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {

    @Bean
    public MessageHandler inPlayMessageHandler() {
        MessageHandler messageHandler =  new MessageHandler();
        messageHandler.RegisterEntityHandler(new FixtureMarketUpdateHandlerInplay());
        messageHandler.RegisterEntityHandler(new LivescoreUpdateHandlerInplay());
        messageHandler.RegisterEntityHandler(new HeartbeatHandlerInplay());
        messageHandler.RegisterEntityHandler(new FixtureMetadataUpdateHandlerInplay());
        return messageHandler;
    }

    @Bean
    public MessageHandler preMatchMessageHandler() {
        MessageHandler messageHandler =  new MessageHandler();
        messageHandler.RegisterEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new HeartbeatHandlerPrematch());
        messageHandler.RegisterEntityHandler(new KeepAliveUpdateHandlerPrematchPrematch());
        messageHandler.RegisterEntityHandler(new LivescoreUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        messageHandler.RegisterEntityHandler(new SettlementUpdateHandlerPrematch());

        return messageHandler;
    }
}
