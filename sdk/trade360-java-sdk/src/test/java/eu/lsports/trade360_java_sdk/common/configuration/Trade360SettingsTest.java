package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Trade360SettingsTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Trade360Settings settings = new Trade360Settings();
        assertNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);

        settings.customersApiBaseUrl = "http://example.com/customers";
        settings.snapshotApiBaseUrl = "http://example.com/snapshot";
        PackageCredentials inplay = new PackageCredentials(1, "user1", "pass1");
        PackageCredentials prematch = new PackageCredentials(2, "user2", "pass2", "json");
        settings.InplayPackageCredentials = inplay;
        settings.PrematchPackageCredentials = prematch;

        assertEquals("http://example.com/customers", settings.customersApiBaseUrl);
        assertEquals("http://example.com/snapshot", settings.snapshotApiBaseUrl);
        assertSame(inplay, settings.InplayPackageCredentials);
        assertSame(prematch, settings.PrematchPackageCredentials);
    }
}