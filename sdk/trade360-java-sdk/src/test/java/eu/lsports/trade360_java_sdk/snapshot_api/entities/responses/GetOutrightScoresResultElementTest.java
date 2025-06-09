package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class GetOutrightScoresResultElementTest {
    @Test
    void testConstructorAndFields() {
        GetOutrightScoresResultElement element = new GetOutrightScoresResultElement();
        element.id = 1;
        element.name = "score";
        element.type = 2;
        element.events = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("score", element.name);
        assertEquals(2, element.type);
        assertNotNull(element.events);
    }
} 