package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameValuePairTests {

    @Test
    public void newInstance_hasNullFields() {
        NameValuePair pair = new NameValuePair();
        
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    public void setName_storesValue() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "testName";
        
        assertEquals("testName", pair.name);
    }

    @Test
    public void setValue_storesValue() {
        NameValuePair pair = new NameValuePair();
        
        pair.value = "testValue";
        
        assertEquals("testValue", pair.value);
    }

    @Test
    public void setBothFields_storesBothValues() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "key";
        pair.value = "val";
        
        assertEquals("key", pair.name);
        assertEquals("val", pair.value);
    }

    @Test
    public void setFields_canOverwriteValues() {
        NameValuePair pair = new NameValuePair();
        pair.name = "old";
        pair.value = "old";
        
        pair.name = "new";
        pair.value = "new";
        
        assertEquals("new", pair.name);
        assertEquals("new", pair.value);
    }

    @Test
    public void setFields_canSetToNull() {
        NameValuePair pair = new NameValuePair();
        pair.name = "test";
        pair.value = "test";
        
        pair.name = null;
        pair.value = null;
        
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    public void setFields_canContainEmptyStrings() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "";
        pair.value = "";
        
        assertEquals("", pair.name);
        assertEquals("", pair.value);
    }

    @Test
    public void setFields_canContainSpecialCharacters() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "name-with-dashes_and_underscores";
        pair.value = "value!@#$%^&*()";
        
        assertEquals("name-with-dashes_and_underscores", pair.name);
        assertEquals("value!@#$%^&*()", pair.value);
    }

    @Test
    public void setFields_canContainLongStrings() {
        NameValuePair pair = new NameValuePair();
        String longString = "A".repeat(1000);
        
        pair.name = longString;
        pair.value = longString;
        
        assertEquals(longString, pair.name);
        assertEquals(longString, pair.value);
    }

    @Test
    public void setFields_canContainWhitespace() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "   ";
        pair.value = "  value with spaces  ";
        
        assertEquals("   ", pair.name);
        assertEquals("  value with spaces  ", pair.value);
    }

    @Test
    public void setFields_canContainNumbers() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "123";
        pair.value = "456.789";
        
        assertEquals("123", pair.name);
        assertEquals("456.789", pair.value);
    }

    @Test
    public void setFields_canContainNewlines() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "line1\nline2";
        pair.value = "val1\nval2\nval3";
        
        assertEquals("line1\nline2", pair.name);
        assertEquals("val1\nval2\nval3", pair.value);
    }

    @Test
    public void setFields_independentlyModifiable() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "name1";
        assertEquals("name1", pair.name);
        assertNull(pair.value);
        
        pair.value = "value1";
        assertEquals("name1", pair.name);
        assertEquals("value1", pair.value);
    }
}

