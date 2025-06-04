package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseBetTest {
    static class TestBaseBet extends BaseBet {}

    @Test
    void testFieldAssignment() {
        TestBaseBet baseBet = new TestBaseBet();
        assertNotNull(baseBet);
    }
} 