package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqConsumeQueueNameResolverTest {

    @Test
    void resolve_whenCustomQueueNameSet_returnsTrimmedCustomName() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setCustomQueueName("  prod-my-queue  ");

        assertEquals("prod-my-queue", RabbitMqConsumeQueueNameResolver.resolve(configuration));
    }

    @Test
    void resolve_whenCustomQueueNameNotSet_usesPackageIdPattern() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(430);

        assertEquals("_430_", RabbitMqConsumeQueueNameResolver.resolve(configuration));
    }

    @Test
    void resolve_whenZeroPackageIdAndNoCustomQueueName_returnsEmptyString() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(0);

        assertEquals("", RabbitMqConsumeQueueNameResolver.resolve(configuration));
    }

    @Test
    void resolve_whenZeroPackageIdWithCustomQueueName_returnsCustomName() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setPackageId(0);
        configuration.setCustomQueueName("fixed-queue");

        assertEquals("fixed-queue", RabbitMqConsumeQueueNameResolver.resolve(configuration));
    }

    @Test
    void resolve_whenConfigurationNull_throws() {
        assertThrows(IllegalArgumentException.class, () -> RabbitMqConsumeQueueNameResolver.resolve(null));
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
