package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RabbitConnectionConfigurationTest {

    private Validator validator;
    private RabbitConnectionConfiguration config;

    @BeforeEach
    public void setUp() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.afterPropertiesSet();
        validator = factoryBean.getValidator();
        config = new RabbitConnectionConfiguration();
    }

    @Test
    public void testValidConfiguration() {
        config.setName("TestConnection");
        config.setPackageId(1);
        config.setHost("localhost");
        config.setPort(5672);
        config.setVirtualHost("/");
        config.setUserName("guest");
        config.setPassword("guest");
        config.setPrefetchCount(10);
        config.setAutoAck(true);
        config.setNetworkRecoveryInterval(3000);
        config.setRetryAttempts(3);
        config.setRetryInitialInterval(1000);
        config.setRetryMultiple(2.0);
        config.setRetryMaxInterval(5000);
        config.setBaseCustomersApi("http://example.com/customers");
        config.setConcurrentConsumers(1);
        config.setMaxConcurrentConsumers(20);
        config.setRabbitListenerContainerFactoryName("rabbitListenerContainerFactory");
        config.setRequestedHeartBeat(30);

        Set<ConstraintViolation<RabbitConnectionConfiguration>> violations = validator.validate(config);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidConfiguration() {
        config.setHost("");
        config.setUserName("");
        config.setPassword("");
        config.setRabbitListenerContainerFactoryName("");

        Set<ConstraintViolation<RabbitConnectionConfiguration>> violations = validator.validate(config);
        assertFalse(violations.isEmpty());
        assertEquals(5, violations.size());
    }

    @Test
    public void testGettersAndSetters() {
        config.setName("TestName");
        assertEquals("TestName", config.getName());
        
        config.setPackageId(123);
        assertEquals(123, config.getPackageId());
        
        config.setHost("testhost");
        assertEquals("testhost", config.getHost());
        
        config.setPort(1234);
        assertEquals(1234, config.getPort());
        
        config.setVirtualHost("/test");
        assertEquals("/test", config.getVirtualHost());
        
        config.setUserName("testuser");
        assertEquals("testuser", config.getUserName());
        
        config.setPassword("testpass");
        assertEquals("testpass", config.getPassword());
        
        config.setPrefetchCount(50);
        assertEquals(50, config.getPrefetchCount());
        
        config.setAutoAck(false);
        assertFalse(config.isAutoAck());
        
        config.setNetworkRecoveryInterval(5000);
        assertEquals(5000, config.getNetworkRecoveryInterval());
        
        config.setRetryAttempts(5);
        assertEquals(5, config.getRetryAttempts());
        
        config.setRetryInitialInterval(2000);
        assertEquals(2000, config.getRetryInitialInterval());
        
        config.setRetryMultiple(3.0);
        assertEquals(3.0, config.getRetryMultiple());
        
        config.setRetryMaxInterval(10000);
        assertEquals(10000, config.getRetryMaxInterval());
        
        config.setBaseCustomersApi("http://test.com");
        assertEquals("http://test.com", config.getBaseCustomersApi());
        
        config.setConcurrentConsumers(5);
        assertEquals(5, config.getConcurrentConsumers());
        
        config.setMaxConcurrentConsumers(50);
        assertEquals(50, config.getMaxConcurrentConsumers());
        
        config.setRabbitListenerContainerFactoryName("testFactory");
        assertEquals("testFactory", config.getRabbitListenerContainerFactoryName());
        
        config.setRequestedHeartBeat(60);
        assertEquals(60, config.getRequestedHeartBeat());
    }

    @Test
    public void testDefaultValues() {
        RabbitConnectionConfiguration defaultConfig = new RabbitConnectionConfiguration();
        
        assertEquals("localhost", defaultConfig.getHost());
        assertEquals(5672, defaultConfig.getPort());
        assertEquals("/", defaultConfig.getVirtualHost());
        assertEquals("guest", defaultConfig.getUserName());
        assertEquals("guest", defaultConfig.getPassword());
        assertTrue(defaultConfig.isAutoAck());
        assertEquals(3000, defaultConfig.getNetworkRecoveryInterval());
        assertEquals(3, defaultConfig.getRetryAttempts());
        assertEquals(1000, defaultConfig.getRetryInitialInterval());
        assertEquals(2.0, defaultConfig.getRetryMultiple());
        assertEquals(5000, defaultConfig.getRetryMaxInterval());
        assertEquals(1, defaultConfig.getConcurrentConsumers());
        assertEquals(20, defaultConfig.getMaxConcurrentConsumers());
        assertEquals(30, defaultConfig.getRequestedHeartBeat());
    }

    @Test
    void testInstantiation() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        assertNotNull(config);
    }
}
