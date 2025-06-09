package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightScoreElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightScoreElement element = new OutrightScoreElement();
        element.participantResults = Collections.emptyList();
        element.status = null;
        assertNotNull(element.participantResults);
        assertNull(element.status);
    }
} 