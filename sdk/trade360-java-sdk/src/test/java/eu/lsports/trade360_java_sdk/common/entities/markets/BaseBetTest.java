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
    
    @Test
    void testPlayerIdField() {
        TestBaseBet baseBet = new TestBaseBet();
        
        // Test default value
        assertEquals(0, baseBet.playerId);
        
        // Test assignment
        baseBet.playerId = 12345;
        assertEquals(12345, baseBet.playerId);
    }
    
    @Test
    void testOrderField() {
        TestBaseBet baseBet = new TestBaseBet();
        
        // Test default value
        assertEquals(0, baseBet.order);
        
        // Test assignment
        baseBet.order = 5;
        assertEquals(5, baseBet.order);
    }
    
    @Test
    void testPlayerIdAndOrderTogether() {
        TestBaseBet baseBet = new TestBaseBet();
        
        baseBet.playerId = 99999;
        baseBet.order = 10;
        
        assertEquals(99999, baseBet.playerId);
        assertEquals(10, baseBet.order);
    }
    
    @Test
    void testPlayerIdEdgeCases() {
        TestBaseBet baseBet = new TestBaseBet();
        
        // Test negative value
        baseBet.playerId = -1;
        assertEquals(-1, baseBet.playerId);
        
        // Test large value
        baseBet.playerId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, baseBet.playerId);
        
        // Test minimum value
        baseBet.playerId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, baseBet.playerId);
    }
    
    @Test
    void testOrderEdgeCases() {
        TestBaseBet baseBet = new TestBaseBet();
        
        // Test large value
        baseBet.order = 999;
        assertEquals(999, baseBet.order);
        
        // Test zero
        baseBet.order = 0;
        assertEquals(0, baseBet.order);
        
        // Test negative (edge case - might indicate error state)
        baseBet.order = -1;
        assertEquals(-1, baseBet.order);
    }
} 