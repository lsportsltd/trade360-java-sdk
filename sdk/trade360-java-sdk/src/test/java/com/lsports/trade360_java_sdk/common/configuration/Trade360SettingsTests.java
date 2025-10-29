package com.lsports.trade360_java_sdk.common.configuration;

import org.junit.Test;

import static org.junit.Assert.*;

public class Trade360SettingsTests {

    @Test
    public void constructor_whenCalled_createsInstanceWithNullFields() {
        // Act
        Trade360Settings settings = new Trade360Settings();

        // Assert
        assertNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    public void customersApiBaseUrl_canBeSet_andRetrieved() {
        // Arrange
        Trade360Settings settings = new Trade360Settings();
        String url = "https://api.customers.example.com";

        // Act
        settings.customersApiBaseUrl = url;

        // Assert
        assertEquals(url, settings.customersApiBaseUrl);
    }

    @Test
    public void snapshotApiBaseUrl_canBeSet_andRetrieved() {
        // Arrange
        Trade360Settings settings = new Trade360Settings();
        String url = "https://api.snapshot.example.com";

        // Act
        settings.snapshotApiBaseUrl = url;

        // Assert
        assertEquals(url, settings.snapshotApiBaseUrl);
    }

    @Test
    public void inplayPackageCredentials_canBeSet_andRetrieved() {
        // Arrange
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials credentials = new PackageCredentials(1234, "user", "password");

        // Act
        settings.InplayPackageCredentials = credentials;

        // Assert
        assertEquals(credentials, settings.InplayPackageCredentials);
    }

    @Test
    public void prematchPackageCredentials_canBeSet_andRetrieved() {
        // Arrange
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials credentials = new PackageCredentials(5678, "user", "password");

        // Act
        settings.PrematchPackageCredentials = credentials;

        // Assert
        assertEquals(credentials, settings.PrematchPackageCredentials);
    }

    @Test
    public void allFields_canBeSetTogether() {
        // Arrange
        Trade360Settings settings = new Trade360Settings();
        String customersUrl = "https://api.customers.example.com";
        String snapshotUrl = "https://api.snapshot.example.com";
        PackageCredentials inplayCredentials = new PackageCredentials(1234, "inplay", "pass1");
        PackageCredentials prematchCredentials = new PackageCredentials(5678, "prematch", "pass2");

        // Act
        settings.customersApiBaseUrl = customersUrl;
        settings.snapshotApiBaseUrl = snapshotUrl;
        settings.InplayPackageCredentials = inplayCredentials;
        settings.PrematchPackageCredentials = prematchCredentials;

        // Assert
        assertEquals(customersUrl, settings.customersApiBaseUrl);
        assertEquals(snapshotUrl, settings.snapshotApiBaseUrl);
        assertEquals(inplayCredentials, settings.InplayPackageCredentials);
        assertEquals(prematchCredentials, settings.PrematchPackageCredentials);
    }
}

