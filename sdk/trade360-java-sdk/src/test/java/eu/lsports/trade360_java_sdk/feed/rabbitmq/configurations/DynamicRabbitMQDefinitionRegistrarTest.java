package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DynamicRabbitMQDefinitionRegistrarTest {
    private ConfigurableEnvironment environment;
    private MessageRecoverer messageRecoverer;

    @BeforeEach
    void setUp() {
        environment = mock(ConfigurableEnvironment.class);
        messageRecoverer = mock(MessageRecoverer.class);
        // Set up property sources to avoid NullPointerException
        when(environment.getPropertySources()).thenReturn(new MutablePropertySources());
    }

    @Test
    void testConstructorWithMissingConfigThrowsException() {
        // Constructor should throw when configuration binding fails
        // This validates the error handling path
        assertThrows(IllegalStateException.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(environment, "rabbit", messageRecoverer);
        });
    }

    @Test
    void testConstructorWithNullEnvironment() {
        // Test that constructor handles null environment gracefully or throws appropriately
        assertThrows(Exception.class, () -> {
            DynamicRabbitMQDefinitionRegistrar registrar = new DynamicRabbitMQDefinitionRegistrar(null, "rabbit", messageRecoverer);
            BeanDefinitionRegistry registry = mock(BeanDefinitionRegistry.class);
            registrar.postProcessBeanDefinitionRegistry(registry);
        });
    }

} 