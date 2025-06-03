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
}