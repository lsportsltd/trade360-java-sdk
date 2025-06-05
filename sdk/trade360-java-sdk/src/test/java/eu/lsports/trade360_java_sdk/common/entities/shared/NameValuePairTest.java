package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameValuePairTest {
    @Test
    void testInstantiation() {
        NameValuePair pair = new NameValuePair();
        assertNotNull(pair);
    }
} 