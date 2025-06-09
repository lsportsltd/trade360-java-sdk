package eu.lsports.trade360_java_sdk.common.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class MessageHeaderTest {
    @Test
    void testInstantiation() {
        MessageHeader header = new MessageHeader();
        assertNotNull(header);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        MessageHeader header = new MessageHeader();
        assertEquals(0, header.type);
        assertNull(header.msgSeq);
        assertNull(header.msgGuid);
        assertNull(header.creationDate);
        assertEquals(0L, header.serverTimestamp);

        header.type = 1;
        header.msgSeq = 100;
        header.msgGuid = "guid-123";
        LocalDateTime now = LocalDateTime.now();
        header.creationDate = now;
        header.serverTimestamp = 123456789L;

        assertEquals(1, header.type);
        assertEquals(100, header.msgSeq);
        assertEquals("guid-123", header.msgGuid);
        assertEquals(now, header.creationDate);
        assertEquals(123456789L, header.serverTimestamp);
    }
} 