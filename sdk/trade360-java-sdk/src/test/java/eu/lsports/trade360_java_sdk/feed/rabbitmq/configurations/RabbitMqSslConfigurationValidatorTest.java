package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqSslConfigurationValidatorTest {

    @TempDir
    Path tempDir;

    @Test
    void validate_whenSslDisabledAndPlainPort_doesNotThrow() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(false);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        assertDoesNotThrow(() -> RabbitMqSslConfigurationValidator.validate(configuration));
    }

    @Test
    void validate_whenSslEnabledOnPlainPort_throwsClearMessage() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqSslConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("SSL is enabled but port is 5672"));
        assertTrue(exception.getMessage().contains("5671"));
    }

    @Test
    void validate_whenSslDisabledOnTlsPort_throwsClearMessage() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(false);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqSslConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("SSL is disabled but port is 5671"));
        assertTrue(exception.getMessage().contains("5672"));
    }

    @Test
    void validate_whenClientCertWithoutKey_throwsClearMessage() throws Exception {
        Path cert = Files.writeString(tempDir.resolve("client.pem"), "cert");

        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);
        configuration.setSslClientCertificatePath(cert.toString());

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqSslConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("ssl_client_certificate_path"));
        assertTrue(exception.getMessage().contains("ssl_client_key_path"));
    }

    @Test
    void validate_whenCertificateFileMissing_throwsClearMessage() {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslEnabled(true);
        configuration.setPort(RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT);
        configuration.setSslCaCertificatePath("/path/that/does/not/exist.pem");

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> RabbitMqSslConfigurationValidator.validate(configuration));

        assertTrue(exception.getMessage().contains("ssl_ca_certificate_path"));
        assertTrue(exception.getMessage().contains("missing or unreadable file"));
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
