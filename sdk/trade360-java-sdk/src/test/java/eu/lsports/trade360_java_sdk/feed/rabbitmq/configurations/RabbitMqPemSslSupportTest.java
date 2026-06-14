package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.net.ssl.SSLContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabbitMqPemSslSupportTest {

    @TempDir
    Path tempDir;

    @Test
    void createSslContext_withTestPemFiles_buildsSslContext() throws Exception {
        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslCaCertificatePath("src/test/resources/ssl/ca.pem");
        configuration.setSslClientCertificatePath("src/test/resources/ssl/client.pem");
        configuration.setSslClientKeyPath("src/test/resources/ssl/client.key");

        SSLContext sslContext = RabbitMqPemSslSupport.createSslContext(configuration);

        assertNotNull(sslContext);
        assertNotNull(sslContext.getSocketFactory());
    }

    @Test
    void createSslContext_withPkcs1Key_throwsClearMessage() throws Exception {
        Path pkcs1Key = Files.writeString(tempDir.resolve("client-rsa.key"), """
                -----BEGIN RSA PRIVATE KEY-----
                MIIBOgIBAAJBALtest
                -----END RSA PRIVATE KEY-----
                """);

        RabbitConnectionConfiguration configuration = baseConfiguration();
        configuration.setSslCaCertificatePath("src/test/resources/ssl/ca.pem");
        configuration.setSslClientCertificatePath("src/test/resources/ssl/client.pem");
        configuration.setSslClientKeyPath(pkcs1Key.toString());

        GeneralSecurityException exception = assertThrows(
                GeneralSecurityException.class,
                () -> RabbitMqPemSslSupport.createSslContext(configuration));

        assertTrue(exception.getMessage().contains("PKCS#1 RSA private keys are not supported"));
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
