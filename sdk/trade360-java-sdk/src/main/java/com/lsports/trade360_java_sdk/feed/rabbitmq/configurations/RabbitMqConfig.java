package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

public class RabbitMqConfig {


    public final RabbitConnectionConfiguration rabbitConnectionConfiguration;

    public RabbitMqConfig(RabbitConnectionConfiguration rabbitConnectionConfiguration) {
        this.rabbitConnectionConfiguration = rabbitConnectionConfiguration;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RetryOperationsInterceptor retryInterceptor(){
        return RetryInterceptorBuilder.stateless().maxAttempts(3)
                .backOffOptions(2000, 2.0, 100000)
                .recoverer(new RejectAndDontRequeueRecoverer())
                .build();
    }
}
