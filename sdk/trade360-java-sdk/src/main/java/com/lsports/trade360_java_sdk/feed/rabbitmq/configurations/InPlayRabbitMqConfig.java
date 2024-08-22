package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableRabbit
public class InPlayRabbitMqConfig extends RabbitMqConfig {
    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    public final String name;

    public InPlayRabbitMqConfig(@Qualifier("inPlayRabbitConnectionConfiguration") RabbitConnectionConfiguration rabbitConnectionConfiguration) {
        super(rabbitConnectionConfiguration);
        this.rabbitConnectionConfiguration = rabbitConnectionConfiguration;
        this.name = rabbitConnectionConfiguration.name;
    }

    @Bean
    @Primary
    public CachingConnectionFactory inPlayConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(rabbitConnectionConfiguration.virtual_host);
        connectionFactory.setHost(rabbitConnectionConfiguration.host);
        connectionFactory.setUsername(rabbitConnectionConfiguration.user_name);
        connectionFactory.setPassword(rabbitConnectionConfiguration.password);
        return connectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory inPlayRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer rabbitListenerFactoryConfig) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        rabbitListenerFactoryConfig.configure(factory, inPlayConnectionFactory());
        factory.setAcknowledgeMode(rabbitConnectionConfiguration.auto_ack ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
        factory.setAdviceChain(retryInterceptor());
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(converter());
        return factory;
    }
}

