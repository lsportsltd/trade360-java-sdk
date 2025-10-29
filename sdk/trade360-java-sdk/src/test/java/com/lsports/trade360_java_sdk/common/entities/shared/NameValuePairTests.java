package com.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameValuePairTests {

    @Test
    public void constructor_createsNameValuePairWithDefaultValues() {
        // Act
        NameValuePair pair = new NameValuePair();

        // Assert
        assertNotNull(pair);
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    public void name_canBeSet_andRetrieved() {
        // Arrange
        NameValuePair pair = new NameValuePair();
        String name = "testName";

        // Act
        pair.name = name;

        // Assert
        assertEquals(name, pair.name);
    }

    @Test
    public void value_canBeSet_andRetrieved() {
        // Arrange
        NameValuePair pair = new NameValuePair();
        String value = "testValue";

        // Act
        pair.value = value;

        // Assert
        assertEquals(value, pair.value);
    }

    @Test
    public void nameAndValue_canBeSetTogether() {
        // Arrange
        NameValuePair pair = new NameValuePair();
        String name = "username";
        String value = "john_doe";

        // Act
        pair.name = name;
        pair.value = value;

        // Assert
        assertEquals(name, pair.name);
        assertEquals(value, pair.value);
    }

    @Test
    public void name_canBeNull() {
        // Arrange
        NameValuePair pair = new NameValuePair();
        pair.name = "test";

        // Act
        pair.name = null;

        // Assert
        assertNull(pair.name);
    }

    @Test
    public void value_canBeNull() {
        // Arrange
        NameValuePair pair = new NameValuePair();
        pair.value = "test";

        // Act
        pair.value = null;

        // Assert
        assertNull(pair.value);
    }

    @Test
    public void nameAndValue_canBeEmptyStrings() {
        // Arrange
        NameValuePair pair = new NameValuePair();

        // Act
        pair.name = "";
        pair.value = "";

        // Assert
        assertEquals("", pair.name);
        assertEquals("", pair.value);
    }

    @Test
    public void multipleInstances_areIndependent() {
        // Arrange
        NameValuePair pair1 = new NameValuePair();
        NameValuePair pair2 = new NameValuePair();

        // Act
        pair1.name = "name1";
        pair1.value = "value1";
        pair2.name = "name2";
        pair2.value = "value2";

        // Assert
        assertEquals("name1", pair1.name);
        assertEquals("value1", pair1.value);
        assertEquals("name2", pair2.name);
        assertEquals("value2", pair2.value);
    }
}

