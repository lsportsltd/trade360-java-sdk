package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.core.Message;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;

class AmqpMessageHandlerTest {
    private EntityRegistry entityRegistry;
    private AmqpMessageHandler handler;
    private EntityHandler entityHandler;

    @BeforeEach
    void setUp() {
        entityRegistry = mock(EntityRegistry.class);
        entityHandler = mock(EntityHandler.class);
        handler = new AmqpMessageHandler(entityRegistry);
    }

    @Test
    void testProcess_ValidMessage_CallsEntityHandler() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(entityHandler);
        // Mock static method
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            doNothing().when(entityHandler).process(any(), any());
            assertDoesNotThrow(() -> handler.process(message));
        }
    }

    @Test
    void testProcess_EntityHandlerNotFound_ThrowsException() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(null);
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            assertThrows(Trade360Exception.class, () -> handler.process(message));
        }
    }

    @Test
    void testGetMessageType_InvalidType_ThrowsException() throws Exception {
        var method = handler.getClass().getDeclaredMethod("getMessageType", int.class);
        method.setAccessible(true);
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(999)).thenReturn(null);
            InvocationTargetException ex = assertThrows(InvocationTargetException.class, () -> method.invoke(handler, 999));
            assertTrue(ex.getCause() instanceof RabbitMQFeedException);
        }
    }

    @Test
    void testGetTypeIdFromMessage_InvalidHeader_ThrowsException() throws Exception {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        var method = handler.getClass().getDeclaredMethod("getTypeIdFromMessage", Message.class);
        method.setAccessible(true);
        assertThrows(Exception.class, () -> method.invoke(handler, message));
    }
} 