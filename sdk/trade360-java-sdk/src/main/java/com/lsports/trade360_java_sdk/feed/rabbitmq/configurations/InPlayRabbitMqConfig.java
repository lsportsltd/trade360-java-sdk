package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.ErrorMessageResolver;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

@Configuration
@EnableRabbit
public class InPlayRabbitMqConfig  {
    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    public final String name;

    public InPlayRabbitMqConfig(@Qualifier("inPlayRabbitConnectionConfiguration") RabbitConnectionConfiguration rabbitConnectionConfiguration) {
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
    public RetryOperationsInterceptor inPlayRetryInterceptor(){
        return RetryInterceptorBuilder.stateless().maxAttempts(rabbitConnectionConfiguration.retry_attempts)
                .backOffOptions(rabbitConnectionConfiguration.retry_initial_interval,
                        rabbitConnectionConfiguration.retry_multiple,
                        rabbitConnectionConfiguration.retry_max_interval)
                .recoverer(messageRecoverer())
                .build();
    }

    @Bean
    public MessageRecoverer messageRecoverer(){
        return new ErrorMessageResolver();
    }

    @Bean
    public Jackson2JsonMessageConverter inPlayConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory inPlayRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer rabbitListenerFactoryConfig) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        rabbitListenerFactoryConfig.configure(factory, inPlayConnectionFactory());
        factory.setAcknowledgeMode(rabbitConnectionConfiguration.auto_ack ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
        factory.setAdviceChain(inPlayRetryInterceptor());
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(inPlayConverter());
        factory.setConcurrentConsumers(rabbitConnectionConfiguration.concurrent_consumers);
        factory.setMaxConcurrentConsumers(rabbitConnectionConfiguration.max_concurrent_consumers);
        factory.setPrefetchCount(rabbitConnectionConfiguration.prefetch_count);
        return factory;
    }
}

