package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.MarketUpdate;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import org.springframework.amqp.core.AcknowledgeMode;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {

    private final CachingConnectionFactory connectionFactory;

    public RabbitMqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.connectionFactory = cachingConnectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter converterWithMapper() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
        jsonConverter.setClassMapper(classMapper());
        jsonConverter.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        return jsonConverter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("MarketUpdate", MarketUpdate.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converterWithMapper());
        return rabbitTemplate;
    }

    @Bean
    public RetryOperationsInterceptor retryInterceptor(){
        return RetryInterceptorBuilder.stateless().maxAttempts(3)
                .backOffOptions(2000, 2.0, 100000)
                .recoverer(new RejectAndDontRequeueRecoverer())
                .build();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setAdviceChain(retryInterceptor());
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(converterWithMapper());
        return factory;
    }
}
