package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreUpdateTest {
    @Test
    void testFieldAssignment() {
        LivescoreUpdate update = new LivescoreUpdate();
        LivescoreEvent event = new LivescoreEvent();
        update.events = List.of(event);
        assertEquals(2, LivescoreUpdate.entityKey);
        assertNotNull(update.events);
    }
} 