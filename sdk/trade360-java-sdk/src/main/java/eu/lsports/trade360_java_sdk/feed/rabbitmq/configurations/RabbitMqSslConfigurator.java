package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.rabbitmq.client.ConnectionFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

/**
 * Applies SSL/TLS settings to a RabbitMQ {@link ConnectionFactory}.
 */
final class RabbitMqSslConfigurator {

    static final int STANDARD_AMQP_PLAIN_PORT = 5672;
    static final int STANDARD_AMQP_TLS_PORT = 5671;

    private RabbitMqSslConfigurator() {
    }

    static void apply(ConnectionFactory connectionFactory, RabbitConnectionConfiguration configuration) {
        if (!configuration.isSslEnabled()) {
            return;
        }

        RabbitMqSslConfigurationValidator.validate(configuration);

        try {
            if (hasCustomCertificates(configuration)) {
                SSLContext sslContext = RabbitMqPemSslSupport.createSslContext(configuration);
                connectionFactory.useSslProtocol(sslContext);
            } else {
                SSLContext sslContext = createDefaultTrustSslContext();
                connectionFactory.useSslProtocol(sslContext);
            }
            connectionFactory.enableHostnameVerification();
        } catch (Exception ex) {
            throw new IllegalStateException(
                    String.format(
                            "Failed to configure RabbitMQ SSL/TLS for host '%s' on port %d. "
                                    + "Verify certificate paths, passphrases, and that the broker uses TLS on this port (commonly %d).",
                            configuration.getHost(),
                            configuration.getPort(),
                            STANDARD_AMQP_TLS_PORT),
                    ex);
        }
    }

    private static SSLContext createDefaultTrustSslContext() throws Exception {
        String tlsProtocol = ConnectionFactory.computeDefaultTlsProtocol(
                SSLContext.getDefault().getSupportedSSLParameters().getProtocols());
        SSLContext sslContext = SSLContext.getInstance(tlsProtocol);
        TrustManagerFactory trustManagerFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sslContext;
    }

    private static boolean hasCustomCertificates(RabbitConnectionConfiguration configuration) {
        return isNotBlank(configuration.getSslCaCertificatePath())
                || isNotBlank(configuration.getSslClientCertificatePath())
                || isNotBlank(configuration.getSslClientKeyPath());
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
