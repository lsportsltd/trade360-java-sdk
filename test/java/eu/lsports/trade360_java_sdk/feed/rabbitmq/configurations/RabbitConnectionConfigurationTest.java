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
        config.setPackage_id(1);
        config.setHost("localhost");
        config.setPort(5672);
        config.setVirtual_host("/");
        config.setUser_name("guest");
        config.setPassword("guest");
        config.setPrefetch_count(10);
        config.setAuto_ack(true);
        config.setNetwork_recovery_interval(3000);
        config.setRetry_attempts(3);
        config.setRetry_initial_interval(1000);
        config.setRetry_multiple(2.0);
        config.setRetry_max_interval(5000);
        config.setBase_customers_api("http://example.com/customers");
        config.setConcurrent_consumers(1);
        config.setMax_concurrent_consumers(20);
        config.setRabbit_listener_container_factory_name("rabbitListenerContainerFactory");
        config.setRequestedHeartBeat(30);

        Set<ConstraintViolation<RabbitConnectionConfiguration>> violations = validator.validate(config);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidConfiguration() {
        config.setHost("");
        config.setUser_name("");
        config.setPassword("");
        config.setRabbit_listener_container_factory_name("");

        Set<ConstraintViolation<RabbitConnectionConfiguration>> violations = validator.validate(config);
        assertFalse(violations.isEmpty());
        assertEquals(5, violations.size());
    }
}