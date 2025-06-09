package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeepAliveUpdateComprehensiveTest {

    @Test
    void testKeepAliveUpdateDefaultConstructor() {
        KeepAliveUpdate keepAliveUpdate = new KeepAliveUpdate();
        
        assertNotNull(keepAliveUpdate);
        assertEquals(31, KeepAliveUpdate.entityKey);
        assertNull(keepAliveUpdate.keepAlive);
    }

    @Test
    void testKeepAliveUpdateEntityKeyValue() {
        assertEquals(31, KeepAliveUpdate.entityKey);
    }

    @Test
    void testKeepAliveUpdateKeepAliveAssignment() {
        KeepAliveUpdate keepAliveUpdate = new KeepAliveUpdate();
        KeepAlive testKeepAlive = new KeepAlive();
        
        keepAliveUpdate.keepAlive = testKeepAlive;
        
        assertEquals(testKeepAlive, keepAliveUpdate.keepAlive);
    }

    @Test
    void testKeepAliveUpdateNullKeepAliveAssignment() {
        KeepAliveUpdate keepAliveUpdate = new KeepAliveUpdate();
        
        keepAliveUpdate.keepAlive = null;
        
        assertNull(keepAliveUpdate.keepAlive);
    }

    @Test
    void testKeepAliveUpdateKeepAliveReassignment() {
        KeepAliveUpdate keepAliveUpdate = new KeepAliveUpdate();
        
        KeepAlive firstKeepAlive = new KeepAlive();
        keepAliveUpdate.keepAlive = firstKeepAlive;
        assertEquals(firstKeepAlive, keepAliveUpdate.keepAlive);
        
        KeepAlive secondKeepAlive = new KeepAlive();
        keepAliveUpdate.keepAlive = secondKeepAlive;
        assertEquals(secondKeepAlive, keepAliveUpdate.keepAlive);
    }

    @Test
    void testMultipleKeepAliveUpdateInstances() {
        KeepAliveUpdate update1 = new KeepAliveUpdate();
        KeepAliveUpdate update2 = new KeepAliveUpdate();
        
        KeepAlive keepAlive1 = new KeepAlive();
        KeepAlive keepAlive2 = new KeepAlive();
        
        update1.keepAlive = keepAlive1;
        update2.keepAlive = keepAlive2;
        
        assertEquals(keepAlive1, update1.keepAlive);
        assertEquals(keepAlive2, update2.keepAlive);
        assertNotSame(update1.keepAlive, update2.keepAlive);
    }

    @Test
    void testKeepAliveUpdateConsistency() {
        KeepAliveUpdate update1 = new KeepAliveUpdate();
        KeepAliveUpdate update2 = new KeepAliveUpdate();
        
        KeepAlive testKeepAlive = new KeepAlive();
        
        update1.keepAlive = testKeepAlive;
        update2.keepAlive = testKeepAlive;
        
        assertEquals(update1.keepAlive, update2.keepAlive);
        assertSame(update1.keepAlive, update2.keepAlive);
    }

    @Test
    void testKeepAliveUpdateEntityKeyImmutability() {
        int originalEntityKey = KeepAliveUpdate.entityKey;
        assertEquals(31, originalEntityKey);
        assertEquals(31, KeepAliveUpdate.entityKey);
    }
}
