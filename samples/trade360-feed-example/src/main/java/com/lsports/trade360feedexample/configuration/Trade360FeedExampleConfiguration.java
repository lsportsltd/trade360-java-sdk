package com.lsports.trade360feedexample.configuration;

import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.BodyHandler;
import com.lsports.trade360feedexample.inplay.FixtureMarketUpdateHandlerInplay;
import com.lsports.trade360feedexample.inplay.LivescoreUpdateHandlerInplay;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trade360FeedExampleConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "rabbit")
    public RabbitConfiguration rabbitConfiguration() {
        return new RabbitConfiguration();
    }

    @Bean
    public BodyHandler bodyHandler() {
        BodyHandler bodyHandler =  new BodyHandler();
        bodyHandler.RegisterEntityHandler(new FixtureMarketUpdateHandlerInplay());
        bodyHandler.RegisterEntityHandler(new LivescoreUpdateHandlerInplay());
        return bodyHandler;
    }

}
