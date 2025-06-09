package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightLivescoreTest {
    @Test
    void testConstructorAndFields() {
        OutrightLivescore element = new OutrightLivescore();
        element.participantResults = Collections.emptyList();
        element.status = null;
        assertNotNull(element.participantResults);
        assertNull(element.status);
    }
} 