package eu.lsports.trade360_java_sdk.common.models;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MessageHeaderTests {

    @Test
    public void newInstance_hasDefaultValues() {
        MessageHeader header = new MessageHeader();
        
        assertEquals(0, header.type);
        assertNull(header.msgSeq);
        assertNull(header.msgGuid);
        assertNull(header.creationDate);
        assertEquals(0L, header.serverTimestamp);
        assertEquals(0L, header.messageBroketTimestamp);
    }

    @Test
    public void setType_storesValue() {
        MessageHeader header = new MessageHeader();
        
        header.type = 123;
        
        assertEquals(123, header.type);
    }

    @Test
    public void setMsgSeq_storesValue() {
        MessageHeader header = new MessageHeader();
        
        header.msgSeq = 456;
        
        assertEquals(Integer.valueOf(456), header.msgSeq);
    }

    @Test
    public void setMsgGuid_storesValue() {
        MessageHeader header = new MessageHeader();
        
        header.msgGuid = "guid-123";
        
        assertEquals("guid-123", header.msgGuid);
    }

    @Test
    public void setCreationDate_storesValue() {
        MessageHeader header = new MessageHeader();
        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 12, 0);
        
        header.creationDate = date;
        
        assertEquals(date, header.creationDate);
    }

    @Test
    public void setServerTimestamp_storesValue() {
        MessageHeader header = new MessageHeader();
        
        header.serverTimestamp = 1234567890L;
        
        assertEquals(1234567890L, header.serverTimestamp);
    }

    @Test
    public void setMessageBroketTimestamp_storesValue() {
        MessageHeader header = new MessageHeader();
        
        header.messageBroketTimestamp = 9876543210L;
        
        assertEquals(9876543210L, header.messageBroketTimestamp);
    }

    @Test
    public void setAllFields_storesAllValues() {
        MessageHeader header = new MessageHeader();
        LocalDateTime date = LocalDateTime.of(2024, 6, 15, 10, 30);
        
        header.type = 1;
        header.msgSeq = 100;
        header.msgGuid = "test-guid";
        header.creationDate = date;
        header.serverTimestamp = 111111L;
        header.messageBroketTimestamp = 222222L;
        
        assertEquals(1, header.type);
        assertEquals(Integer.valueOf(100), header.msgSeq);
        assertEquals("test-guid", header.msgGuid);
        assertEquals(date, header.creationDate);
        assertEquals(111111L, header.serverTimestamp);
        assertEquals(222222L, header.messageBroketTimestamp);
    }

    @Test
    public void setType_canOverwrite() {
        MessageHeader header = new MessageHeader();
        header.type = 1;
        
        header.type = 2;
        
        assertEquals(2, header.type);
    }

    @Test
    public void setMsgSeq_canSetToNull() {
        MessageHeader header = new MessageHeader();
        header.msgSeq = 100;
        
        header.msgSeq = null;
        
        assertNull(header.msgSeq);
    }

    @Test
    public void setMsgGuid_canSetToNull() {
        MessageHeader header = new MessageHeader();
        header.msgGuid = "test";
        
        header.msgGuid = null;
        
        assertNull(header.msgGuid);
    }

    @Test
    public void setCreationDate_canSetToNull() {
        MessageHeader header = new MessageHeader();
        header.creationDate = LocalDateTime.now();
        
        header.creationDate = null;
        
        assertNull(header.creationDate);
    }

    @Test
    public void setType_canBeZero() {
        MessageHeader header = new MessageHeader();
        
        header.type = 0;
        
        assertEquals(0, header.type);
    }

    @Test
    public void setType_canBeNegative() {
        MessageHeader header = new MessageHeader();
        
        header.type = -1;
        
        assertEquals(-1, header.type);
    }

    @Test
    public void setMsgSeq_canBeZero() {
        MessageHeader header = new MessageHeader();
        
        header.msgSeq = 0;
        
        assertEquals(Integer.valueOf(0), header.msgSeq);
    }

    @Test
    public void setMsgSeq_canBeNegative() {
        MessageHeader header = new MessageHeader();
        
        header.msgSeq = -1;
        
        assertEquals(Integer.valueOf(-1), header.msgSeq);
    }

    @Test
    public void setMsgGuid_canBeEmptyString() {
        MessageHeader header = new MessageHeader();
        
        header.msgGuid = "";
        
        assertEquals("", header.msgGuid);
    }

    @Test
    public void setMsgGuid_canContainSpecialCharacters() {
        MessageHeader header = new MessageHeader();
        
        header.msgGuid = "guid-with-dashes-!@#$%";
        
        assertEquals("guid-with-dashes-!@#$%", header.msgGuid);
    }

    @Test
    public void setServerTimestamp_canBeZero() {
        MessageHeader header = new MessageHeader();
        
        header.serverTimestamp = 0L;
        
        assertEquals(0L, header.serverTimestamp);
    }

    @Test
    public void setServerTimestamp_canBeNegative() {
        MessageHeader header = new MessageHeader();
        
        header.serverTimestamp = -1L;
        
        assertEquals(-1L, header.serverTimestamp);
    }

    @Test
    public void setServerTimestamp_canBeMaxValue() {
        MessageHeader header = new MessageHeader();
        
        header.serverTimestamp = Long.MAX_VALUE;
        
        assertEquals(Long.MAX_VALUE, header.serverTimestamp);
    }

    @Test
    public void setMessageBroketTimestamp_canBeZero() {
        MessageHeader header = new MessageHeader();
        
        header.messageBroketTimestamp = 0L;
        
        assertEquals(0L, header.messageBroketTimestamp);
    }

    @Test
    public void setMessageBroketTimestamp_canBeMaxValue() {
        MessageHeader header = new MessageHeader();
        
        header.messageBroketTimestamp = Long.MAX_VALUE;
        
        assertEquals(Long.MAX_VALUE, header.messageBroketTimestamp);
    }

    @Test
    public void setCreationDate_withFutureDate_storesCorrectly() {
        MessageHeader header = new MessageHeader();
        LocalDateTime futureDate = LocalDateTime.of(2099, 12, 31, 23, 59);
        
        header.creationDate = futureDate;
        
        assertEquals(futureDate, header.creationDate);
    }

    @Test
    public void setCreationDate_withPastDate_storesCorrectly() {
        MessageHeader header = new MessageHeader();
        LocalDateTime pastDate = LocalDateTime.of(1970, 1, 1, 0, 0);
        
        header.creationDate = pastDate;
        
        assertEquals(pastDate, header.creationDate);
    }

    @Test
    public void fields_canBeSetIndependently() {
        MessageHeader header = new MessageHeader();
        
        header.type = 1;
        assertEquals(1, header.type);
        assertNull(header.msgSeq);
        
        header.msgSeq = 10;
        assertEquals(Integer.valueOf(10), header.msgSeq);
        assertNull(header.msgGuid);
        
        header.msgGuid = "guid";
        assertEquals("guid", header.msgGuid);
        assertNull(header.creationDate);
    }
}

