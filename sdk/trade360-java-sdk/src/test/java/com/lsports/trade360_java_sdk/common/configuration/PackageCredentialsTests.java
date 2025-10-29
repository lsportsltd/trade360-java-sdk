package com.lsports.trade360_java_sdk.common.configuration;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackageCredentialsTests {

    @Test
    public void constructor_withAllParameters_createsCredentialsWithAllValues() {
        // Arrange
        int packageId = 1234;
        String userName = "testUser";
        String password = "testPassword";
        String messageFormat = "json";

        // Act
        PackageCredentials credentials = new PackageCredentials(packageId, userName, password, messageFormat);

        // Assert
        assertEquals(packageId, credentials.packageId());
        assertEquals(userName, credentials.userName());
        assertEquals(password, credentials.password());
        assertEquals(messageFormat, credentials.messageFormat());
    }

    @Test
    public void constructor_withThreeParameters_createsCredentialsWithDefaultJsonFormat() {
        // Arrange
        int packageId = 1234;
        String userName = "testUser";
        String password = "testPassword";

        // Act
        PackageCredentials credentials = new PackageCredentials(packageId, userName, password);

        // Assert
        assertEquals(packageId, credentials.packageId());
        assertEquals(userName, credentials.userName());
        assertEquals(password, credentials.password());
        assertEquals("json", credentials.messageFormat());
    }

    @Test(expected = NullPointerException.class)
    public void constructor_withNullUserName_throwsNullPointerException() {
        // Act
        new PackageCredentials(1234, null, "password", "json");
    }

    @Test(expected = NullPointerException.class)
    public void constructor_withNullPassword_throwsNullPointerException() {
        // Act
        new PackageCredentials(1234, "user", null, "json");
    }

    @Test(expected = NullPointerException.class)
    public void constructor_withNullMessageFormat_throwsNullPointerException() {
        // Act
        new PackageCredentials(1234, "user", "password", null);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_threeParams_withNullUserName_throwsNullPointerException() {
        // Act
        new PackageCredentials(1234, null, "password");
    }

    @Test(expected = NullPointerException.class)
    public void constructor_threeParams_withNullPassword_throwsNullPointerException() {
        // Act
        new PackageCredentials(1234, "user", null);
    }

    @Test
    public void equals_withSameValues_returnsTrue() {
        // Arrange
        PackageCredentials credentials1 = new PackageCredentials(1234, "user", "password", "json");
        PackageCredentials credentials2 = new PackageCredentials(1234, "user", "password", "json");

        // Act & Assert
        assertEquals(credentials1, credentials2);
    }

    @Test
    public void equals_withDifferentValues_returnsFalse() {
        // Arrange
        PackageCredentials credentials1 = new PackageCredentials(1234, "user", "password", "json");
        PackageCredentials credentials2 = new PackageCredentials(5678, "user", "password", "json");

        // Act & Assert
        assertNotEquals(credentials1, credentials2);
    }

    @Test
    public void hashCode_withSameValues_returnsSameHashCode() {
        // Arrange
        PackageCredentials credentials1 = new PackageCredentials(1234, "user", "password", "json");
        PackageCredentials credentials2 = new PackageCredentials(1234, "user", "password", "json");

        // Act & Assert
        assertEquals(credentials1.hashCode(), credentials2.hashCode());
    }

    @Test
    public void toString_whenCalled_returnsStringRepresentation() {
        // Arrange
        PackageCredentials credentials = new PackageCredentials(1234, "user", "password", "json");

        // Act
        String result = credentials.toString();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("1234"));
        assertTrue(result.contains("user"));
        assertTrue(result.contains("password"));
        assertTrue(result.contains("json"));
    }
}

