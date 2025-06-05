package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DynamicRabbitMQDefinitionRegistrarTest {
    private Environment environment;
    private MessageRecoverer messageRecoverer;
    private RabbitConnectionConfiguration rabbitConfig;

    @BeforeEach
    void setUp() {
        environment = mock(Environment.class);
        messageRecoverer = mock(MessageRecoverer.class);
    }

    @Test
    void testConstructorAndBeanRegistration() {
        // Use a real config with required fields
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        config.setVirtualHost("/");
        config.setHost("localhost");
        config.setUserName("guest");
        config.setPassword("guest");
        config.setRequestedHeartBeat(30);
        config.setRetryAttempts(3);
        config.setRetryInitialInterval(1000);
        config.setRetryMultiple(2.0);
        config.setRetryMaxInterval(5000);
        config.setAutoAck(true);
        config.setConcurrentConsumers(1);
        config.setMaxConcurrentConsumers(5);
        config.setPrefetchCount(10);
        config.setNetworkRecoveryInterval(3000);
        config.setRabbitListenerContainerFactoryName("testFactory");

        // Mock Binder to return our config via BindResult
        org.springframework.boot.context.properties.bind.Binder binder = mock(org.springframework.boot.context.properties.bind.Binder.class);
        org.springframework.boot.context.properties.bind.BindResult<RabbitConnectionConfiguration> bindResult = mock(org.springframework.boot.context.properties.bind.BindResult.class);
        when(bindResult.orElseThrow(any())).thenReturn(config);
        when(binder.bind(anyString(), eq(RabbitConnectionConfiguration.class))).thenReturn(bindResult);
        // Static mocking for Binder.get(environment)
        try (var mocked = Mockito.mockStatic(org.springframework.boot.context.properties.bind.Binder.class)) {
            mocked.when(() -> org.springframework.boot.context.properties.bind.Binder.get(environment)).thenReturn(binder);

            DynamicRabbitMQDefinitionRegistrar registrar = new DynamicRabbitMQDefinitionRegistrar(environment, "rabbit", messageRecoverer);
            BeanDefinitionRegistry registry = mock(BeanDefinitionRegistry.class);
            registrar.postProcessBeanDefinitionRegistry(registry);
            verify(registry, atLeastOnce()).registerBeanDefinition(eq("testFactory"), any());
        }
    }

} 