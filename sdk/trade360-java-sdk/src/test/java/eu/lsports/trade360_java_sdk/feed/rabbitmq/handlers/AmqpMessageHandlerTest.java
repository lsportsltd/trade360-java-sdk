package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import eu.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;

class AmqpMessageHandlerTest {
    private EntityRegistry entityRegistry;
    private AmqpMessageHandler handler;
    private EntityHandler<Object> entityHandler;

    @BeforeEach
    void setUp() {
        entityRegistry = mock(EntityRegistry.class);
        entityHandler = mock(EntityHandler.class);
        handler = new AmqpMessageHandler(entityRegistry);
    }

    private Message createMockMessage(String bodyJson) {
        Message message = mock(Message.class);
        MessageProperties messageProperties = mock(MessageProperties.class);
        Map<String, Object> headers = new HashMap<>();
        headers.put("MessageGuid", "test-guid-123");
        headers.put("MessageType", "TestMessage");
        headers.put("timestamp_in_ms", 1234567890L);
        
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        when(message.getMessageProperties()).thenReturn(messageProperties);
        when(messageProperties.getHeaders()).thenReturn(headers);
        when(messageProperties.getHeader("timestamp_in_ms")).thenReturn(1234567890L);
        return message;
    }

    @Test
    void testProcessValidMessageCallsEntityHandler() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = createMockMessage(bodyJson);
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(entityHandler);
        // Mock static method
        try (var mt = mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            doNothing().when(entityHandler).process(any(), any(), any());
            assertDoesNotThrow(() -> handler.process(message));
        }
    }

    @Test
    void processEntityHandlerNotFoundThrowsException() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = createMockMessage(bodyJson);
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(null);
        try (var mt = mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            assertThrows(Trade360Exception.class, () -> handler.process(message));
        }
    }

    @Test
    void testGetMessageTypeInvalidTypeThrowsException() throws Exception {
        var method = handler.getClass().getDeclaredMethod("getMessageType", int.class);
        method.setAccessible(true);
        try (var mt = mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(999)).thenThrow(new ClassNotFoundException());
            InvocationTargetException ex = assertThrows(InvocationTargetException.class, () -> method.invoke(handler, 999));
            assertInstanceOf(RabbitMQFeedException.class, ex.getCause());
        }
    }

    @Test
    void testGetTypeIdFromMessageInvalidHeaderThrowsException() throws Exception {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        var method = handler.getClass().getDeclaredMethod("getTypeIdFromMessage", Message.class);
        method.setAccessible(true);
        assertThrows(Exception.class, () -> method.invoke(handler, message));
    }

    @Test
    void testProcessWithMalformedJson() {
        String malformedJson = "{invalid json}";
        Message message = createMockMessage(malformedJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithMissingBodyProperty() {
        String bodyJson = "{\"Header\":{\"Type\":\"1\"}}";
        Message message = createMockMessage(bodyJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithMissingHeaderProperty() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"}}";
        Message message = createMockMessage(bodyJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithNullTypeInHeader() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":null}}";
        Message message = createMockMessage(bodyJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithEmptyTypeInHeader() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"\"}}";
        Message message = createMockMessage(bodyJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithInvalidTypeFormat() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"invalid\"}}";
        Message message = createMockMessage(bodyJson);
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testGetBodyFromMessage() throws Exception {
        String bodyJson = "{\"Body\":{\"testField\":\"testValue\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        var method = handler.getClass().getDeclaredMethod("getBodyFromMessage", Message.class);
        method.setAccessible(true);
        String result = (String) method.invoke(handler, message);
        
        assertNotNull(result);
        assertTrue(result.contains("testField"));
        assertTrue(result.contains("testValue"));
    }

    @Test
    void testGetHeaderFromMessage() throws Exception {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\",\"CustomHeader\":\"value\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        var method = handler.getClass().getDeclaredMethod("getHeaderFromMessage", Message.class);
        method.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, String> result = (Map<String, String>) method.invoke(handler, message);
        
        assertNotNull(result);
        assertEquals("1", result.get("Type"));
        assertEquals("value", result.get("CustomHeader"));
    }
}  
