package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

// Configuration class for dynamic register Rabbit Connection based on application properties
public class DynamicRabbitMQDefinitionRegistrar implements BeanDefinitionRegistryPostProcessor {

    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    private final MessageRecoverer messageRecoverer;

    public DynamicRabbitMQDefinitionRegistrar(Environment environment, String rabbitPrefix, MessageRecoverer messageRecoverer) {

                this. messageRecoverer = messageRecoverer;
                rabbitConnectionConfiguration = Binder.get(environment)
                            .bind(rabbitPrefix, RabbitConnectionConfiguration.class)
                            .orElseThrow(IllegalStateException::new);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

                    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                    beanDefinition.setBeanClass(SimpleRabbitListenerContainerFactory.class);
                    beanDefinition.setInstanceSupplier(() -> {
                                SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

                                // Connection configuration
                                CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
                                connectionFactory.setVirtualHost(rabbitConnectionConfiguration.virtual_host);
                                connectionFactory.setHost(rabbitConnectionConfiguration.host);
                                connectionFactory.setUsername(rabbitConnectionConfiguration.user_name);
                                connectionFactory.setPassword(rabbitConnectionConfiguration.password);

                                factory.setConnectionFactory( connectionFactory);

                                // Converter configuration
                                Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

                                // Message recoverer configuration
                                RetryOperationsInterceptor retryInterceptor =
                                        RetryInterceptorBuilder.stateless().maxAttempts(rabbitConnectionConfiguration.retry_attempts)
                                                .backOffOptions(rabbitConnectionConfiguration.retry_initial_interval,
                                                        rabbitConnectionConfiguration.retry_multiple,
                                                        rabbitConnectionConfiguration.retry_max_interval)
                                                .recoverer(messageRecoverer)
                                                .build();

                                // Configure Rabbit Listener Container Factory
                                factory.setAcknowledgeMode(rabbitConnectionConfiguration.auto_ack ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
                                factory.setAdviceChain(retryInterceptor);
                                factory.setDefaultRequeueRejected(false);
                                factory.setMessageConverter(converter);
                                factory.setConcurrentConsumers(rabbitConnectionConfiguration.concurrent_consumers);
                                factory.setMaxConcurrentConsumers(rabbitConnectionConfiguration.max_concurrent_consumers);
                                factory.setPrefetchCount(rabbitConnectionConfiguration.prefetch_count);
                                factory.setRecoveryInterval(rabbitConnectionConfiguration.network_recovery_interval);
                                factory.setMissingQueuesFatal(false);
                                return factory;
                            });

                    // Register Bean for Rabbit Listener Container Factory - Bean name taken from application properties
                    registry.registerBeanDefinition(rabbitConnectionConfiguration.rabbit_listener_container_factory_name, beanDefinition);
    }
}
