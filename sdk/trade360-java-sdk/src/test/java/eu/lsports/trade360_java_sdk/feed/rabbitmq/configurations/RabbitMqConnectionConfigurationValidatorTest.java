package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqConnectionConfigurationValidatorTest {

    @Test
    void validate_whenDefaultQueueConfiguration_doesNotThrow() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(430);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        assertDoesNotThrow(() -> RabbitMqConnectionConfigurationValidator.validate(configuration));
    }

    @Test
    void validate_whenZeroPackageIdWithoutCustomQueueName_throwsClearMessage() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(0);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqConnectionConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("package_id is required when custom_queue_name is not set"));
    }

    @Test
    void validate_whenCustomQueueNameTooLong_throwsClearMessage() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setCustomQueueName("a".repeat(RabbitMqConsumeQueueNameResolver.CONSUME_QUEUE_NAME_MAX_LENGTH + 1));
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqConnectionConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("custom_queue_name must be at most 255 characters"));
    }

    @Test
    void validate_whenZeroPackageIdWithCustomQueueName_doesNotThrow() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(0);
        configuration.setCustomQueueName("my-queue");
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        assertDoesNotThrow(() -> RabbitMqConnectionConfigurationValidator.validate(configuration));
    }

    private static RabbitConnectionConfiguration baseConfiguration() {
        RabbitConnectionConfiguration configuration = new RabbitConnectionConfiguration();
        configuration.setHost("stm-inplay.lsports.eu");
        configuration.setVirtualHost("StmInPlay");
        configuration.setUserName("user");
        configuration.setPassword("pass");
        configuration.setPackageId(430);
        configuration.setPrefetchCount(1);
        configuration.setBaseCustomersApi("https://stm-api.lsports.eu");
        configuration.setRabbitListenerContainerFactoryName("factory");
        return configuration;
    }
}
