package com.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTypeTests {

    @Test
    public void getValue_forFixtureMetadataUpdate_returns1() {
        // Act
        int value = MessageType.FixtureMetadataUpdate.getValue();

        // Assert
        assertEquals(1, value);
    }

    @Test
    public void getValue_forLivescoreUpdate_returns2() {
        // Act
        int value = MessageType.LivescoreUpdate.getValue();

        // Assert
        assertEquals(2, value);
    }

    @Test
    public void getValue_forMarketUpdate_returns3() {
        // Act
        int value = MessageType.MarketUpdate.getValue();

        // Assert
        assertEquals(3, value);
    }

    @Test
    public void getValue_forKeepAliveUpdate_returns31() {
        // Act
        int value = MessageType.KeepAliveUpdate.getValue();

        // Assert
        assertEquals(31, value);
    }

    @Test
    public void getValue_forHeartbeatUpdate_returns32() {
        // Act
        int value = MessageType.HeartbeatUpdate.getValue();

        // Assert
        assertEquals(32, value);
    }

    @Test
    public void getValue_forSettlementUpdate_returns35() {
        // Act
        int value = MessageType.SettlementUpdate.getValue();

        // Assert
        assertEquals(35, value);
    }

    @Test
    public void findMessageType_withValidTypeId_returnsCorrectType() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(1);

        // Assert
        assertEquals(MessageType.FixtureMetadataUpdate, result);
    }

    @Test
    public void findMessageType_withLivescoreUpdateId_returnsLivescoreUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(2);

        // Assert
        assertEquals(MessageType.LivescoreUpdate, result);
    }

    @Test
    public void findMessageType_withMarketUpdateId_returnsMarketUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(3);

        // Assert
        assertEquals(MessageType.MarketUpdate, result);
    }

    @Test
    public void findMessageType_withKeepAliveUpdateId_returnsKeepAliveUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(31);

        // Assert
        assertEquals(MessageType.KeepAliveUpdate, result);
    }

    @Test
    public void findMessageType_withHeartbeatUpdateId_returnsHeartbeatUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(32);

        // Assert
        assertEquals(MessageType.HeartbeatUpdate, result);
    }

    @Test
    public void findMessageType_withSettlementUpdateId_returnsSettlementUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(35);

        // Assert
        assertEquals(MessageType.SettlementUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightFixtureUpdateId_returnsOutrightFixtureUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(37);

        // Assert
        assertEquals(MessageType.OutrightFixtureUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightLeagueUpdateId_returnsOutrightLeagueUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(38);

        // Assert
        assertEquals(MessageType.OutrightLeagueUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightScoreUpdateId_returnsOutrightScoreUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(39);

        // Assert
        assertEquals(MessageType.OutrightScoreUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightLeagueMarketUpdateId_returnsOutrightLeagueMarketUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(40);

        // Assert
        assertEquals(MessageType.OutrightLeagueMarketUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightFixtureMarketUpdateId_returnsOutrightFixtureMarketUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(41);

        // Assert
        assertEquals(MessageType.OutrightFixtureMarketUpdate, result);
    }

    @Test
    public void findMessageType_withOutrightSettlementsUpdateId_returnsOutrightSettlementsUpdate() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(42);

        // Assert
        assertEquals(MessageType.OutrightSettlementsUpdate, result);
    }

    @Test
    public void findMessageType_withInvalidTypeId_returnsNull() throws ClassNotFoundException {
        // Act
        MessageType result = MessageType.findMessageType(999);

        // Assert
        assertNull(result);
    }

    @Test
    public void setValue_whenCalled_updatesValue() {
        // Arrange
        MessageType type = MessageType.FixtureMetadataUpdate;
        int originalValue = type.getValue();

        // Act
        type.setValue(100);

        // Assert
        assertEquals(100, type.getValue());
        
        // Cleanup - restore original value
        type.setValue(originalValue);
    }

    @Test
    public void values_whenCalled_returnsAllMessageTypes() {
        // Act
        MessageType[] values = MessageType.values();

        // Assert
        assertEquals(12, values.length);
    }

    @Test
    public void valueOf_withValidName_returnsCorrectType() {
        // Act
        MessageType type = MessageType.valueOf("LivescoreUpdate");

        // Assert
        assertEquals(MessageType.LivescoreUpdate, type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_withInvalidName_throwsException() {
        // Act
        MessageType.valueOf("InvalidType");
    }
}

