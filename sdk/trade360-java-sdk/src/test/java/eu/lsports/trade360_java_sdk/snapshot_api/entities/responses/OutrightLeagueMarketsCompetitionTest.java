package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightLeagueMarketsCompetitionTest {
    @Test
    void testConstructorAndFields() {
        OutrightLeagueMarketsCompetition element = new OutrightLeagueMarketsCompetition();
        element.id = 1;
        element.name = "competition";
        element.type = 2;
        element.events = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("competition", element.name);
        assertEquals(2, element.type);
        assertNotNull(element.events);
    }
} 