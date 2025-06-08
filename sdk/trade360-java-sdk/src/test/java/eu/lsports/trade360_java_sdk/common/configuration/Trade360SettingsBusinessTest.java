package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Trade360SettingsBusinessTest {
    @Test
    void testValidConfigurationUsage() {
        Trade360Settings settings = new Trade360Settings();
        settings.customersApiBaseUrl = "https://api.example.com";
        settings.snapshotApiBaseUrl = "https://snap.example.com";
        settings.InplayPackageCredentials = new PackageCredentials(1, "user", "pass");
        settings.PrematchPackageCredentials = new PackageCredentials(2, "user2", "pass2");

        assertEquals("https://api.example.com", settings.customersApiBaseUrl);
        assertEquals("https://snap.example.com", settings.snapshotApiBaseUrl);
        assertEquals(1, settings.InplayPackageCredentials.packageId());
        assertEquals("user2", settings.PrematchPackageCredentials.userName());
    }

    @Test
    void testNullCredentialsHandling() {
        Trade360Settings settings = new Trade360Settings();
        settings.InplayPackageCredentials = null;
        settings.PrematchPackageCredentials = null;
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    void testInvalidUrlHandling() {
        Trade360Settings settings = new Trade360Settings();
        settings.customersApiBaseUrl = "not a url";
        settings.snapshotApiBaseUrl = "";
        assertEquals("not a url", settings.customersApiBaseUrl);
        assertEquals("", settings.snapshotApiBaseUrl);
    }

    @Test
    void testSwitchingCredentials() {
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials inplay = new PackageCredentials(1, "user", "pass");
        PackageCredentials prematch = new PackageCredentials(2, "user2", "pass2");
        settings.InplayPackageCredentials = inplay;
        settings.PrematchPackageCredentials = prematch;
        assertEquals(inplay, settings.InplayPackageCredentials);
        assertEquals(prematch, settings.PrematchPackageCredentials);
        // Switch
        settings.InplayPackageCredentials = prematch;
        settings.PrematchPackageCredentials = inplay;
        assertEquals(prematch, settings.InplayPackageCredentials);
        assertEquals(inplay, settings.PrematchPackageCredentials);
    }
} 