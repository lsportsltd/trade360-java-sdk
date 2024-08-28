package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.lsports.trade360_java_sdk.feed.rabbitmq.handlers.ErrorMessageResolver;
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
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.Environment;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import java.util.Arrays;

public class DynamicRabbitMQDefinitionRegistrar implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";
    public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";
    private final Iterable<RabbitConnectionConfiguration> connectionConfigurations;

    public DynamicRabbitMQDefinitionRegistrar(Environment environment) {

        RabbitConnectionConfiguration inPlayConnectionConfiguration =
                Binder.get(environment)
                        .bind(RABBITMQ_INPLAY_PREFIX, RabbitConnectionConfiguration.class)
                        .orElseThrow(IllegalStateException::new);

        RabbitConnectionConfiguration preMatchConnectionConfiguration =
                Binder.get(environment)
                        .bind(RABBITMQ_PREMATCH_PREFIX, RabbitConnectionConfiguration.class)
                        .orElseThrow(IllegalStateException::new);

        connectionConfigurations = Arrays.asList(inPlayConnectionConfiguration, preMatchConnectionConfiguration);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        connectionConfigurations.forEach(
                cfg -> {
                    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                    beanDefinition.setBeanClass(SimpleRabbitListenerContainerFactory.class);
                    beanDefinition.setInstanceSupplier(() -> {
                                SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

                                // Connection configuration
                                CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
                                connectionFactory.setVirtualHost(cfg.virtual_host);
                                connectionFactory.setHost(cfg.host);
                                connectionFactory.setUsername(cfg.user_name);
                                connectionFactory.setPassword(cfg.password);

                                factory.setConnectionFactory( connectionFactory);

                                // Converter configuration
                                Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

                                // message recover class
                                MessageRecoverer messageRecoverer = new ErrorMessageResolver();

                                // Message recoverer configuration
                                RetryOperationsInterceptor retryInterceptor =
                                        RetryInterceptorBuilder.stateless().maxAttempts(cfg.retry_attempts)
                                                .backOffOptions(cfg.retry_initial_interval,
                                                        cfg.retry_multiple,
                                                        cfg.retry_max_interval)
                                                .recoverer(messageRecoverer)
                                                .build();

                                // Configure Rabbit Listener Container Factory
                                factory.setAcknowledgeMode(cfg.auto_ack ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
                                factory.setAdviceChain(retryInterceptor);
                                factory.setDefaultRequeueRejected(false);
                                factory.setMessageConverter(converter);
                                factory.setConcurrentConsumers(cfg.concurrent_consumers);
                                factory.setMaxConcurrentConsumers(cfg.max_concurrent_consumers);
                                factory.setPrefetchCount(cfg.prefetch_count);
                                return factory;
                            });
                    // Register Bean for Rabbit Listener Container Factory
                    registry.registerBeanDefinition(cfg.rabbit_listener_container_factory_name, beanDefinition);
                });
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
