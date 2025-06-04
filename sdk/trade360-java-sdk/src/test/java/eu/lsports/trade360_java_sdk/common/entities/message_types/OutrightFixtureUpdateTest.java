package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightFixtureEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureUpdateTest {
    @Test
    void testFieldAssignment() {
        OutrightFixtureUpdate update = new OutrightFixtureUpdate();
        assertNotNull(update);
    }
} 