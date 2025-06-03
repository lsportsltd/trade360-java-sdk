package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Trade360SettingsTest {

    private Trade360Settings settings;

    @BeforeEach
    public void setUp() {
        settings = new Trade360Settings();
    }

    @Test
    public void testDefaultValues() {
        assertNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    public void testSetAndGetCustomersApiBaseUrl() {
        String url = "http://example.com/customers";
        settings.customersApiBaseUrl = url;
        assertEquals(url, settings.customersApiBaseUrl);
    }

    @Test
    public void testSetAndGetSnapshotApiBaseUrl() {
        String url = "http://example.com/snapshot";
        settings.snapshotApiBaseUrl = url;
        assertEquals(url, settings.snapshotApiBaseUrl);
    }

    @Test
    public void testSetAndGetInplayPackageCredentials() {
        PackageCredentials credentials = new PackageCredentials(1, "user", "pass");
        settings.InplayPackageCredentials = credentials;
        assertEquals(credentials, settings.InplayPackageCredentials);
    }

    @Test
    public void testSetAndGetPrematchPackageCredentials() {
        PackageCredentials credentials = new PackageCredentials(2, "user2", "pass2");
        settings.PrematchPackageCredentials = credentials;
        assertEquals(credentials, settings.PrematchPackageCredentials);
    }
}