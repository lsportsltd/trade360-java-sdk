package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DynamicRabbitMQDefinitionRegistrarComprehensiveTest {

    @Mock
    private ConfigurableEnvironment mockEnvironment;

    @Mock
    private MessageRecoverer mockMessageRecoverer;

    @Mock
    private BeanDefinitionRegistry mockRegistry;

    @Mock
    private ConnectionFactory mockConnectionFactory;

    private DynamicRabbitMQDefinitionRegistrar registrar;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        when(mockEnvironment.getProperty("rabbit.host")).thenReturn("localhost");
        when(mockEnvironment.getProperty("rabbit.port")).thenReturn("5672");
        when(mockEnvironment.getProperty("rabbit.username")).thenReturn("guest");
        when(mockEnvironment.getProperty("rabbit.password")).thenReturn("guest");
        when(mockEnvironment.getProperty("rabbit.virtualHost")).thenReturn("/");
        when(mockEnvironment.getProperty("rabbit.connectionName")).thenReturn("test-connection");
    }

    @Test
    void testConstructorWithValidParameters() {
        assertDoesNotThrow(() -> {
            new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", mockMessageRecoverer);
        });
    }

    @Test
    void testConstructorWithNullEnvironment() {
        assertThrows(Exception.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(null, "rabbit", mockMessageRecoverer);
        });
    }

    @Test
    void testConstructorWithNullPrefix() {
        assertThrows(Exception.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, null, mockMessageRecoverer);
        });
    }

    @Test
    void testConstructorWithNullMessageRecoverer() {
        assertThrows(Exception.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", null);
        });
    }

    @Test
    void testPostProcessBeanDefinitionRegistry() {
        registrar = new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", mockMessageRecoverer);
        
        assertDoesNotThrow(() -> {
            registrar.postProcessBeanDefinitionRegistry(mockRegistry);
        });
        
        verify(mockRegistry, atLeastOnce()).registerBeanDefinition(anyString(), any());
    }

    @Test
    void testPostProcessBeanFactory() {
        registrar = new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", mockMessageRecoverer);
        
        assertDoesNotThrow(() -> {
            registrar.postProcessBeanFactory(null);
        });
    }

    @Test
    void testWithDifferentRabbitPrefix() {
        when(mockEnvironment.getProperty("custom.host")).thenReturn("localhost");
        when(mockEnvironment.getProperty("custom.port")).thenReturn("5672");
        when(mockEnvironment.getProperty("custom.username")).thenReturn("guest");
        when(mockEnvironment.getProperty("custom.password")).thenReturn("guest");
        when(mockEnvironment.getProperty("custom.virtualHost")).thenReturn("/");
        when(mockEnvironment.getProperty("custom.connectionName")).thenReturn("custom-connection");
        
        assertDoesNotThrow(() -> {
            new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "custom", mockMessageRecoverer);
        });
    }

    @Test
    void testMultipleRegistrarInstances() {
        DynamicRabbitMQDefinitionRegistrar registrar1 = new DynamicRabbitMQDefinitionRegistrar(
            mockEnvironment, "rabbit", mockMessageRecoverer);
        DynamicRabbitMQDefinitionRegistrar registrar2 = new DynamicRabbitMQDefinitionRegistrar(
            mockEnvironment, "rabbit", mockMessageRecoverer);
        
        assertNotNull(registrar1);
        assertNotNull(registrar2);
        assertNotSame(registrar1, registrar2);
    }

    @Test
    void testRegistrarWithMissingConfiguration() {
        ConfigurableEnvironment emptyEnvironment = mock(ConfigurableEnvironment.class);
        when(emptyEnvironment.getProperty(anyString())).thenReturn(null);
        
        assertThrows(Exception.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(emptyEnvironment, "rabbit", mockMessageRecoverer);
        });
    }

    @Test
    void testRegistrarWithPartialConfiguration() {
        ConfigurableEnvironment partialEnvironment = mock(ConfigurableEnvironment.class);
        when(partialEnvironment.getProperty("rabbit.host")).thenReturn("localhost");
        when(partialEnvironment.getProperty("rabbit.port")).thenReturn(null);
        
        assertThrows(Exception.class, () -> {
            new DynamicRabbitMQDefinitionRegistrar(partialEnvironment, "rabbit", mockMessageRecoverer);
        });
    }

    @Test
    void testBeanDefinitionRegistryInteraction() {
        registrar = new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", mockMessageRecoverer);
        
        registrar.postProcessBeanDefinitionRegistry(mockRegistry);
        
        verify(mockRegistry, atLeastOnce()).registerBeanDefinition(anyString(), any());
    }

    @Test
    void testMessageRecovererUsage() {
        registrar = new DynamicRabbitMQDefinitionRegistrar(mockEnvironment, "rabbit", mockMessageRecoverer);
        
        assertNotNull(registrar);
    }
}
