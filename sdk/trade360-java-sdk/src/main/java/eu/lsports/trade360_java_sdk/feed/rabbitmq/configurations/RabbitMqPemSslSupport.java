package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Base64;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Builds {@link SSLContext} instances from PEM certificate files.
 */
final class RabbitMqPemSslSupport {

    private static final Pattern PEM_BLOCK =
            Pattern.compile("-----BEGIN ([^-]+)-----([\\s\\S]*?)-----END \\1-----");

    private RabbitMqPemSslSupport() {
    }

    static SSLContext createSslContext(RabbitConnectionConfiguration configuration)
            throws GeneralSecurityException, IOException {
        String tlsProtocol = com.rabbitmq.client.ConnectionFactory.computeDefaultTlsProtocol(
                SSLContext.getDefault().getSupportedSSLParameters().getProtocols());

        KeyManagerFactory keyManagerFactory = null;
        if (hasClientCertificate(configuration)) {
            KeyStore keyStore = loadClientKeyStore(
                    Path.of(configuration.getSslClientCertificatePath().trim()),
                    Path.of(configuration.getSslClientKeyPath().trim()),
                    configuration.getSslClientKeyPassphrase());
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            char[] keyPassword = passphraseToChars(configuration.getSslClientKeyPassphrase());
            keyManagerFactory.init(keyStore, keyPassword);
        }

        TrustManagerFactory trustManagerFactory = null;
        if (isNotBlank(configuration.getSslCaCertificatePath())) {
            KeyStore trustStore = loadTrustStore(Path.of(configuration.getSslCaCertificatePath().trim()));
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
        } else if (keyManagerFactory == null) {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
        }

        SSLContext sslContext = SSLContext.getInstance(tlsProtocol);
        sslContext.init(
                keyManagerFactory == null ? null : keyManagerFactory.getKeyManagers(),
                trustManagerFactory == null ? null : trustManagerFactory.getTrustManagers(),
                null);
        return sslContext;
    }

    private static boolean hasClientCertificate(RabbitConnectionConfiguration configuration) {
        return isNotBlank(configuration.getSslClientCertificatePath())
                && isNotBlank(configuration.getSslClientKeyPath());
    }

    private static KeyStore loadTrustStore(Path caCertificatePath)
            throws GeneralSecurityException, IOException {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);

        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        try (InputStream inputStream = Files.newInputStream(caCertificatePath)) {
            Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(inputStream);
            int index = 0;
            for (Certificate certificate : certificates) {
                trustStore.setCertificateEntry("ca-" + index++, certificate);
            }
        }

        if (trustStore.size() == 0) {
            throw new GeneralSecurityException(
                    "No X.509 certificates found in ssl_ca_certificate_path: " + caCertificatePath);
        }

        return trustStore;
    }

    private static KeyStore loadClientKeyStore(Path certificatePath, Path keyPath, String keyPassphrase)
            throws GeneralSecurityException, IOException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate;
        try (InputStream inputStream = Files.newInputStream(certificatePath)) {
            certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
        }

        PrivateKey privateKey = loadPrivateKey(Files.readString(keyPath), keyPassphrase);

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);
        char[] password = passphraseToChars(keyPassphrase);
        keyStore.setKeyEntry("client", privateKey, password, new Certificate[] { certificate });
        return keyStore;
    }

    private static PrivateKey loadPrivateKey(String pemContents, String keyPassphrase)
            throws GeneralSecurityException {
        if (pemContents.contains("BEGIN ENCRYPTED PRIVATE KEY")) {
            throw new GeneralSecurityException(
                    "Encrypted private keys are not supported. Provide an unencrypted PKCS#8 key "
                            + "(-----BEGIN PRIVATE KEY-----) or decrypt the key before configuring the SDK.");
        }

        Matcher matcher = PEM_BLOCK.matcher(pemContents);
        while (matcher.find()) {
            String label = matcher.group(1).trim();
            if (!label.contains("PRIVATE KEY")) {
                continue;
            }

            if (label.equals("RSA PRIVATE KEY")) {
                throw new GeneralSecurityException(
                        "PKCS#1 RSA private keys are not supported. Convert the key to PKCS#8 "
                                + "(-----BEGIN PRIVATE KEY-----) before configuring the SDK.");
            }

            byte[] decoded = Base64.getDecoder().decode(matcher.group(2).replaceAll("\\s", ""));
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            for (String algorithm : List.of("RSA", "EC", "EdDSA", "DSA")) {
                try {
                    return KeyFactory.getInstance(algorithm).generatePrivate(keySpec);
                } catch (InvalidKeySpecException ignored) {
                    // try next algorithm
                }
            }
            throw new InvalidKeySpecException("Unsupported PKCS#8 private key algorithm");
        }

        throw new GeneralSecurityException(
                "No PKCS#8 private key found in ssl_client_key_path. Expected -----BEGIN PRIVATE KEY----- block.");
    }

    private static char[] passphraseToChars(String passphrase) {
        return isNotBlank(passphrase) ? passphrase.toCharArray() : new char[0];
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
