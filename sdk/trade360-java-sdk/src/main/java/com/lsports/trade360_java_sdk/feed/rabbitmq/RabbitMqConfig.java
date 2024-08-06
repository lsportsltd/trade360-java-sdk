package com.lsports.trade360_java_sdk.feed.rabbitmq;

import com.lsports.trade360_java_sdk.common.models.TestClass;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {

//    public static final String QUEUE_NAME = "_99_";
//    public static final String EXCHANGE_NAME = "Push";

    private final CachingConnectionFactory connectionFactory;

    public RabbitMqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.connectionFactory = cachingConnectionFactory;
    }

//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, true);
//    }
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(EXCHANGE_NAME, true, false);
//    }
//
//    @Bean
//    Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).withQueueName();
//    }


    @Bean
    public Jackson2JsonMessageConverter converterWithMapper() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    @Bean
    public Jackson2JsonMessageConverter convertert() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
       idClassMapping.put("TestClass", TestClass.class);
    //    idClassMapping.put("thing2", Thing2.class);
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
        return factory;
    }

}
