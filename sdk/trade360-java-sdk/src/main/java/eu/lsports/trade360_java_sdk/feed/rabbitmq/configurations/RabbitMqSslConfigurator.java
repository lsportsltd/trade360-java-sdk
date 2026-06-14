package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import com.rabbitmq.client.ConnectionFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

/**
 * Applies SSL/TLS settings to a RabbitMQ {@link ConnectionFactory}.
 * Mirrors .NET {@code RabbitMqSslConfigurator}: enables TLS and relies on the JVM trust store
 * with hostname verification against the configured host.
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

        try {
            String tlsProtocol = ConnectionFactory.computeDefaultTlsProtocol(
                    SSLContext.getDefault().getSupportedSSLParameters().getProtocols());
            SSLContext sslContext = SSLContext.getInstance(tlsProtocol);
            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            connectionFactory.useSslProtocol(sslContext);
            connectionFactory.enableHostnameVerification();
        } catch (Exception ex) {
            throw new IllegalStateException(
                    String.format(
                            "Failed to configure RabbitMQ SSL/TLS for host '%s' on port %d.",
                            configuration.getHost(),
                            configuration.getPort()),
                    ex);
        }
    }
}
