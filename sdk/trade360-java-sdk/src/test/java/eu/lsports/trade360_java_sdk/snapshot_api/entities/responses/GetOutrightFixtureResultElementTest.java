package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class GetOutrightFixtureResultElementTest {
    @Test
    void testConstructorAndFields() {
        GetOutrightFixtureResultElement element = new GetOutrightFixtureResultElement();
        element.id = 1;
        element.name = "fixture";
        element.type = 2;
        element.events = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("fixture", element.name);
        assertEquals(2, element.type);
        assertNotNull(element.events);
    }
} 