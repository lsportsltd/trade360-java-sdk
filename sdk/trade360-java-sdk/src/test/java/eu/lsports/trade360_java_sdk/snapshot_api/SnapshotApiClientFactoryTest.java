package eu.lsports.trade360_java_sdk.snapshot_api;

import org.junit.jupiter.api.Test;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SnapshotApiClientFactoryTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements SnapshotApiClientFactory {
                public InPlaySnapshotApiClient createInPlayApiClient(URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials credentials) { return null; }
                public PreMatchSnapshotApiClient createPreMatchApiClient(URI baseUrl, eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials credentials) { return null; }
            }
            new Impl();
        });
    }
} 