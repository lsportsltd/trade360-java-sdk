package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqSslConfiguratorTest {

    @Test
    void apply_whenSslDisabled_doesNotEnableSsl() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(false);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        RabbitMqSslConfigurator.apply(connectionFactory, configuration);

        assertFalse(connectionFactory.isSSL());
    }

    @Test
    void apply_whenSslEnabledWithoutCustomCertificates_enablesSsl() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);

        RabbitMqSslConfigurator.apply(connectionFactory, configuration);

        assertTrue(connectionFactory.isSSL());
    }

    @Test
    void apply_whenSslEnabledWithCustomCertificates_enablesSsl() {
        String sslDir = "src/test/resources/ssl";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);
        configuration.setSslCaCertificatePath(sslDir + "/ca.pem");
        configuration.setSslClientCertificatePath(sslDir + "/client.pem");
        configuration.setSslClientKeyPath(sslDir + "/client.key");

        RabbitMqSslConfigurator.apply(connectionFactory, configuration);

        assertTrue(connectionFactory.isSSL());
    }

    @Test
    void apply_whenSslEnabledOnPlainPort_throwsClearMessage() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqSslConfigurator.apply(connectionFactory, configuration));

        assertTrue(exception.getMessage().contains("SSL is enabled but port is 5672"));
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
