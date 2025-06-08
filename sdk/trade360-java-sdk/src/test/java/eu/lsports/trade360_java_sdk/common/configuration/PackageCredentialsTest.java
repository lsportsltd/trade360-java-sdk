package eu.lsports.trade360_java_sdk.common.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageCredentialsTest {
    @Test
    void testFullConstructorAndAccessors() {
        PackageCredentials creds = new PackageCredentials(1, "user", "pass", "json");
        assertEquals(1, creds.packageId());
        assertEquals("user", creds.userName());
        assertEquals("pass", creds.password());
        assertEquals("json", creds.messageFormat());
    }

    @Test
    void testDefaultMessageFormatConstructor() {
        PackageCredentials creds = new PackageCredentials(2, "user2", "pass2");
        assertEquals(2, creds.packageId());
        assertEquals("user2", creds.userName());
        assertEquals("pass2", creds.password());
        assertEquals("json", creds.messageFormat());
    }

    @Test
    void testNullValidation() {
        assertThrows(NullPointerException.class, () -> new PackageCredentials(1, null, "pass", "json"));
        assertThrows(NullPointerException.class, () -> new PackageCredentials(1, "user", null, "json"));
        assertThrows(NullPointerException.class, () -> new PackageCredentials(1, "user", "pass", null));
    }

    @Test
    void testEqualsAndHashCode() {
        PackageCredentials creds1 = new PackageCredentials(1, "user", "pass", "json");
        PackageCredentials creds2 = new PackageCredentials(1, "user", "pass", "json");
        PackageCredentials creds3 = new PackageCredentials(2, "user2", "pass2", "json");
        assertEquals(creds1, creds2);
        assertNotEquals(creds1, creds3);
        assertEquals(creds1.hashCode(), creds2.hashCode());
        assertNotEquals(creds1.hashCode(), creds3.hashCode());
    }

    @Test
    void testToString() {
        PackageCredentials creds = new PackageCredentials(1, "user", "pass", "json");
        String str = creds.toString();
        assertTrue(str.contains("user"));
        assertTrue(str.contains("pass"));
        assertTrue(str.contains("json"));
    }
} 