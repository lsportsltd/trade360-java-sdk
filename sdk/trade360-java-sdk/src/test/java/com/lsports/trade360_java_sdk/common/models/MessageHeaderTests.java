package com.lsports.trade360_java_sdk.common.models;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MessageHeaderTests {

    @Test
    public void constructor_createsMessageHeaderWithDefaultValues() {
        // Act
        MessageHeader header = new MessageHeader();

        // Assert
        assertNotNull(header);
        assertEquals(0, header.type);
        assertNull(header.msgSeq);
        assertNull(header.msgGuid);
        assertNull(header.creationDate);
        assertEquals(0, header.serverTimestamp);
    }

    @Test
    public void type_canBeSet_andRetrieved() {
        // Arrange
        MessageHeader header = new MessageHeader();

        // Act
        header.type = 123;

        // Assert
        assertEquals(123, header.type);
    }

    @Test
    public void msgSeq_canBeSet_andRetrieved() {
        // Arrange
        MessageHeader header = new MessageHeader();

        // Act
        header.msgSeq = 456;

        // Assert
        assertEquals(Integer.valueOf(456), header.msgSeq);
    }

    @Test
    public void msgGuid_canBeSet_andRetrieved() {
        // Arrange
        MessageHeader header = new MessageHeader();
        String guid = "12345-67890-abcde";

        // Act
        header.msgGuid = guid;

        // Assert
        assertEquals(guid, header.msgGuid);
    }

    @Test
    public void creationDate_canBeSet_andRetrieved() {
        // Arrange
        MessageHeader header = new MessageHeader();
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 5, 12, 30);

        // Act
        header.creationDate = dateTime;

        // Assert
        assertEquals(dateTime, header.creationDate);
    }

    @Test
    public void serverTimestamp_canBeSet_andRetrieved() {
        // Arrange
        MessageHeader header = new MessageHeader();
        long timestamp = 1691234567890L;

        // Act
        header.serverTimestamp = timestamp;

        // Assert
        assertEquals(timestamp, header.serverTimestamp);
    }

    @Test
    public void allFields_canBeSetTogether() {
        // Arrange
        MessageHeader header = new MessageHeader();
        int type = 1;
        Integer msgSeq = 100;
        String msgGuid = "guid-123";
        LocalDateTime creationDate = LocalDateTime.now();
        long serverTimestamp = System.currentTimeMillis();

        // Act
        header.type = type;
        header.msgSeq = msgSeq;
        header.msgGuid = msgGuid;
        header.creationDate = creationDate;
        header.serverTimestamp = serverTimestamp;

        // Assert
        assertEquals(type, header.type);
        assertEquals(msgSeq, header.msgSeq);
        assertEquals(msgGuid, header.msgGuid);
        assertEquals(creationDate, header.creationDate);
        assertEquals(serverTimestamp, header.serverTimestamp);
    }

    @Test
    public void msgSeq_canBeNull() {
        // Arrange
        MessageHeader header = new MessageHeader();
        header.msgSeq = 100;

        // Act
        header.msgSeq = null;

        // Assert
        assertNull(header.msgSeq);
    }

    @Test
    public void msgGuid_canBeNull() {
        // Arrange
        MessageHeader header = new MessageHeader();
        header.msgGuid = "test";

        // Act
        header.msgGuid = null;

        // Assert
        assertNull(header.msgGuid);
    }

    @Test
    public void creationDate_canBeNull() {
        // Arrange
        MessageHeader header = new MessageHeader();
        header.creationDate = LocalDateTime.now();

        // Act
        header.creationDate = null;

        // Assert
        assertNull(header.creationDate);
    }
}

