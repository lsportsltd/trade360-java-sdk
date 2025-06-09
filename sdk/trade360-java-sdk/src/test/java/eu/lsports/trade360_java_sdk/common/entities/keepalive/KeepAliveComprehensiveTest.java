package eu.lsports.trade360_java_sdk.common.entities.keepalive;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class KeepAliveComprehensiveTest {

    @Test
    void testKeepAliveDefaultConstructor() {
        KeepAlive keepAlive = new KeepAlive();
        
        assertNotNull(keepAlive);
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
        assertNull(keepAlive.providerId);
    }

    @Test
    void testKeepAliveActiveEventsAssignment() {
        KeepAlive keepAlive = new KeepAlive();
        Iterable<Integer> testEvents = Arrays.asList(1, 2, 3);
        
        keepAlive.activeEvents = testEvents;
        
        assertEquals(testEvents, keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
        assertNull(keepAlive.providerId);
    }

    @Test
    void testKeepAliveExtraDataAssignment() {
        KeepAlive keepAlive = new KeepAlive();
        NameValuePair pair = new NameValuePair();
        Iterable<NameValuePair> testExtraData = Collections.singletonList(pair);
        
        keepAlive.extraData = testExtraData;
        
        assertEquals(testExtraData, keepAlive.extraData);
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.providerId);
    }

    @Test
    void testKeepAliveProviderIdAssignment() {
        KeepAlive keepAlive = new KeepAlive();
        
        keepAlive.providerId = 123;
        
        assertEquals(123, keepAlive.providerId);
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
    }

    @Test
    void testKeepAliveAllFieldsAssignment() {
        KeepAlive keepAlive = new KeepAlive();
        Iterable<Integer> testEvents = Arrays.asList(1, 2, 3);
        NameValuePair pair = new NameValuePair();
        Iterable<NameValuePair> testExtraData = Collections.singletonList(pair);
        Integer testProviderId = 456;
        
        keepAlive.activeEvents = testEvents;
        keepAlive.extraData = testExtraData;
        keepAlive.providerId = testProviderId;
        
        assertEquals(testEvents, keepAlive.activeEvents);
        assertEquals(testExtraData, keepAlive.extraData);
        assertEquals(testProviderId, keepAlive.providerId);
    }

    @Test
    void testKeepAliveNullAssignments() {
        KeepAlive keepAlive = new KeepAlive();
        
        keepAlive.activeEvents = null;
        keepAlive.extraData = null;
        keepAlive.providerId = null;
        
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
        assertNull(keepAlive.providerId);
    }

    @Test
    void testKeepAliveReassignment() {
        KeepAlive keepAlive = new KeepAlive();
        
        keepAlive.activeEvents = Arrays.asList(1, 2);
        keepAlive.providerId = 100;
        
        assertEquals(Arrays.asList(1, 2), keepAlive.activeEvents);
        assertEquals(100, keepAlive.providerId);
        
        keepAlive.activeEvents = Arrays.asList(3, 4);
        keepAlive.providerId = 200;
        
        assertEquals(Arrays.asList(3, 4), keepAlive.activeEvents);
        assertEquals(200, keepAlive.providerId);
    }

    @Test
    void testMultipleKeepAliveInstances() {
        KeepAlive keepAlive1 = new KeepAlive();
        KeepAlive keepAlive2 = new KeepAlive();
        
        keepAlive1.activeEvents = Arrays.asList(1, 2);
        keepAlive1.providerId = 111;
        
        keepAlive2.activeEvents = Arrays.asList(3, 4);
        keepAlive2.providerId = 222;
        
        assertEquals(Arrays.asList(1, 2), keepAlive1.activeEvents);
        assertEquals(Arrays.asList(3, 4), keepAlive2.activeEvents);
        assertEquals(111, keepAlive1.providerId);
        assertEquals(222, keepAlive2.providerId);
        assertNotSame(keepAlive1.activeEvents, keepAlive2.activeEvents);
    }

    @Test
    void testKeepAliveConsistency() {
        KeepAlive keepAlive1 = new KeepAlive();
        KeepAlive keepAlive2 = new KeepAlive();
        
        Iterable<Integer> testEvents = Arrays.asList(1, 2, 3);
        Integer testProviderId = 999;
        
        keepAlive1.activeEvents = testEvents;
        keepAlive1.providerId = testProviderId;
        
        keepAlive2.activeEvents = testEvents;
        keepAlive2.providerId = testProviderId;
        
        assertSame(keepAlive1.activeEvents, keepAlive2.activeEvents);
        assertEquals(keepAlive1.providerId, keepAlive2.providerId);
    }

    @Test
    void testKeepAliveEmptyCollections() {
        KeepAlive keepAlive = new KeepAlive();
        
        keepAlive.activeEvents = Collections.emptyList();
        keepAlive.extraData = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), keepAlive.activeEvents);
        assertEquals(Collections.emptyList(), keepAlive.extraData);
    }
}
