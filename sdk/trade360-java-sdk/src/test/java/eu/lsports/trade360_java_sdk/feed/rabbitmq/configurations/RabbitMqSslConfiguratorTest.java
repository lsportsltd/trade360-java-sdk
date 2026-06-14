package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqSslConfiguratorTest {

    @Test
    void apply_whenSslDisabled_doesNotEnableSsl() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(false);

        RabbitMqSslConfigurator.apply(connectionFactory, configuration);

        assertFalse(connectionFactory.isSSL());
    }

    @Test
    void apply_whenSslEnabled_enablesSsl() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setHost("rmq.example.com");
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);

        RabbitMqSslConfigurator.apply(connectionFactory, configuration);

        assertTrue(connectionFactory.isSSL());
    }

    private static RabbitConnectionConfiguration baseConfiguration() {
        RabbitConnectionConfiguration configuration = new RabbitConnectionConfiguration();
        configuration.setHost("stm-inplay.lsports.eu");
        configuration.setVirtualHost("StmInPlay");
        configuration.setUserName("user");
        configuration.setPassword("pass");
        configuration.setPackageId(430);
        configuration.setPrefetchCount(100);
        configuration.setBaseCustomersApi("https://stm-api.lsports.eu");
        configuration.setRabbitListenerContainerFactoryName("factory");
        return configuration;
    }
}
