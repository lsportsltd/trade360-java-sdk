package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Validates RabbitMQ SSL/TLS configuration before connecting.
 */
final class RabbitMqSslConfigurationValidator {

    private RabbitMqSslConfigurationValidator() {
    }

    static void validate(RabbitConnectionConfiguration configuration) {
        validatePortConfiguration(configuration);

        if (!configuration.isSslEnabled()) {
            return;
        }

        validateCertificatePaths(configuration);
    }

    private static void validatePortConfiguration(RabbitConnectionConfiguration configuration) {
        int port = configuration.getPort();

        if (configuration.isSslEnabled() && port == RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT) {
            throw new IllegalStateException(String.format(
                    "SSL is enabled but port is %d (plain AMQP). Use port %d for TLS/AMQPS, or disable SSL.",
                    RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT,
                    RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT));
        }

        if (!configuration.isSslEnabled() && port == RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT) {
            throw new IllegalStateException(String.format(
                    "SSL is disabled but port is %d (TLS/AMQPS). Enable ssl_enabled, or use port %d for plain AMQP.",
                    RabbitMqSslConfigurator.STANDARD_AMQP_TLS_PORT,
                    RabbitMqSslConfigurator.STANDARD_AMQP_PLAIN_PORT));
        }
    }

    private static void validateCertificatePaths(RabbitConnectionConfiguration configuration) {
        validateOptionalFile("ssl_ca_certificate_path", configuration.getSslCaCertificatePath());
        validateOptionalFile("ssl_client_certificate_path", configuration.getSslClientCertificatePath());
        validateOptionalFile("ssl_client_key_path", configuration.getSslClientKeyPath());

        boolean hasClientCert = isNotBlank(configuration.getSslClientCertificatePath());
        boolean hasClientKey = isNotBlank(configuration.getSslClientKeyPath());

        if (hasClientCert ^ hasClientKey) {
            throw new IllegalStateException(
                    "Both ssl_client_certificate_path and ssl_client_key_path must be provided for mutual TLS.");
        }
    }

    private static void validateOptionalFile(String propertyName, String filePath) {
        if (!isNotBlank(filePath)) {
            return;
        }

        Path path = Path.of(filePath.trim());
        if (!Files.isRegularFile(path)) {
            throw new IllegalStateException(String.format(
                    "SSL configuration property '%s' points to a missing or unreadable file: %s",
                    propertyName,
                    path));
        }
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
