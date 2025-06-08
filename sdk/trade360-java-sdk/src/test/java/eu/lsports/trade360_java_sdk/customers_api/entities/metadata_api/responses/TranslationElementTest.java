package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TranslationElementTest {
    @Test
    void testConstructorAndFields() {
        int languageId = 1;
        String value = "Hello";
        TranslationElement te = new TranslationElement(languageId, value);
        assertEquals(languageId, te.languageId());
        assertEquals(value, te.value());
    }
} 