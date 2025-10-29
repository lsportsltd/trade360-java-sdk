package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.Test;

import static org.junit.Assert.*;

public class Trade360SettingsTests {

    @Test
    public void newInstance_hasNullFields() {
        Trade360Settings settings = new Trade360Settings();
        
        assertNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        assertNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    public void setCustomersApiBaseUrl_storesValue() {
        Trade360Settings settings = new Trade360Settings();
        String url = "https://api.customers.example.com";
        
        settings.customersApiBaseUrl = url;
        
        assertEquals(url, settings.customersApiBaseUrl);
    }

    @Test
    public void setSnapshotApiBaseUrl_storesValue() {
        Trade360Settings settings = new Trade360Settings();
        String url = "https://api.snapshot.example.com";
        
        settings.snapshotApiBaseUrl = url;
        
        assertEquals(url, settings.snapshotApiBaseUrl);
    }

    @Test
    public void setInplayPackageCredentials_storesValue() {
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials credentials = new PackageCredentials(123, "user", "pass");
        
        settings.InplayPackageCredentials = credentials;
        
        assertEquals(credentials, settings.InplayPackageCredentials);
    }

    @Test
    public void setPrematchPackageCredentials_storesValue() {
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials credentials = new PackageCredentials(456, "user2", "pass2");
        
        settings.PrematchPackageCredentials = credentials;
        
        assertEquals(credentials, settings.PrematchPackageCredentials);
    }

    @Test
    public void setAllFields_storesAllValues() {
        Trade360Settings settings = new Trade360Settings();
        String customersUrl = "https://customers.api.com";
        String snapshotUrl = "https://snapshot.api.com";
        PackageCredentials inplayCredentials = new PackageCredentials(1, "inplay", "pass1");
        PackageCredentials prematchCredentials = new PackageCredentials(2, "prematch", "pass2");
        
        settings.customersApiBaseUrl = customersUrl;
        settings.snapshotApiBaseUrl = snapshotUrl;
        settings.InplayPackageCredentials = inplayCredentials;
        settings.PrematchPackageCredentials = prematchCredentials;
        
        assertEquals(customersUrl, settings.customersApiBaseUrl);
        assertEquals(snapshotUrl, settings.snapshotApiBaseUrl);
        assertEquals(inplayCredentials, settings.InplayPackageCredentials);
        assertEquals(prematchCredentials, settings.PrematchPackageCredentials);
    }

    @Test
    public void setFields_canSetToNull() {
        Trade360Settings settings = new Trade360Settings();
        settings.customersApiBaseUrl = "https://test.com";
        
        settings.customersApiBaseUrl = null;
        
        assertNull(settings.customersApiBaseUrl);
    }

    @Test
    public void setFields_canOverwritePreviousValues() {
        Trade360Settings settings = new Trade360Settings();
        settings.customersApiBaseUrl = "https://old.com";
        
        settings.customersApiBaseUrl = "https://new.com";
        
        assertEquals("https://new.com", settings.customersApiBaseUrl);
    }

    @Test
    public void credentials_canBeSetIndependently() {
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials inplayCreds = new PackageCredentials(1, "inplay", "pass");
        
        settings.InplayPackageCredentials = inplayCreds;
        
        assertNotNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    public void urls_canBeSetIndependently() {
        Trade360Settings settings = new Trade360Settings();
        
        settings.customersApiBaseUrl = "https://customers.com";
        
        assertNotNull(settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
    }

    @Test
    public void settings_canBeConfiguredGradually() {
        Trade360Settings settings = new Trade360Settings();
        
        settings.customersApiBaseUrl = "https://customers.com";
        assertEquals("https://customers.com", settings.customersApiBaseUrl);
        assertNull(settings.snapshotApiBaseUrl);
        
        settings.snapshotApiBaseUrl = "https://snapshot.com";
        assertEquals("https://snapshot.com", settings.snapshotApiBaseUrl);
        
        settings.InplayPackageCredentials = new PackageCredentials(1, "user", "pass");
        assertNotNull(settings.InplayPackageCredentials);
        assertNull(settings.PrematchPackageCredentials);
    }

    @Test
    public void urls_canContainPathsAndParameters() {
        Trade360Settings settings = new Trade360Settings();
        String complexUrl = "https://api.example.com/v2/customers?param=value&other=123";
        
        settings.customersApiBaseUrl = complexUrl;
        
        assertEquals(complexUrl, settings.customersApiBaseUrl);
    }

    @Test
    public void credentials_maintainIndependentReferences() {
        Trade360Settings settings = new Trade360Settings();
        PackageCredentials creds1 = new PackageCredentials(1, "user1", "pass1");
        PackageCredentials creds2 = new PackageCredentials(2, "user2", "pass2");
        
        settings.InplayPackageCredentials = creds1;
        settings.PrematchPackageCredentials = creds2;
        
        assertNotEquals(settings.InplayPackageCredentials, settings.PrematchPackageCredentials);
        assertEquals(1, settings.InplayPackageCredentials.packageId());
        assertEquals(2, settings.PrematchPackageCredentials.packageId());
    }
}

