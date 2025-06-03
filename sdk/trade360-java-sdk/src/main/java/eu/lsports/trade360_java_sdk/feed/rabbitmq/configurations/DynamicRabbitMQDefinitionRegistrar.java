package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

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

/**
 * Configuration class for dynamically registering RabbitMQ connections based on application properties.
 */
public class DynamicRabbitMQDefinitionRegistrar implements BeanDefinitionRegistryPostProcessor {

    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    private final MessageRecoverer messageRecoverer;

    /**
     * Constructs a new registrar with the given environment, prefix, and message recoverer.
     *
     * @param environment The environment to bind properties from
     * @param rabbitPrefix The prefix for RabbitMQ properties
     * @param messageRecoverer The message recoverer
     */
    public DynamicRabbitMQDefinitionRegistrar(Environment environment, String rabbitPrefix, MessageRecoverer messageRecoverer) {
        this.messageRecoverer = messageRecoverer;
        rabbitConnectionConfiguration = Binder.get(environment)
                .bind(rabbitPrefix, RabbitConnectionConfiguration.class)
                .orElseThrow(IllegalStateException::new);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SimpleRabbitListenerContainerFactory.class);
        beanDefinition.setInstanceSupplier(() -> {
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

            // Connection configuration
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
            connectionFactory.setVirtualHost(rabbitConnectionConfiguration.getVirtualHost());
            connectionFactory.setHost(rabbitConnectionConfiguration.getHost());
            connectionFactory.setUsername(rabbitConnectionConfiguration.getUserName());
            connectionFactory.setPassword(rabbitConnectionConfiguration.getPassword());
            connectionFactory.setRequestedHeartBeat(rabbitConnectionConfiguration.getRequestedHeartBeat());

            factory.setConnectionFactory(connectionFactory);

            // Converter configuration
            Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

            // Message recoverer configuration
            RetryOperationsInterceptor retryInterceptor =
                    RetryInterceptorBuilder.stateless().maxAttempts(rabbitConnectionConfiguration.getRetryAttempts())
                            .backOffOptions(rabbitConnectionConfiguration.getRetryInitialInterval(),
                                    rabbitConnectionConfiguration.getRetryMultiple(),
                                    rabbitConnectionConfiguration.getRetryMaxInterval())
                            .recoverer(messageRecoverer)
                            .build();

            // Configure Rabbit Listener Container Factory
            factory.setAcknowledgeMode(rabbitConnectionConfiguration.isAutoAck() ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
            factory.setAdviceChain(retryInterceptor);
            factory.setDefaultRequeueRejected(false);
            factory.setMessageConverter(converter);
            factory.setConcurrentConsumers(rabbitConnectionConfiguration.getConcurrentConsumers());
            factory.setMaxConcurrentConsumers(rabbitConnectionConfiguration.getMaxConcurrentConsumers());
            factory.setPrefetchCount(rabbitConnectionConfiguration.getPrefetchCount());
            factory.setRecoveryInterval(rabbitConnectionConfiguration.getNetworkRecoveryInterval());
            factory.setMissingQueuesFatal(false);
            return factory;
        });

        // Register Bean for Rabbit Listener Container Factory - Bean name taken from application properties
        registry.registerBeanDefinition(rabbitConnectionConfiguration.getRabbitListenerContainerFactoryName(), beanDefinition);
    }
}