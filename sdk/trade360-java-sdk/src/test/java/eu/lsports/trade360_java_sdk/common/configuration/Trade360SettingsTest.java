package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Trade360SettingsTest {
    @Test
    void testFieldAssignmentAndNulls() {
        Trade360Settings settings = new Trade360Settings();
        assertNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);

        settings.customersApiBaseUrl = "http://api";
        settings.snapshotApiBaseUrl = "http://snap";
        PackageCredentials inplay = new PackageCredentials(1, "user", "pass");
        PackageCredentials prematch = new PackageCredentials(2, "user2", "pass2");
        settings.InplayPackageCredentials = inplay;
        settings.PrematchPackageCredentials = prematch;

        assertEquals("http://api", settings.customersApiBaseUrl);
        assertEquals("http://snap", settings.snapshotApiBaseUrl);
        assertEquals(inplay, settings.InplayPackageCredentials);
        assertEquals(prematch, settings.PrematchPackageCredentials);
    }
}