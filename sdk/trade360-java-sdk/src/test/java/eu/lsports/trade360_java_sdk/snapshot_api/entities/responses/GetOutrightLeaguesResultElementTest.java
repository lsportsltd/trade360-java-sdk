package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class GetOutrightLeaguesResultElementTest {
    @Test
    void testConstructorAndFields() {
        GetOutrightLeaguesResultElement element = new GetOutrightLeaguesResultElement();
        element.id = 1;
        element.name = "leagues";
        element.type = 2;
        element.competitions = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("leagues", element.name);
        assertEquals(2, element.type);
        assertNotNull(element.competitions);
    }
} 