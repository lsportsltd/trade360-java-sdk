package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameValuePairComprehensiveTest {

    @Test
    void testNameValuePairDefaultConstructor() {
        NameValuePair pair = new NameValuePair();
        
        assertNotNull(pair);
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    void testNameValuePairNameAssignment() {
        NameValuePair pair = new NameValuePair();
        String testName = "Test Name";
        
        pair.name = testName;
        
        assertEquals(testName, pair.name);
        assertNull(pair.value);
    }

    @Test
    void testNameValuePairValueAssignment() {
        NameValuePair pair = new NameValuePair();
        String testValue = "Test Value";
        
        pair.value = testValue;
        
        assertEquals(testValue, pair.value);
        assertNull(pair.name);
    }

    @Test
    void testNameValuePairBothFieldsAssignment() {
        NameValuePair pair = new NameValuePair();
        String testName = "Test Name";
        String testValue = "Test Value";
        
        pair.name = testName;
        pair.value = testValue;
        
        assertEquals(testName, pair.name);
        assertEquals(testValue, pair.value);
    }

    @Test
    void testNameValuePairNullNameAssignment() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = null;
        pair.value = "Some Value";
        
        assertNull(pair.name);
        assertEquals("Some Value", pair.value);
    }

    @Test
    void testNameValuePairNullValueAssignment() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "Some Name";
        pair.value = null;
        
        assertEquals("Some Name", pair.name);
        assertNull(pair.value);
    }

    @Test
    void testNameValuePairEmptyStringAssignment() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "";
        pair.value = "";
        
        assertEquals("", pair.name);
        assertEquals("", pair.value);
    }

    @Test
    void testNameValuePairLongStringAssignment() {
        NameValuePair pair = new NameValuePair();
        String longName = "This is a very long name that contains a lot of text to test how the NameValuePair handles lengthy names";
        String longValue = "This is a very long value that contains a lot of text to test how the NameValuePair handles lengthy values";
        
        pair.name = longName;
        pair.value = longValue;
        
        assertEquals(longName, pair.name);
        assertEquals(longValue, pair.value);
    }

    @Test
    void testNameValuePairSpecialCharactersAssignment() {
        NameValuePair pair = new NameValuePair();
        String specialName = "Name with special chars: @#$%^&*()[]{}|\\:;\"'<>,.?/~`";
        String specialValue = "Value with special chars: @#$%^&*()[]{}|\\:;\"'<>,.?/~`";
        
        pair.name = specialName;
        pair.value = specialValue;
        
        assertEquals(specialName, pair.name);
        assertEquals(specialValue, pair.value);
    }

    @Test
    void testNameValuePairUnicodeAssignment() {
        NameValuePair pair = new NameValuePair();
        String unicodeName = "Unicode name: ñáéíóú 中文 العربية русский";
        String unicodeValue = "Unicode value: ñáéíóú 中文 العربية русский";
        
        pair.name = unicodeName;
        pair.value = unicodeValue;
        
        assertEquals(unicodeName, pair.name);
        assertEquals(unicodeValue, pair.value);
    }

    @Test
    void testNameValuePairNewlineAssignment() {
        NameValuePair pair = new NameValuePair();
        String newlineName = "Name with\nnewlines\nand multiple\nlines";
        String newlineValue = "Value with\nnewlines\nand multiple\nlines";
        
        pair.name = newlineName;
        pair.value = newlineValue;
        
        assertEquals(newlineName, pair.name);
        assertEquals(newlineValue, pair.value);
    }

    @Test
    void testNameValuePairTabAssignment() {
        NameValuePair pair = new NameValuePair();
        String tabName = "Name with\ttabs\tand\tspacing";
        String tabValue = "Value with\ttabs\tand\tspacing";
        
        pair.name = tabName;
        pair.value = tabValue;
        
        assertEquals(tabName, pair.name);
        assertEquals(tabValue, pair.value);
    }

    @Test
    void testNameValuePairReassignment() {
        NameValuePair pair = new NameValuePair();
        String firstName = "First Name";
        String firstValue = "First Value";
        String secondName = "Second Name";
        String secondValue = "Second Value";
        
        pair.name = firstName;
        pair.value = firstValue;
        assertEquals(firstName, pair.name);
        assertEquals(firstValue, pair.value);
        
        pair.name = secondName;
        pair.value = secondValue;
        assertEquals(secondName, pair.name);
        assertEquals(secondValue, pair.value);
    }

    @Test
    void testNameValuePairNullToStringAssignment() {
        NameValuePair pair = new NameValuePair();
        pair.name = null;
        pair.value = null;
        
        pair.name = "New Name";
        pair.value = "New Value";
        
        assertEquals("New Name", pair.name);
        assertEquals("New Value", pair.value);
    }

    @Test
    void testNameValuePairStringToNullAssignment() {
        NameValuePair pair = new NameValuePair();
        pair.name = "Initial Name";
        pair.value = "Initial Value";
        
        pair.name = null;
        pair.value = null;
        
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    void testMultipleNameValuePairInstances() {
        NameValuePair pair1 = new NameValuePair();
        NameValuePair pair2 = new NameValuePair();
        String name1 = "Name 1";
        String value1 = "Value 1";
        String name2 = "Name 2";
        String value2 = "Value 2";
        
        pair1.name = name1;
        pair1.value = value1;
        pair2.name = name2;
        pair2.value = value2;
        
        assertEquals(name1, pair1.name);
        assertEquals(value1, pair1.value);
        assertEquals(name2, pair2.name);
        assertEquals(value2, pair2.value);
        assertNotEquals(pair1.name, pair2.name);
        assertNotEquals(pair1.value, pair2.value);
    }

    @Test
    void testNameValuePairImmutabilityOfString() {
        NameValuePair pair = new NameValuePair();
        String originalName = "Original Name";
        String originalValue = "Original Value";
        pair.name = originalName;
        pair.value = originalValue;
        
        String retrievedName = pair.name;
        String retrievedValue = pair.value;
        
        assertEquals(originalName, retrievedName);
        assertEquals(originalValue, retrievedValue);
        assertSame(originalName, retrievedName);
        assertSame(originalValue, retrievedValue);
    }

    @Test
    void testNameValuePairWithJsonSpecialCharacters() {
        NameValuePair pair = new NameValuePair();
        String jsonName = "{\"name\": \"Test Name\"}";
        String jsonValue = "{\"value\": \"Test Value\", \"code\": 200}";
        
        pair.name = jsonName;
        pair.value = jsonValue;
        
        assertEquals(jsonName, pair.name);
        assertEquals(jsonValue, pair.value);
    }

    @Test
    void testNameValuePairWithNumericStrings() {
        NameValuePair pair = new NameValuePair();
        String numericName = "12345";
        String numericValue = "67890";
        
        pair.name = numericName;
        pair.value = numericValue;
        
        assertEquals(numericName, pair.name);
        assertEquals(numericValue, pair.value);
    }

    @Test
    void testNameValuePairWithBooleanStrings() {
        NameValuePair pair = new NameValuePair();
        String booleanName = "true";
        String booleanValue = "false";
        
        pair.name = booleanName;
        pair.value = booleanValue;
        
        assertEquals(booleanName, pair.name);
        assertEquals(booleanValue, pair.value);
    }

    @Test
    void testNameValuePairWithWhitespaceStrings() {
        NameValuePair pair = new NameValuePair();
        String whitespaceName = "   Name with spaces   ";
        String whitespaceValue = "   Value with spaces   ";
        
        pair.name = whitespaceName;
        pair.value = whitespaceValue;
        
        assertEquals(whitespaceName, pair.name);
        assertEquals(whitespaceValue, pair.value);
    }
}
