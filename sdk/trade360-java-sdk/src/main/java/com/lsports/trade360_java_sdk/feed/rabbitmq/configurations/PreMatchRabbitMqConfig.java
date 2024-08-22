package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class PreMatchRabbitMqConfig extends RabbitMqConfig{
    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    public final String name;

    public PreMatchRabbitMqConfig(@Qualifier("preMatchRabbitConnectionConfiguration") RabbitConnectionConfiguration rabbitConnectionConfiguration) {
        super(rabbitConnectionConfiguration);
        this.rabbitConnectionConfiguration = rabbitConnectionConfiguration;
        this.name = rabbitConnectionConfiguration.name;
    }

    @Bean
    public CachingConnectionFactory preMatchConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(rabbitConnectionConfiguration.virtual_host);
        connectionFactory.setHost(rabbitConnectionConfiguration.host);
        connectionFactory.setUsername(rabbitConnectionConfiguration.user_name);
        connectionFactory.setPassword(rabbitConnectionConfiguration.password);
        return connectionFactory;
    }

/*    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RetryOperationsInterceptor retryInterceptor() {
        return RetryInterceptorBuilder.stateless().maxAttempts(3)
                .backOffOptions(2000, 2.0, 100000)
                .recoverer(new RejectAndDontRequeueRecoverer())
                .build();
    }*/

    @Bean
    public SimpleRabbitListenerContainerFactory preMatchRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer rabbitListenerFactoryConfig) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        rabbitListenerFactoryConfig.configure(factory, preMatchConnectionFactory());
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setAdviceChain(retryInterceptor());
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(converter());
        return factory;
    }
}
